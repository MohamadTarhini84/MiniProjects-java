/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoetest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class BoardGUI extends JFrame implements ActionListener{
    byte[] position;
    JPanel center=new JPanel(),
           board=new JPanel();
    JLabel move=new JLabel("Welcome! Make a move",JLabel.CENTER);
    JLabel[] positions=new JLabel[9];
    JTextField input=new JTextField();
    JButton makeMove=new JButton("Move");
    JButton restart=new JButton("Restart");
    Board mainBoard;
    
    public BoardGUI(){
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
//        setResizable(false);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc=new GridBagConstraints();
        
        for(int i=0;i<positions.length;i++){
            positions[i]=new JLabel(" ",JLabel.CENTER);
            positions[i].setBorder(BorderFactory.createLineBorder(Color.black,1));
        }
        
        center.setPreferredSize(new Dimension(500,500));
        center.setLayout(new BorderLayout());
        center.setBorder(BorderFactory.createLineBorder(Color.black,2,true));
        center.setOpaque(true);
        center.setBackground(Color.lightGray);
        
        JPanel inputsPanel=new JPanel();
        inputsPanel.setPreferredSize(new Dimension(100, 40));
        inputsPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.black));
        
        JPanel boardPanel=new JPanel();
        boardPanel.setLayout(new GridBagLayout());
        board.setPreferredSize(new Dimension(300,300));
        board.setLayout(new GridLayout(3,3));
        board.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        for(JLabel item:positions){
            board.add(item);
        }
        boardPanel.add(board,gbc);
        gbc.gridy=1;
        boardPanel.add(move,gbc);
        gbc.gridy=0;
        
        input.setPreferredSize(new Dimension(150,30));
        makeMove.addActionListener(this);
        restart.addActionListener((ActionEvent e) -> {
            for(int i=0;i<positions.length;i++){
                positions[i].setText(" ");
                mainBoard.restartGame();
                makeMove.setEnabled(true);
                move.setText("Go again!");
            }
        });
        inputsPanel.add(input);
        inputsPanel.add(makeMove);
        inputsPanel.add(restart);
        center.add(boardPanel);
        center.add(inputsPanel, BorderLayout.SOUTH);
        
        add(center,gbc);
    }
    
    public void setBoard(char[] positionsInput){
        int j=0;
        for(int i=0;i<positions.length;i++){
            positions[i].setText(""+positionsInput[j]);
            j++;
        }
    }
    public void setMove(String moveInput){this.move.setText(moveInput);}
    public void setMainBoard(Board main){this.mainBoard=main;}
    public void turnOff(){this.makeMove.setEnabled(false);}

    @Override
    public void actionPerformed(ActionEvent e) {
        mainBoard.playerMove(input.getText());
        input.setText("");
    }
}
