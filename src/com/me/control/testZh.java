package com.me.control;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("testZh")
public class testZh
{
    
    @RequestMapping("index")
    public ModelAndView  index()
    {
        ModelAndView mod=new ModelAndView();
        mod.setViewName("chinese");
        return mod;
    }
    
    //详细说明参见：http://nutz.cn/M6
    @RequestMapping("chinese")
    public ModelAndView  chinese(@RequestParam("args")String aa)
    {
        ModelAndView mod=new ModelAndView();
        mod.setViewName("login");
        
        
        try
        {
            //当浏览器中的参数含有中文的时候，进行了urlencode编码，后台不用再反编码。
            // System.out.println(new String(aa.getBytes("ISO-8859-1")));
            System.out.println(new String(aa.getBytes("ISO-8859-1"),"UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        return mod;
    }
    
}
