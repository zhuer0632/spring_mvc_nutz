package com.me.biz;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.me.ut.DateTimeUT;
import com.me.ut.StringUT;

@Controller
public class test01Biz
{

	@Autowired
	private JdbcTemplate dao;

	@Autowired
	private JdbcTemplate dao2;

	public void test00() throws SQLException
	{
		System.out.println(dao.getDataSource().getConnection());
		System.out.println(dao2.getDataSource().getConnection());
	}

	@Transactional
	public void test01() throws Exception
	{
		// 访问了该表
		String id = StringUT.getUUID();
		Timestamp time = DateTimeUT.getNowstamp();
		String insertSql = "insert into t_person(ID,birthday,age,userName,gender) values('"
				+ id + "','" + time + "',22,'zhang',0)";
		dao.execute(insertSql);

		// 测试能不能读取 meta
		Statement st = dao.getDataSource().getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from t_person where 1!=1 ");
		ResultSetMetaData meta = rs.getMetaData();
		System.out.println(meta);

	}

	/**
	 * 
	 * 同一个事务中,先访问一个操作一个表，然后内部创建另一个conn，用第二个conn访问同一个表。
	 * 
	 */
	public static void test02_main() throws Exception
	{
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection(	"jdbc:jtds:sqlserver://127.0.0.1:1433;databaseName=db_spring;SelectMethod=cursor",
								"sa",
								"");
		conn.setAutoCommit(false);

		// 锁住表
		Statement st = conn.createStatement();
		String id = StringUT.getUUID();
		Timestamp time = DateTimeUT.getNowstamp();
		String insertSql = "insert into t_person(ID,birthday,age,userName,gender) values('"
				+ id + "','" + time + "',22,'zhang',0)";
		st.execute(insertSql);

		// 开启第二个事务 访问同一个表
		Connection conn2 = DriverManager
				.getConnection(	"jdbc:jtds:sqlserver://127.0.0.1:1433;databaseName=db_spring;SelectMethod=cursor",
								"sa",
								"");
		conn2.setAutoCommit(false);

		Statement st2 = conn2.createStatement();
		st2.execute("delete from t_person"); // 执行第二次访问务，这个时候无法访问，以为表已经被锁住了。
		conn2.commit();

		conn.commit();
		st.close();
		conn.close();

	}

	/**
	 * 
	 * 同一个事务中,先用一个conn访问表，然后再访问同一个表。
	 * 
	 */
	public static void test03_main() throws Exception
	{
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection(	"jdbc:jtds:sqlserver://127.0.0.1:1433;databaseName=db_spring;SelectMethod=cursor",
								"sa",
								"");
		conn.setAutoCommit(false);

		// 锁住表
		Statement st = conn.createStatement();
		String id = StringUT.getUUID();
		Timestamp time = DateTimeUT.getNowstamp();
		String insertSql = "insert into t_person(ID,birthday,age,userName,gender) values('"
				+ id + "','" + time + "',22,'zhang',0)";
		st.execute(insertSql);

		// getResultMeta
		Statement st2 = conn.createStatement();
		ResultSet set = st2.executeQuery("select * from t_person where 1!=1"); // 执行第二次访问务，这个时候无法访问，以为表已经被锁住了。
		ResultSetMetaData metadata = set.getMetaData();
		System.out.println(metadata);
		
		conn.commit();
		
		st.close();
		conn.close();

	}

	public static void main(String[] args) throws Exception
	{
		test03_main();
	}

}
