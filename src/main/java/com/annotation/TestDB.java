package com.annotation;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @program: MavenTest0329
 * @description:
 * @author: Dasiy
 * @create: 2021-03-29 21:12
 */
@DBConnection(url = "jdbc:mysql://Localhost:3306/test?serverTimezone=UTC",driverClass = "com.mysql.cj.jdbc.Driver")
public class TestDB {
    public static void main(String[] args) {
        Class c=TestDB.class;

        DBConnection dbc=(DBConnection) c.getDeclaredAnnotation(DBConnection.class);
        String dri=dbc.driverClass();
        String url=dbc.url();
        String user=dbc.user();
        String pwd=dbc.pwd();


        try {
            Class.forName(dri);
            Connection con= DriverManager.getConnection(url,user,pwd);
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
