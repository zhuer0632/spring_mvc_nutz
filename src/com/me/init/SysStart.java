package com.me.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.impl.NutDao;
import org.nutz.resource.Scans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoaderListener;

import com.me.ut.WebPath;

@Controller
public class SysStart extends ContextLoaderListener implements
		ServletContextListener
{

	@Autowired
	private NutDao dao;

	@Override
	public void contextDestroyed(ServletContextEvent event)
	{
	}

	@Override
	public void contextInitialized(ServletContextEvent event)
	{
		String syspath = event.getServletContext().getContextPath();
		WebPath.SYS_PATH = syspath;
		System.out.println("当前项目名称：" + syspath);

		// 此处事先加载所有的 Nutz Entity。

		// 注意整个系统中的Nutz需要保证单例

		
		System.out.println(dao);
//		for (Class<?> klass : Scans.me().scanPackage("com.me.domain"))
//		{
//			if (klass.getAnnotation(Table.class) != null)
//			{
//				System.out.println("加载vo信息" + klass.getSimpleName());
//				dao.exists(klass);
//			}
//		}

	}

}
