package com.java.ddbb;

/**
* Java Development Kit 11.0.4 LTS, Standard Edition.
* Date: 29/07/2019, Time: 21:52:10.
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal for non-commercial purposes.
* Developer Contact: jtrejosb@live.com
* GitHub.com/jtrejosb
*/

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

    String name=JOptionPane.showInputDialog("Nombre de la BBDD:");
    CC=new Connector("jdbc:mysql://localhost:3306/"+name,"root","rootpass");
    CC.connect();
    String tName=JOptionPane.showInputDialog("Nombre de la tabla:");
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
