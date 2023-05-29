/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoetest;

/**
 *
 * @author HP
 */
public class TicTacToeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BoardGUI board=new BoardGUI();
        board.setVisible(true);
        Board gameBoard= new Board(board);
        board.setMainBoard(gameBoard);
    }
    
}
