package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application04 {
    public static void main(String[] args) {

        // 조회한 객체를 DTO 에 담기
        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회하실 사번을 입력해 주세요. : ");
        String empId = sc.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID =" + empId;

        EmployeeDto selectEmp = new EmployeeDto();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(stmt);
            close(rset);
        }

        System.out.println("selectEmp = " + selectEmp);
    }
}
