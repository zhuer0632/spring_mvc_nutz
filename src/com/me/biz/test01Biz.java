package com.me.biz;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.me.domain.VOPerson;
import com.me.ut.DateTimeUT;
import com.me.ut.StringUT;

@Controller
public class test01Biz
{

	@Autowired
	private NutDao dao;


	@Autowired
	private NutDao dao2;

	public static void main(String[] args) throws Exception
	{
		 
	}

	public void test00()
	{
		System.out.println(dao);
		System.out.println(dao2);
		Trans.exec(new Atom()
		{
			public void run()
			{
				//当表t_person中有记录的时候，执行到46行会卡主[原因是nutzDao中一个事务中使用了多条数据库连接，表被锁住了]
				//解决方法：SysInit.java
				dao.execute(Sqls.create("delete from t_person"));
				dao.insert(VOPerson.create());
				System.out.println("over");
			}
		});
	}

}
