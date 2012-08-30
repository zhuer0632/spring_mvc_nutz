package com.me.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class BaseExceptionHandler implements HandlerExceptionResolver
{

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response,
			Object obj,
			Exception ex)
	{
		ModelAndView mod = new ModelAndView();
		if (ex instanceof org.springframework.web.HttpSessionRequiredException)
		{
			// StringUT.print("超时，session过期。");
			// ModelAndViewUT.addDivErr(mod, "登录超时");
			mod.setViewName("redirect:/login/login.do");
			return mod;
		}
		return new ModelAndView("error");
	}
}
