package com.ohgiraffers.section01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application02 {
    public static void main(String[] args) {

        // 변수에 담아서 변수를 매개변수로 넘겨주는 방법

        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "songpa";
        String password = "songpa";

        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
