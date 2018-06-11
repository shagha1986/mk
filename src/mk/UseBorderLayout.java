/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk;

/**
 *
 * @author Shagayegh
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Shagayegh
 */

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;



public class UseBorderLayout {
    
     public static boolean RIGHT_TO_LEFT = false;
     public static void addComponentsToPane(Container pane){
         if(!(pane.getLayout() instanceof BorderLayout)){
             pane.add(new JLabel("Container doesn't use BorderLayout!"));
             return;
         }
         
         if(RIGHT_TO_LEFT){
             pane.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
         }
         
       JButton  button = new JButton("btn 1 region PageStart");
        pane.add(button,BorderLayout.PAGE_START );
     
     }
     //create GUI to show this method should be invoked from the event dispatch thread.
     private static void createAndShowGUI() {
        JFrame frame = new JFrame("BorderLayout");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         addComponentsToPane(frame.getContentPane());
         frame.pack();

//pack makes use of the layout manager API and "asks"
//the frame's contentPane for it's preferredSize, this allows pack to "pack" the windows
//decorations around the content. You have to remember, a windows size includes the windows decorations, 
//so a window of 800x600 will have a viewable which is noticeably smaller
        frame.setVisible(true);
     }
 
     public static void main(String[] args) {
         try{
         UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
         }
         catch(UnsupportedLookAndFeelException e){e.printStackTrace();}
         catch(IllegalAccessException e){e.printStackTrace();}
         catch(InstantiationException e){e.printStackTrace();}
         catch(ClassNotFoundException e){e.printStackTrace();}
         /* Turn off metal's use bold fonts */
         UIManager.put("swing.boldMetal", Boolean.FALSE);
         javax.swing.SwingUtilities.invokeLater(new Runnable(){
             public void run() {
                createAndShowGUI();
            } 
         });
     }
}
