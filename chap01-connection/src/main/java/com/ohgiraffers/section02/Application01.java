package com.ohgiraffers.section02;

import java.sql.Connection;

import static com.ohgiraffers.section02.JDBCTemplate.close;
import static com.ohgiraffers.section02.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {
        Connection con = getConnection();
        System.out.println(con);
        close(con);
    }
}
