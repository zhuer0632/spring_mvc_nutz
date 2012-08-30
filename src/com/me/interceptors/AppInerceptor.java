package com.me.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.me.ut.WebPath;

@Component
public class AppInerceptor implements HandlerInterceptor
{

    // 返回视图后执行
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)
                                             throws Exception
    {

    }


    // 控制器执行完，返回视图前执行
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView mod)
                                            throws Exception
    {
        if (mod != null)
        {
            // 设置公共参数
//            String cityName = XmlUtil.getInstance().getValue("sys/cityName");
//            mod.addObject("cityName",  cityName);
        	
            // 取得当前连接所在的页面
            mod.addObject("preurl",
                          WebPath.getPreUrl(request));

        }
    }


    // 进入控制器之前执行
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
                                            throws Exception
    {
        //Pager.DEFAULT_PAGE_SIZE = 20;
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("content-type",
                             "text/html;charset=UTF-8");

        return true;
    }
}
