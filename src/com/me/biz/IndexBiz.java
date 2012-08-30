package com.me.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexBiz
{

	@Autowired
	private PersonBiz personBiz;

	public void getPerson(ModelAndView mod)
	{
		mod.addObject("user", personBiz.getPerson());
	}

}
