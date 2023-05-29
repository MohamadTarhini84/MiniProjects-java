/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBManager {
    private static String HOST = "localhost";
    private static String DBNAME = "java_test";
    private static String USER = "root";
    private static String PWD = "admin";
    private static int PORT = 3306;
    
   private static Connection CON;

    public static Connection getConnection() {        
        try {
            if(CON!=null && !CON.isClosed()) return CON;
            //Class.forName("com.mysql.jdbc.Driver"); 
            CON= DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME, USER, PWD);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return CON;
    }

    public static void setHOST(String HOST) {DBManager.HOST = HOST;}
    public static void setDBNAME(String DBNAME) {DBManager.DBNAME = DBNAME;}
    public static void setUSER(String USER) {DBManager.USER = USER;}
    public static void setPWD(String PWD) {DBManager.PWD = PWD;}
    public static void setPORT(int PORT) {DBManager.PORT = PORT;}
    public static String getHOST() {return HOST;}
    public static String getDBNAME() {return DBNAME;}
    public static String getUSER() {return USER;}
    public static String getPWD() {return PWD;}
    public static int getPORT() {return PORT;}
}
