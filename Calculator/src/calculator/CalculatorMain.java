/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author myPC
 */
public class CalculatorMain extends Frame implements WindowListener{
//Khai bao bien 

//Ham khoi tao
    public CalculatorMain(){
        
        //Thêm các thành phần cho máy tính
        Display display = new Display(this, 25, 50, 350, 100);
        CalcuBTN num0 = new CalcuBTN(this, "0", Color.GRAY, 100, 400, 1);
        CalcuBTN num1 = new CalcuBTN(this, "1", Color.GRAY, 25, 325, 1);
        CalcuBTN num2 = new CalcuBTN(this, "2", Color.GRAY, 100, 325, 1);
        CalcuBTN num3 = new CalcuBTN(this, "3", Color.GRAY, 175, 325, 1);
        CalcuBTN num4 = new CalcuBTN(this, "4", Color.GRAY, 25, 250, 1);
        CalcuBTN num5 = new CalcuBTN(this, "5", Color.GRAY, 100, 250, 1);
        CalcuBTN num6 = new CalcuBTN(this, "6", Color.GRAY, 175, 250, 1);
        CalcuBTN num7 = new CalcuBTN(this, "7", Color.GRAY, 25, 175, 1);
        CalcuBTN num8 = new CalcuBTN(this, "8", Color.GRAY, 100, 175, 1);
        CalcuBTN num9 = new CalcuBTN(this, "9", Color.GRAY, 175, 175, 1);
        
        CalcuBTN cham = new CalcuBTN(this, ".", Color.GRAY, 175, 400, 0);
        CalcuBTN xoa = new CalcuBTN(this, "DEL", Color.YELLOW, 25, 400, 5);
        
        CalcuBTN cong = new CalcuBTN(this, "+", Color.LIGHT_GRAY, 250, 175, 0);
        CalcuBTN tru = new CalcuBTN(this, "-", Color.LIGHT_GRAY, 250, 250, 0);
        CalcuBTN nhan = new CalcuBTN(this, "x", Color.LIGHT_GRAY, 250, 325, 0);
        CalcuBTN chia = new CalcuBTN(this, ":", Color.LIGHT_GRAY, 250, 400, 0);
        
        CalcuBTN bang = new CalcuBTN(this, "=", Color.LIGHT_GRAY, 325, 325, 3);
        CalcuBTN ac = new CalcuBTN(this, "AC", Color.RED, 325, 175, 4);

        // Tạo khung frame
        addWindowListener(this);
        String path = new File("src/img/calculator_icon.png").getAbsolutePath();
        setIconImage(new ImageIcon(path).getImage());
        setBackground(Color.WHITE);
        setCursor(Cursor.HAND_CURSOR);
        setMaximizedBounds(new Rectangle(500,100 , 400, 480)); 
        setMinimumSize(new Dimension(400, 480));
        setBounds(500, 100, 400, 480);
        setTitle("My Calculator");
        setLayout(null);
        setVisible(true);
    }
//Ham main

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new CalculatorMain();
    }
    
        @Override
    public void windowActivated(WindowEvent e) {
//        System.out.println("Activated - da kich hoat");
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
//        System.out.println("Closed - dong");
    }
 
    @Override
    public void windowClosing(WindowEvent e) {
//        System.out.println("Closing - dang dong");
        dispose();
    }
 
    @Override
    public void windowDeactivated(WindowEvent e) {
//        System.out.println("Deactivated - dung kich hoat");
    }
 
    @Override
    public void windowDeiconified(WindowEvent e) {
//        System.out.println("Deiconified - bo an");
    }
 
    @Override
    public void windowIconified(WindowEvent e) {
//        System.out.println("Iconified - an");
    }
 
    @Override
    public void windowOpened(WindowEvent arg0) {
//        System.out.println("Opened - da mo");
    }
}
