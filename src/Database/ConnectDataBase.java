/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author hp
 */
import com.mysql.jdbc.Driver;

import java.sql.*;

public class ConnectDataBase {
   private Connection conn;
   private String url;
   private String dbName;
   private String driver;
   private String userName; 
   private String password;

   public ConnectDataBase() throws SQLException
   {
      //driver = new org.gjt.mm.mysql.Driver();
       url = "jdbc:mysql://localhost:3306/";
       dbName = "qlba";
       driver = "com.mysql.jdbc.Driver";
       userName = "root";//username tuy may moi nguoi khac nhau
       password = "Oanh2004!";//password tuy may moi nguoi khac nhau
       connect();

   }
   public ConnectDataBase(String url, String dbName, String driver, String userName, String password) {
      this.url = url;
      this.dbName = dbName;
      this.driver = driver;
      this.userName = userName;
      this.password = password;
   }

   private void connect() throws SQLException {
      if (conn != null) {
         return;
      }
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException e) {
         throw new SQLException("Driver not found");
      }
      conn = DriverManager.getConnection(url + dbName, userName, password);
   }

   public void disconnect() throws SQLException {
      if (conn != null) {
         conn.close();
         conn = null;
      }
   }

   public void executeQuery(String sql) throws SQLException {
      connect();
      Statement statement = conn.createStatement();
      statement.executeQuery(sql);
      statement.close();
   }

   public void executeUpdate(String sql) throws SQLException {
      connect();
      Statement statement = conn.createStatement();
      statement.executeUpdate(sql);
      statement.close();
   }

   public ResultSet executeSelect(String sql) throws SQLException {
      connect();
      Statement statement = conn.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      return resultSet;
   }
    public static void main(String[] args) throws SQLException {
        ConnectDataBase cn=new ConnectDataBase();
        if(cn.conn==null)
        {
            System.out.println("Kết nối thất bạii");
        }
        else
            System.out.println("Kêt nối thành công");
        String sql="Select * from nhanvien";
        ResultSet rs=cn.executeSelect(sql);
        while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) 
                        + "  " + rs.getString(3));
                //hien thi len textfild
              
            }
    }
   
}