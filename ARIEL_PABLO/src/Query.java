
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahou
 */
public class Query {
    String url ="";
    String user="root";
    String pass="";
    String name="bd_tours";
    Connection conex;
    Statement sentencia;
    public Query(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://localhost:3306/"+name;
            conex=DriverManager.getConnection(url,user,pass);
            sentencia=conex.createStatement();
            
        }catch(Exception e){
            System.out.println("Error en la conexion"+e);
        }
    }
    public void delete(String tabla,String condicion){
        try{
            sentencia.executeUpdate("DELETE FROM "+tabla+" WHERE "+condicion);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e,"",2);
        }
    }
    
    public ResultSet select(String campos,String tabla,String condicion){
        ResultSet lista = null;
        try{
            lista=sentencia.executeQuery("SELECT "+campos+" FROM "+tabla+condicion);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e,"",2);
        }
        return lista;
    }
    
    public void update(String tabla,String data,String condicion){
        try{
            sentencia.executeUpdate("UPDATE  "+tabla+" SET "+data+condicion);
              JOptionPane.showMessageDialog(null,"UPDATE  "+tabla+" SET "+data+condicion,"",2);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e,"",2);
        }
    }
    
    public void insert(String tabla,String valores){
        try{
            sentencia.executeUpdate("INSERT INTO "+tabla+" VALUES ("+valores+")");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e,"",2);
        }
    }
    public void cerrar(){
        try{
           conex.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"",2);
        }
        sentencia=null;
    }
    
}
