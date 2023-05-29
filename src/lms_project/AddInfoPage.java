/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms_project;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class AddInfoPage extends JFrame{
    static JLabel result=new JLabel();
    static JLabel error=new JLabel();
    JFrame parent;
    
    public AddInfoPage(JFrame frame, String infoType){
        parent=frame;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 420);
        setTitle("Add Something");
        
        if("book".equals(infoType)){
            add(new AddBook(this), BorderLayout.CENTER);
        } else if("author".equals(infoType)){
            add(new AddAuthor(this), BorderLayout.CENTER);
        }
        
        result.setOpaque(true);
        result.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        result.setText("");
        result.setBackground(Color.blue);
        add(result, BorderLayout.SOUTH);
        error.setOpaque(true);
        error.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        error.setText("");
        error.setBackground(Color.red);
        add(error, BorderLayout.NORTH);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parent.setEnabled(true);
            }
        });
        pack();
        setVisible(true);
    }
    
    public static void insertInfo(String query){
        try {
            Connection conn=DBManager.getConnection();

            Statement st=conn.createStatement();
            st.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet res=st.getGeneratedKeys();
            
            System.out.println(res);

            error.setText("");
            result.setText("Successfully Added");
        } catch (SQLException ex) {
            Logger.getLogger(AddInfoPage.class.getName()).log(Level.SEVERE, null, ex);
            error.setText("An error occured");
        }
    }
    
    public static void setError(String err){
            error.setText(err );
    }
}
