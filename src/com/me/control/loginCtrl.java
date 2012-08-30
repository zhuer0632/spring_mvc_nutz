package com.me.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("login")
@Controller
public class loginCtrl
{
	@RequestMapping("logins")
	public ModelAndView logins()
	{
		ModelAndView mod = new ModelAndView();
		mod.setViewName("login");
		return mod;
	}
}
