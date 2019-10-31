/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penerimaan.desa;

import java.sql.*;

/**
 *
 * @author Imul
 */
public class DbConnection {
    String url,usr,pass,dbn;
    Connection con = null;
    public DbConnection(String dbn){
        this.url = "jdbc:mysql://localhost/" + dbn +"?serverTimezone=UTC";
        this.usr = "root";
        this.pass = "";
        this.con = getConnection();
    }
    public DbConnection(String host,String user, String pass, String dbn){
        this.url = "jdbc:mysql://" + host + "/" + dbn +"?serverTimezone=UTC";
        this.usr=user;
        this.pass=pass;
        this.con = getConnection();
    }

    DbConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.usr,
            this.pass);
        } catch (ClassNotFoundException e) {
            System.out.println ("Error #1 : " + e.getMessage());
            System.exit(0);
        } catch (SQLException e) {
            System.out.println ("Error #2 : " + e.getMessage());
            System.exit(0);
        }
        return con;
    }
    
}
