/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import static calculator.Display.dis;
import static calculator.XuLyChuoi.XuLyChuoi;

// Xây dựng lớp Button phân thành các loại - type cụ thể
/**
 *
 * @author myPC
 */

public class CalcuBTN {
    
    static String output ="";
    
    Font font = new Font(Font.SANS_SERIF,Font.CENTER_BASELINE,20);
    // Hàm khởi tạo
    public CalcuBTN(Frame f,String label,Color ColorString, int x, int y,int type)
    {
        output = dis.getText(); // biến output gắn bằng giá trị Text của biến dis - khai báo ở Display.java
        
        Button btn = new Button();
        btn.setLabel(label);
        btn.setFont(font);
        btn.setBounds(x, y, 50, 50);
        if (type == 4 || type == 3){
            btn.setBounds(x, y, 50, 125);
        }
        btn.setBackground(ColorString);
        
        btn.addActionListener((e) -> {
            switch (type) {
                // type  = 1 button nhập số
                case 1 -> output = output.concat(label);
                // type = 0 button nhập phép tính
                case 0 -> {
                    if(output != null){
                        if(output.length()>0){
                            char kyTu = output.charAt(output.length()-1);
                            if(kyTu == '+' || kyTu == '-' || kyTu == 'x' || kyTu == ':'){
                                output = output.substring(0,output.length()-1);
                                output = output.concat(label);
                            }
                            else{
                                output = output.concat(label);
                            }
                        }
                    }   if(output.length() == 0 && label.equals("-"))
                        output = output.concat(label);
                }
                //type = 3 Xử lý dấu bằng trả về kết quả
                case 3 -> {
                    if(output.length()>0){
                        char kyTu = output.charAt(output.length()-1);
                        if(kyTu != '+' && kyTu != '-' && kyTu != 'x' && kyTu != ':'){
                            output = XuLyChuoi(output);
                        }
                    }
                }
                //type = 4 nút AC
                case 4 -> output = "";
                // type = 5 nút Xóa
                case 5 -> {
                    if(output.length()>0){
                        output = output.substring(0,output.length()-1);
                    }
                }
                case 6 -> {
                    //Xu ly dau cham
                }
                default -> {
                }
            }
            
            dis.setText(output);
        });
        f.add(btn);
    }
}
