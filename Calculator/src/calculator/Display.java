/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;

/**
 *
 * @author myPC
 */
public class Display {
    static TextField dis = new TextField();
    Font font = new Font(Font.SANS_SERIF,Font.LAYOUT_RIGHT_TO_LEFT,30);

    // Hàm khởi tạo màn hình hiển thị
    public Display(Frame f, int x, int y, int width, int height) {
        dis.setBounds(x, y, width, height);
        dis.setEditable(false); //Nếu muốn nhập từ bàn phím đặt lại là true
        dis.setFont(font);
        f.add(dis);
    }
    
}
