/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms_project;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author HP
 */
public class AddAuthor extends JPanel implements ActionListener{
        JTextField firstNameText=new JTextField();
        JTextField lastNameText=new JTextField();
        JTextField emailText=new JTextField();
        JButton addButton=new JButton("Add");
        JButton cancelButton=new JButton("Cancel");
        JFrame parent;
        
        public AddAuthor(JFrame frame){
            parent=frame;
            
            setBorder(new EmptyBorder(0, 10, 0, 10));
            setLayout(new GridBagLayout());
            setPreferredSize(new Dimension(400,200));
            GridBagConstraints gbc=new GridBagConstraints();
            gbc.fill=GridBagConstraints.HORIZONTAL;
            gbc.anchor=GridBagConstraints.FIRST_LINE_START;
            gbc.weightx=1;
            gbc.weighty=0.1;
            gbc.gridheight=1;
            gbc.gridwidth=2;
            
            JPanel buttons=new JPanel();
            addButton.addActionListener(this);
            cancelButton.addActionListener(this);
            buttons.add(addButton);
            buttons.add(cancelButton);
            
            add(new JLabel("Please enter the author's first name: "),gbc);
            gbc.gridy=2;
            add(new JLabel("Please enter the author's last name: "),gbc);
            gbc.gridy=4;
            add(new JLabel("Please enter the author's email: "),gbc);
            gbc.gridy=1;
            add(firstNameText,gbc);
            gbc.gridy=3;
            add(lastNameText,gbc);
            gbc.gridy=5;
            add(emailText,gbc);
            gbc.gridy=6;
            gbc.anchor=GridBagConstraints.CENTER;
            gbc.fill=GridBagConstraints.VERTICAL;
            add(buttons,gbc);
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            Object source=e.getSource();
            if(source==cancelButton){
                parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
            } 
            if(source==addButton){
                if( firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() || emailText.getText().isEmpty()){
                    AddInfoPage.setError("Make sure you've entered all fields");
                } else{
                    AddInfoPage.insertInfo("INSERT INTO authors(firstName,lastName,email) "
                            + "VALUES('"+firstNameText.getText()+"','"+
                                lastNameText.getText()+"','"+emailText.getText()+"')");
                }
            }
        }
}
