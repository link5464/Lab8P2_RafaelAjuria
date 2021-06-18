/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8p2_rafaelajuria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author rajur
 */
public class DatabaseCon {
    private String Database;
    private Connection DatabaseConnection;
    public Statement Query;

    public DatabaseCon(String Database) {
        this.Database = Database;
    }

    public void setDatabase(String Database) {
        this.Database = Database;
    }
    
    public void Connect()
    {
        try 
        {
            String Driver = "jdbc:ucanaccess://";
            DatabaseConnection = DriverManager.getConnection(Driver+Database,"","");
            Query = DatabaseConnection.createStatement();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void Disconnect() 
    {
        try 
        {
            Query.close();
            DatabaseConnection.close();
        } 
        catch (Exception e) 
        {
        }
    }
    public void Commit()
    {
       try{
           DatabaseConnection.commit();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
    
}
