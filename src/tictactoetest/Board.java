/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoetest;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Board {
    char[] positions;
    BoardGUI board;
    public static boolean isDraw=false;
    
    public Board(BoardGUI boardInput){
        board=boardInput;
        positions= new char[9];
        for(int i=0;i<9;i++){
            positions[i]=' ';
        }
    }
    
    public void printBoard(){
          board.setBoard(positions);
    }
    
    public void playerMove(String playerMove){
        try{
            int move=Integer.parseInt(playerMove);
            if(move<10 && move>0 && positions[move-1]==' '){
                positions[move-1]='X';
                board.setMove("Your move: "+move);
                printBoard();
                if(gameOver()){
                    if(!isDraw){
                        endMessage(move-1);
                    }
                    board.turnOff();
                } else{
                    cpuMove();
                    printBoard();
                }
            } else board.setMove("Move unavailabe, try again");
        } catch(NumberFormatException e){
            board.setMove("Make sure to enter a valid move");
        }
    }
    
    public void cpuMove(){
        Random cpuMove=new Random();
        while(true){
            int move=cpuMove.nextInt(9)+1;
            if(positions[move-1]==' '){
                positions[move-1]='O';
                board.setMove("CPU move: "+move);
                if(gameOver()){
                    endMessage(move-1);
                    board.turnOff();
                }
                break;
            }   
        }
    }
    
    public void endMessage(int i){
            if(positions[i]=='X'){
                board.setMove("You win! ");
            }else if(positions[i]=='O'){
                board.setMove("CPU won :( ");
            } else{
                board.setMove("test");
            }
    }
    
    public boolean winConditions(){
        return (positions[0]==positions[1] && positions[1]==positions[2] && positions[0]!=' ')
            ||(positions[3]==positions[4] && positions[4]==positions[5] && positions[5]!=' ')
            ||(positions[6]==positions[7] && positions[7]==positions[8] && positions[6]!=' ')
            ||(positions[0]==positions[4] && positions[4]==positions[8] && positions[0]!=' ')
            ||(positions[2]==positions[4] && positions[4]==positions[6] && positions[4]!=' ')
            ||(positions[0]==positions[3] && positions[3]==positions[6] && positions[3]!=' ')
            ||(positions[1]==positions[4] && positions[4]==positions[7] && positions[7]!=' ')
            ||(positions[2]==positions[5] && positions[5]==positions[8] && positions[8]!=' ');
    }
    
    public boolean gameOver(){
        if(winConditions()){return true;}
        for(int i=0;i<9;i++){
            if(positions[i]==' '){
                return false;
            }
        }
        board.setMove("It's a draw!");
        isDraw=true;
        return true;
    }
    
    public void restartGame(){
        for(int i=0;i<positions.length;i++){
            positions[i]=' ';
        }
        isDraw=false;
    }
}
