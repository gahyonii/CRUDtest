package Com_company.ohgiraffers_department.CRUD.insert;

import Com_company.ohgiraffers_department.model.DTO.DepartmentDTO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


import static Com_company.ohgiraffers_department.common.JDBCTemplate.close;
import static Com_company.ohgiraffers_department.common.JDBCTemplate.getConnection;
import static java.sql.DriverManager.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        int result = 0;

        Properties prop = new Properties();

        Scanner sc = new Scanner(System.in);

        System.out.println("사원번호를 입력하세요");
        String id = sc.next();
        System.out.println("직원명를 입력하세요");
        String name = sc.next();
        System.out.println("주민번호를 입력하세요");
        String number = sc.next();
        System.out.println("직업분류번호를 입력하세요");
        String jobnumber = sc.next();
        System.out.println("급여수준을 입력하세요");
        String sallv = sc.next();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/Com_company/ohgiraffers_department/mapper/department-query.xml"));

            String query = prop.getProperty("insertPerson");

            DepartmentDTO dto = new DepartmentDTO(id, name, number, jobnumber, sallv);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, dto.getEmpId());
            pstmt.setString(2, dto.getEmpName());
            pstmt.setString(3, dto.getEmpNo());
            pstmt.setString(4, dto.getJobCode());
            pstmt.setString(5, dto.getSalLevel());



            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }

        System.out.println("result : " + result);


    }
}

