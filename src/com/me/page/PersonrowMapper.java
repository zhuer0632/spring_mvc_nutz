package com.me.page;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.me.domain.VOPerson;


public class PersonrowMapper implements ParameterizedRowMapper<VOPerson>
{
    public VOPerson mapRow(ResultSet rs, int idx) throws SQLException
    {
        VOPerson vo = new VOPerson();

        vo.setAge(rs.getInt("age"));
        vo.setUserName(rs.getString("userName"));
        vo.setBirthday(rs.getTimestamp("birthday"));
        vo.setGender(rs.getBoolean("gender"));
        return vo;
    }

}
