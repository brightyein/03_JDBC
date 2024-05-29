package com.ohgiraffers.understand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String query = "SELECT EMP_NAME FROM employee ORDER BY SALARY DESC LIMIT 1";
        String query2 = "SELECT EMP_ID, EMP_NAME, PHONE, JOB.JOB_NAME FROM employee " +
                "JOIN JOB ON JOB.JOB_CODE = EMPLOYEE.JOB_CODE WHERE EMP_NAME = '" + input + "'";

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println("월급왕은 " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            pstmt = con.prepareStatement(query2);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME")
                + " " + rset.getString("PHONE") + " " + rset.getString("JOB_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }

    }
}
