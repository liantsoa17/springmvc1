package com.example.demo.connectBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectBase {
    Connection connectPostgres ;
    public Connection Connect(){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con  = DriverManager.getConnection("jdbc:postgresql://containers-us-west-126.railway.app:5844/railway" , "postgres" , "ToHCo0uzdQXyX5cjJgrI") ;
            System.out.println("connecter");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
