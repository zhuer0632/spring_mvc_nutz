package com.me.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.me.biz.PersonBiz;


@Controller
@RequestMapping("person")
public class person
{

    @Autowired
    private PersonBiz personBiz;


    @RequestMapping("addperson")
    public ModelAndView addperson()
    {
        ModelAndView mod = new ModelAndView();
        try
        {
            personBiz.addperson();
        }
        catch (Exception e)
        {
            //spring的异常类都是继承自RuntimeException
            System.out.println(e.getClass().getName());
            e.printStackTrace();
        }
        mod.setViewName("index");
        return mod;
    }

}
