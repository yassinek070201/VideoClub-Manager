/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author casco
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBAccess {

    String cadenaConexion = "jdbc:mysql://localhost:3306/videoclub";
    Connection conexion = null;

    public DBAccess() {
        try {
            this.conexion = DriverManager.getConnection(cadenaConexion, "DB_User", "DB_Password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            System.out.print("Ha ocurrido un error al intentar conectarme: ");
            System.out.println(e.toString());
        } 
    }
}
