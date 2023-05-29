/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms_project;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author HP
 */
public class SearchForm extends JPanel implements ActionListener,CaretListener{
    JTextField search=new JTextField();
    JRadioButton books=new JRadioButton("Search for books");
    JRadioButton authors=new JRadioButton("Search for authors");
    JRadioButton publishers=new JRadioButton("Search for publishers");
    JPanel searchOptions=new JPanel();
    JButton searchButton=new JButton("Search");
    JFrame parent;
    
    public SearchForm(JFrame test){
        parent=test;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=3;
        gbc.weightx=1;
        gbc.weighty=1;
        search.addCaretListener(this);
        add(search,gbc);
        gbc.gridwidth=1;
        gbc.fill=GridBagConstraints.NONE;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.gridx=0;
        gbc.gridy=1;
        add(books,gbc);
        gbc.gridx=1;
        add(authors,gbc);
        gbc.gridx=2;
        add(publishers,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=3;
        searchOptions.add(new bookOptions());
        add(searchOptions,gbc);
        gbc.gridy=3;
        add(searchButton,gbc);
        searchButton.addActionListener(this);
        ButtonGroup group=new ButtonGroup();
        group.add(books);
        books.setSelected(true);
        group.add(authors);
        group.add(publishers);
        books.addActionListener(this);
        authors.addActionListener(this);
        publishers.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==searchButton){
            try {
                Statement st= DBManager.getConnection().createStatement();
                
                ResultSet res=st.executeQuery("Select * from books where title like '%"+search.getText()+"%'");
                SearchPage.updateResults(res);
            } catch (SQLException ex) {
                Logger.getLogger(SearchForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            searchOptions.removeAll();
            if (books.isSelected()) {
                searchOptions.add(new bookOptions());
            }
            if (authors.isSelected()) {
                searchOptions.add(new authorOptions());
            }
            if (publishers.isSelected()) {
                searchOptions.add(new publisherOptions());
            }
            parent.pack();
            searchOptions.repaint();
        }
    }
    
    @Override
    public void caretUpdate(CaretEvent e){
        System.out.println(search.getText());
    }
    
    public class bookOptions extends JPanel{
        JCheckBox title=new JCheckBox("Title");
        JCheckBox ISBN=new JCheckBox("ISBN");
        JCheckBox author=new JCheckBox("Author");
        JCheckBox publisher=new JCheckBox("Publisher");
        JCheckBox desc=new JCheckBox("abstract");
        
        public bookOptions(){
            setLayout(new FlowLayout());
            add(title);
            title.setSelected(true);
            add(ISBN);
            add(author);
            add(publisher);
            add(desc);
        }
    }
    
    public class authorOptions extends JPanel{
        public JCheckBox firstName = new JCheckBox("First Name");
        public JCheckBox lastName = new JCheckBox("Last Name");
        public JCheckBox phone = new JCheckBox("Phone");
        public JCheckBox email = new JCheckBox("Email");
        
        public authorOptions(){
            add(this.firstName);
            firstName.setSelected(true);
            add(this.lastName);
            lastName.setSelected(true);
            add(this.phone);
            add(this.email);
        }
    }
    
    public class publisherOptions extends JPanel{
        JCheckBox name = new JCheckBox("Name");
        JCheckBox address = new JCheckBox("Address");
        
        public publisherOptions(){
            add(name);
            name.setSelected(true);
            add(address);
        }
    }
}
