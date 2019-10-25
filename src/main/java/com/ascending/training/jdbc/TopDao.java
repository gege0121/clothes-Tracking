package com.ascending.training.jdbc;

import com.ascending.training.model.Clothes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5433/Clothes";
    static final String USER = "gege";
    static final String PASS = "0121";

    public List<Clothes> getTops() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Clothes> tops = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating Statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Top";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                long ID = rs.getLong("ID");
                String clothesType = rs.getString("clothesType");
                String color = rs.getString("color");
                String size = rs.getString("size");
                int warmLevel = rs.getInt("warmLevel");

                Clothes top = new Clothes();
                top.setID(ID);
                top.setClothesType(clothesType);
                top.setColor(color);
                top.setSize(size);
                top.setWarmlevel(warmLevel);
                tops.add(top);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return tops;
    }

}
