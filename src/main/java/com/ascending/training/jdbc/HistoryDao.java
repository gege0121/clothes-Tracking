package com.ascending.training.jdbc;

import com.ascending.training.model.History;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {

        //STEP 1: Database information
        private static final String DB_URL = System.getProperty("database.url");
        private static final String USER = System.getProperty("database.user");
        private static final String PASS = System.getProperty("database.password");

        public List<History> gethistorys(){
            List<History> historys = new ArrayList();
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
                sql = "SELECT * FROM historys";
                rs = stmt.executeQuery(sql);

                //STEP 4: Extract data from result set
                while(rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    LocalDate date = rs.getDate("date").toLocalDate();
                    Integer temperature= rs.getInt("temperature");

                    //Fill the object
                    History history = new History();
                    history.setId(id);
                    history.setDate(date);
                    history.setTemperature(temperature);
                    historys.add(history);
                }
            } catch(SQLException e){
                e.printStackTrace();
                //resolve exception
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

            return historys;
        }

    }


