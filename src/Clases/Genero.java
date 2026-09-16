/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author casco
 */
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Genero {

    public Genero() {
    }

    public ArrayList mostrar() {
        DBAccess aceso = new DBAccess();
        ArrayList<String> generos = new ArrayList<>();
        try {
            String consulta = "SELECT nombre FROM genero";
            Statement state = aceso.conexion.createStatement();
            ResultSet result = state.executeQuery(consulta);
            while (result.next()) {
                String genero2 = result.getString("nombre");
                generos.add(genero2);
            }
            return generos;
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        } finally {
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.close();
                    return generos;
                }
                return generos;
            } catch (Exception e2) {
                System.out.println(e2.toString());
                return null;
            }
        }
    }

    public int sacarId(Object genero) {
        DBAccess aceso = new DBAccess();
        int idgenero = 0;
        try {
            String consulta = "SELECT id From genero WHERE nombre = '" + genero + "'";
            Statement state = aceso.conexion.createStatement();
            ResultSet result = state.executeQuery(consulta);

            while (result.next()) {
                idgenero = result.getInt("id");
            }
            return idgenero;
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        } finally {
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.close();
                    return idgenero;
                }
                return idgenero;
            } catch (Exception e2) {
                System.out.println(e2.toString());
                return idgenero;
            }
        }
    }
}
