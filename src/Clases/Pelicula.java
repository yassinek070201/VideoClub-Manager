/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author casco
 */
public class Pelicula {

    public Pelicula() {
    }

    public DefaultTableModel mostrar() {
        DBAccess aceso = new DBAccess();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnCount(4);
        String[] cabeceras = {"Titulo", "Duracion", "Edad Minima", "Genero"};
        modelo.setColumnIdentifiers(cabeceras);

        try {
            String consulta = "SELECT p.titulo,p.duracion,p.edadMinima,g.nombre FROM pelicula AS p INNER JOIN genero AS g ON p.idGenero = g.id ORDER BY p.id";
            Statement state = aceso.conexion.createStatement();
            ResultSet result = state.executeQuery(consulta);
            while (result.next()) {
                Object[] fila1 = {result.getString("p.titulo"), result.getInt("p.duracion"), result.getInt("p.edadMinima"), result.getString("g.nombre")};
                modelo.addRow(fila1);

            }
            return modelo;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return null;
        } finally {
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.toString());
            }
        }
    }

    public void anadir(String titulo, Object duracion, Object edadmin,Object genero) {
        DBAccess aceso = new DBAccess();
        Genero generoa = new Genero();
        try {
            int idgenero=generoa.sacarId(genero);
            Statement state = aceso.conexion.createStatement();
            String consulta = "INSERT INTO pelicula (titulo,duracion,edadMinima,idGenero) VALUES ('" + titulo + "','" + duracion + "','" + edadmin + "','"+ idgenero +"')";
            int result2 = state.executeUpdate(consulta);
            aceso.conexion.commit();
            System.out.println("Se han insertado " + result2 + " Lineas");
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.rollback();
                }
            } catch (Exception e1) {
                System.out.println(e1.toString());
            }
        }finally {
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.toString());
            }
        }
    }
    
    public void modificar(String titulo, Object duracion, Object edadmin,Object genero, String titulo2){
        DBAccess aceso = new DBAccess();
        Genero generoa = new Genero();
        try{
            int idgenero=generoa.sacarId(genero);
            Statement state = aceso.conexion.createStatement();
            String consulta = "Update pelicula SET titulo='" + titulo + "', duracion=" + duracion + ", edadMinima=" + edadmin + ", idGenero=" + idgenero + " Where titulo = '" + titulo2 + "'";
            int result2 = state.executeUpdate(consulta);
            aceso.conexion.commit();
            System.out.println("Se han actualizado " + result2 + " Lineas");
        }catch (Exception ex) {
            System.out.println("Error: " + ex);
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.rollback();
                }
            } catch (Exception e1) {
                System.out.println(e1.toString());
            }
        }finally {
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.toString());
            }
        }
    }
    public void eliminar(String titulo, Object duracion, Object edadmin, Object genero){
        DBAccess aceso = new DBAccess();
        Genero generoa = new Genero();
        try{
            int idgenero=generoa.sacarId(genero);
            Statement state = aceso.conexion.createStatement();
            String consulta ="DELETE FROM pelicula WHERE titulo ='" + titulo + "' AND duracion =" + duracion +  " AND edadMinima =" + edadmin +  " AND idGenero = " + idgenero;
            int result2 = state.executeUpdate(consulta);
            aceso.conexion.commit();
            System.out.println("Se ha eliminado " + result2 + " Lineas");
            
        }catch(Exception ex){
            System.out.println("Error: " + ex);
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.rollback();
                }
            } catch (Exception e1) {
                System.out.println(e1.toString());
            }
        }finally{
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.toString());
            }
        }
    }
    public DefaultTableModel recomendar(int duracion, int edadmin, String genero){
        DBAccess aceso = new DBAccess();
        Genero generoa = new Genero();
        int contador=0;
        try{
            String consulta="SELECT p.titulo,p.duracion,p.edadMinima,g.nombre FROM pelicula AS p INNER JOIN genero AS g ON p.idGenero = g.id WHERE ";
            if(duracion != 0){
                if(contador!=0){
                    consulta= consulta + " AND ";
                }
                consulta=consulta + " p.duracion = '" + duracion + "'";
                contador++;
            }
            if( edadmin != 0){
                if(contador!=0){
                    consulta= consulta + " AND ";
                }
                consulta=consulta + " p.edadMinima='" + edadmin+ "'";
                contador++;
            }
            if(!genero.equals("-")){
                if(contador!=0){
                    consulta= consulta + "AND ";
                }
                consulta=consulta + " g.nombre='" + genero + "'";
            }
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnCount(4);
            String[] cabeceras = {"Titulo", "Duracion", "Edad Minima", "Genero"};
            modelo.setColumnIdentifiers(cabeceras);
            Statement state = aceso.conexion.createStatement();
            ResultSet result = state.executeQuery(consulta);
            while (result.next()) {
                Object[] fila1 = {result.getString("p.titulo"), result.getInt("p.duracion"), result.getInt("p.edadMinima"), result.getString("g.nombre")};
                modelo.addRow(fila1);
            }
            return modelo;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return null;
        } finally {
            try {
                if (aceso.conexion != null) {
                    aceso.conexion.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.toString());
            }
        }
        
    }

}
