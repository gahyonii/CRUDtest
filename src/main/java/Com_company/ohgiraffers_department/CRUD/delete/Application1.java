package Com_company.ohgiraffers_department.CRUD.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static Com_company.ohgiraffers_department.common.JDBCTemplate.close;
import static Com_company.ohgiraffers_department.common.JDBCTemplate.getConnection;

public class Application1  {

    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        int result = 0;

        Properties prop = new Properties();

        Scanner sc = new Scanner(System.in);

        System.out.println("사원번호를 입력하세요");
        int id = sc.nextInt();


        try {
            prop.loadFromXML(new FileInputStream("src/main/java/Com_company/ohgiraffers_department/mapper/department-query.xml"));


            String query = prop.getProperty("deletePerson");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }

        System.out.println("result : " + result);




    }
}

