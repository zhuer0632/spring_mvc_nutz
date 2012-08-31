package com.me.biz;

import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
@Controller
public class PersonBiz
{
	@Autowired
	private NutDao dao;

}
