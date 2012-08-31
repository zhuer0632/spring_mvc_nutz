package com.me.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

import com.me.ut.StringUT;

/**
 * 
 * 数据库中的字段 ID birthday age userName gender
 * 
 * @author zhu
 */
@Table("t_person")
public class VOPerson
{

	// ID
	// birthday
	// age
	// userName
	// gender
	@Name
	@ColDefine(width = 32)
	private String ID;

	private String userName;
	private int age;
	private boolean gender;
	private Date birthday;

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isGender()
	{
		return gender;
	}

	public void setGender(boolean gender)
	{
		this.gender = gender;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public static void main(String[] args)
	{
		VOPerson vo = new VOPerson();
		vo.init();
	}

	private void init()
	{
		VOPerson vo = new VOPerson();

		vo.setID(StringUT.getUUID());
		vo.setAge(22);
		vo.setBirthday(new Date());
		vo.setGender(false);
		vo.setUserName("zhang");
		dao.create(VOPerson.class, false);
		dao.insert(vo);
	}

	private NutDao dao = new NutDao();
	private SimpleDataSource ds = new SimpleDataSource();
	{
		try
		{
			ds.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:jtds:sqlserver://localhost:1433/db_springmvc_nutz");
		ds.setUsername("sa");
		ds.setPassword("");
		dao.setDataSource(ds);
	}

	public static VOPerson create()
	{
		VOPerson vo = new VOPerson();
		vo.setID(StringUT.getUUID());
		vo.setAge(22);
		vo.setBirthday(new Date());
		vo.setGender(false);
		vo.setUserName("zhang");
		return vo;
	}

}
