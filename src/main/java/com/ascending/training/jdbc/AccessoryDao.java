package co.ascending.training.jdbc;

import co.ascending.training.model.Accessory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccessoryDao {
//    static final String DB_URL="jdbc:postgresql://localhost:5433/Clothes";
//    static final String USER="gege";
//    static final String PASS="0121";
//    public List<Accessory> getAccessories(){
        Connection conn;
        Statement stmt=null;
        ResultSet rs=null;
        List<Accessory> Accessories=new ArrayList<>();
        try{
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating Statement...");
            stmt= conn.createStatement();
            String sql;
            sql="SELECT * FROM Accessory";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                long id=rs.getLong("Id")
                String Atype=rs.
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
