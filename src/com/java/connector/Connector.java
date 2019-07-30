package com.java.connector;

/**
* Java Development Kit 11.0.4 LTS, Standard Edition.
* Date: 29/07/2019, Time: 21:47:57.
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal for non-commercial purposes.
* Developer Contact: jtrejosb@live.com
* GitHub.com/jtrejosb
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.java.ddbb.DDBB;

public class Connector {
  private Connection CC;
  private PreparedStatement PS;
  private ResultSet RS;
  private String dbName;
  private String url;
  private String usr;
  private String pwd;

  public Connector(String url,String usr,String pwd) {
    this.url=url;
    this.usr=usr;
    this.pwd=pwd;
  }

  public void connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Conectando...");
      CC=DriverManager.getConnection(url,usr,pwd);
      System.out.println("Conectado a MySQL localhost server");
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Error Fatal!",JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }

  public void query(String Q) {
    try {
      PS=CC.prepareStatement(Q);
      RS=PS.executeQuery();
      while(RS.next()) {
        DDBB.TA.append(RS.getString(1)+" "+RS.getString(2)+" "+RS.getString(3)+"\n");
      }
      RS.close();
      PS.close();
    } catch(SQLException e) {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }
}
