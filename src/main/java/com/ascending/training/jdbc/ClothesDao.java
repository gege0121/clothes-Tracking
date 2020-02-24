package com.ascending.training.jdbc;

import com.ascending.training.model.Clothes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothesDao {
    //STEP 1: Database information
    private static final String DB_URL = System.getProperty("database.url");
    private static final String USER = System.getProperty("database.user");
    private static final String PASS = System.getProperty("database.password");

    public List<Clothes> getclothess(){
        List<Clothes> clothess = new ArrayList();
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;


    try {
        //STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        //STEP 3: Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM clothess";
        rs = stmt.executeQuery(sql);

        //STEP 4: Extract data from result set
        while(rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            String type = rs.getString("type");
            String size = rs.getString("size");
            String color = rs.getString("color");
            String tag = rs.getString("tag");

            //Fill the object
            Clothes clothes = new Clothes();
            clothes.setId(id);
            clothes.setType(type);
            clothes.setColor(color);
            clothes.setSize(size);
            clothes.setTag(tag);
            clothess.add(clothes);
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    finally {
        //STEP 6: finally block used to close resources
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }

        return clothess;
    }

}

