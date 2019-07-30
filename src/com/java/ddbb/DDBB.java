package com.java.ddbb;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.java.connector.Connector;

@SuppressWarnings("serial")
public class DDBB extends javax.swing.JDialog {
  private JPanel contentPane;
  private JScrollPane SP;
  public static JTextArea TA;
  private Connector CC;
  public static void main(String[] args) {
    DDBB DB=new DDBB();
  }

  public DDBB() {
    setTheme();
    setTitle("MySQL JDBC");
    setSize(500,200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    contentPane=new JPanel();
    contentPane.setLayout(new BorderLayout());
    setContentPane(contentPane);

    TA=new JTextArea();
    TA.setEditable(false);
    SP=new JScrollPane(TA);
    getContentPane().add(SP,BorderLayout.CENTER);

    String name=JOptionPane.showInputDialog("Database Name:");
    CC=new Connector("jdbc:mysql://localhost:3306/"+name,"root","rootpass");
    CC.connect();
    String tName=JOptionPane.showInputDialog("Table Name:");
    CC.query("SELECT * FROM "+tName);

    setVisible(true);
  }

  private void setTheme() {
    try {
      javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
