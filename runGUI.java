/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.dentistappointment;

import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class runGUI {

	   
    public static void main(String[] args) {
       GUI myFrame = new GUI();
        myFrame.setGUI();
        myFrame.setSize(300, 400);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
     
        
    }
    }
    