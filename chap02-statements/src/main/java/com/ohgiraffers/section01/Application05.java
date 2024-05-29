package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application05 {
    public static void main(String[] args) {
        // 여러 DTO 를 LIST 로 묶어서 조회

        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        // 한 행의 정보를 담을 DTO
        EmployeeDto row = null;

        // 여러 DTO 를 묶을 LIST
        List<EmployeeDto> emplist = null;

        String query = "SELECT * FROM EMPLOYEE";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            emplist = new ArrayList<>();

            while (rset.next()) {
                row = new EmployeeDto();


                emplist.add(row);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(stmt);
            close(rset);
        }

        for (EmployeeDto emp : emplist) {
            System.out.println(emp);
        }
    }
}
