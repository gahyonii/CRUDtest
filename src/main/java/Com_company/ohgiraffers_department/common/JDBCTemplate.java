package Com_company.ohgiraffers_department.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    //다른 어플리케이션들에서 DB연동시 여기서 getConnection()으로 연결한 코드를 갖다 쓰라고 여기다가 작성. 공통으로 사용할 것을 여기다가 작성
    public static Connection getConnection() {
        //여기서의 Connection이 DBCP의 그 오고가는 학종이의 종이 역할(커넥션공).
        Connection con = null;
        Properties prop = new Properties();


        try {
            prop.load(new FileReader("src/main/java/Com_company/ohgiraffers_department/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, prop);



        } catch (IOException e) {   //입출력에러
            e.printStackTrace();
        } catch (ClassNotFoundException e) {   //DB연동 자체가 안될경우
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return con;
    }

    public static void close(Connection con) {


        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
    try {
      if(stmt != null && !stmt.isClosed()) {
           stmt.close();
      }
    } catch (SQLException e) {
          e.printStackTrace();
    }
    }
    public static void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
