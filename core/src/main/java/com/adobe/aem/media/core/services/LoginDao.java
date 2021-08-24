package com.adobe.aem.media.core.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public boolean vaildate(People people)
    {
        boolean result = false;
        Connection connection=DBConnect.getConn();
        String sql="select * from aemdb.people where emai=? and password=?";
        try {
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM aemdb.people where email=? and password=?");
            ps.setString(1, people.getEmail());
            ps.setString(2, people.getPassword());
            ResultSet rs=ps.executeQuery();
            result=rs.next();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
