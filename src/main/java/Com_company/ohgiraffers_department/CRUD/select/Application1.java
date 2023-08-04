package Com_company.ohgiraffers_department.CRUD.select;

import Com_company.ohgiraffers_department.model.DTO.DepartmentDTO;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import static Com_company.ohgiraffers_department.common.JDBCTemplate.close;
import static Com_company.ohgiraffers_department.common.JDBCTemplate.getConnection;

public class Application1 {


    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;


        Properties prop = new Properties();

        Scanner sc = new Scanner(System.in);

        System.out.println("사원번호를 입력하세요");
        int id = sc.nextInt();

        ArrayList<DepartmentDTO> dtoList = new ArrayList<DepartmentDTO>();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/Com_company/ohgiraffers_department/mapper/department-query.xml"));
            String query = prop.getProperty("selectPerson");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            rset = pstmt.executeQuery();


            while (rset.next()) {


                String personId = rset.getString("EMP_ID");
                String personName = rset.getString("EMP_NAME");
                String personNumber = rset.getString("EMP_NO");

                DepartmentDTO dto = new DepartmentDTO(personId, personName, personNumber);
                dtoList.add(dto);

            }
            for (DepartmentDTO depdto : dtoList) {
                System.out.println(depdto.getEmpId() +
                        " 사원번호인 " + depdto.getEmpName() +
                        " 직원의 주민번호는 " + depdto.getEmpNo() + " 입니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }

    }
}



