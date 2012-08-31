package com.me.control;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.biz.test01Biz;

@Controller
@RequestMapping("testTrans")
public class testTrans
{

	@Autowired
	private test01Biz test01Biz;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("test00")
	public @ResponseBody
	Map test00()
	{
		Map map = new HashMap();
		try
		{
			test01Biz.test00();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	
	


}
