package com.ohgiraffers.section02;

import com.ohgiraffers.common.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application03 {
    public static void main(String[] args) {
        // 성씨를 입력 받아 해당 성을 가진 사원 조회

        // jdbc 3종 세트
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 성씨를 입력해 주세요. : ");
        String firstName = sc.nextLine();

        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE CONCAT(?,'%')";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, firstName);
            System.out.println(pstmt);
            rset = pstmt.executeQuery();

            while(rset.next()) {
                System.out.println(rset.getString(1) + " " + rset.getString(2));
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
