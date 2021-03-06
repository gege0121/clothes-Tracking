package com.ascending.training.jdbc;

import com.ascending.training.model.Clothes;
import com.ascending.training.model.Customer;
import com.ascending.training.model.History;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
        //STEP 1: Database information
        private static final String DB_URL = System.getProperty("database.url");
        private static final String USER = System.getProperty("database.user");
        private static final String PASS = System.getProperty("database.password");


        public List<Customer> getcustomers(){
            List<Customer> customers = new ArrayList();
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
                sql = "SELECT * FROM customers";
                rs = stmt.executeQuery(sql);

                //STEP 4: Extract data from result set
                while(rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    Integer age = rs.getInt("age");
                    Integer gender = rs.getInt("gender");
                    Integer height = rs.getInt("height");
                    Integer weight = rs.getInt("weight");
                    Integer primer= rs.getInt("primer");

                    //Fill the object
                   Customer  customer = new Customer();
                    customer.setId(id);
                    customer.setAge(age);
                    customer.setGender(gender);
                    customer.setHeight(height);
                    customer.setWeight(weight);
                    customer.setName(name);
                    customer.setPrimer(primer);
                    customers.add(customer);
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

            return customers;
        }




    }


