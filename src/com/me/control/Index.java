package com.me.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.me.biz.IndexBiz;

@RequestMapping("Index")
@Controller
public class Index
{

	@Autowired
	private IndexBiz indexBiz;

	@RequestMapping("index")
	public ModelAndView index()
	{
		ModelAndView mod = new ModelAndView();
		try
		{
			 indexBiz.getPerson(mod);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		mod.setViewName("index");
		return mod;
	}
}
