package com.me.biz;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.me.domain.VOPerson;
import com.me.page.CurrentPage;
import com.me.page.PaginationHelper;
import com.me.page.PersonrowMapper;
import com.me.ut.DateTimeUT;
import com.me.ut.StringUT;


@Controller
public class PersonBiz
{
    @Autowired
    private JdbcTemplate dao;


    public List<VOPerson> listPerons()
    {
        List<VOPerson> list = new ArrayList<VOPerson>();
        list = dao.queryForList(
                "select * from t_person",
                VOPerson.class);
        return list;
    }


    public VOPerson getPerson()
    {

        VOPerson vo = new VOPerson();
        System.out.println(dao);

        vo.setUserName("zhang");
        return vo;

    }


    @Transactional
    public void addperson()
    {
        String id = StringUT.getUUID();
        Timestamp time = DateTimeUT.getNowstamp();
        String insertSql = "insert into t_person(ID,birthday,age,userName,gender) values('" + id + "','" + time + "',22,'zhang',0)";
        dao.execute(insertSql);

        insertSql = "insert into t_person(ID,birthday,age,userName,gender) values('" + id + "','" + time + "',22,'zhang',1)";
        dao.execute(insertSql);
        StringUT.print(insertSql);

    }


    public static final int pageNum = 3;
    public static final int pageSize = 20;


    /**
     * 测试jdbcTemplate的分页功能
     */
    public List<VOPerson> pagerSearch()
    {
        List<VOPerson> persons = new ArrayList<VOPerson>();

        PaginationHelper<VOPerson> ph = new PaginationHelper<VOPerson>();
        
        CurrentPage<VOPerson> p = ph.fetchPage(
                dao,
                "SELECT count(*) FROM t_person WHERE age=?",
                "SELECT * FROM t_person WHERE age=?",
                new Object[]
                {
                    22
                },
                pageNum,
                pageSize,
                new PersonrowMapper());
        
        persons = p.getPageItems();
        return persons;
    }


    public static void main(
                            String[] args)
    {
        PersonBiz biz = new PersonBiz();
        biz.test01();
    }


    private void test01()
    {
        ApplicationContext app = new ClassPathXmlApplicationContext(new String[]
        {
            "beans.xml"
        });
        dao = (JdbcTemplate) app.getBean("jdbcTemplate");
        pagerSearch();
    }

}
