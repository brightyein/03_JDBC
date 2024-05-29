package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {

        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));
            String url = prop.getProperty("url");

            con = DriverManager.getConnection(url, prop);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }


    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // statement = 쿼리문을 저장하고 실행하는 기능을 가진 인터페이스
    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ResultSet - select 의 결과 집합을 받아오는 용도의 인터페이스
    public static void close(ResultSet rset) {
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
