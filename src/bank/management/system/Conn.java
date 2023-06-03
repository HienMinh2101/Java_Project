package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;    
    Statement s;
    public Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Hien21012001");
            s = c.createStatement();
            
        
        } catch(Exception e){
            System.out.println(e);
        }
    }

    ResultSet executeQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
