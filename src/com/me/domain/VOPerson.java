package com.me.domain;

import java.util.Date;

/**
 * 
 * 数据库中的字段
 *  ID  birthday  age  userName  gender
 * @author zhu
 */
public class VOPerson
{

	// ID
	// birthday
	// age
	// userName
	// gender

	private String userName;
	private int age;
	private boolean gender;
	private Date birthday;
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

	 

}
