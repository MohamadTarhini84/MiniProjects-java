/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework_paint_gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class ToolBox extends JPanel{
    public enum Tools{
        CLICK_AND_DRAG, LINE,
        E_SQUARE, E_CIRCLE, E_TRIANGLE, E_RECTANGLE,
        F_SQUARE, F_CIRCLE, F_TRIANGLE, F_RECTANGLE
        }
    
    public class ToolButton extends JLabel{
        String path;
        Tools tool;
        
        public ToolButton(Tools newTool, String newPath){
            super();
            this.tool=newTool;
            try {
                Image img = ImageIO.read(new File("toolbox\\"+newPath));
                setIcon(new ImageIcon(img.getScaledInstance(50,50,Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                Logger.getLogger(ToolBox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public Tools getTool(){
            return this.tool;
        }
    }
    
    public ToolBox(){
        setLayout(new GridLayout(1,8));
        setPreferredSize(new Dimension(500,50));
        add(new ToolButton(Tools.E_CIRCLE,"ECircle.png"));
        add(new ToolButton(Tools.E_RECTANGLE,"ERectangle.png"));
        add(new ToolButton(Tools.E_TRIANGLE,"ETriangle.png"));
        add(new ToolButton(Tools.LINE,"Line.png"));
        add(new ToolButton(Tools.F_CIRCLE,"FCircle.png"));
        add(new ToolButton(Tools.F_RECTANGLE,"FRectangle.png"));
        add(new ToolButton(Tools.F_TRIANGLE,"FTriangle.png"));
        add(new ToolButton(Tools.CLICK_AND_DRAG,"Free.png"));
    }
}
