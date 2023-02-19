/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import static function.Permutation.*;
import static function.Combination.*;
import static function.exponent.*;
/**
 *
 * @author May-Pc
 */
public class stringProcessing {
    // Tìm kiếm các phép toán trong chuỗi nhập vào của người dùng
    public static boolean isMath(char pst){
        return pst == '+' || pst == '-' || pst == '*' || pst == '/' || pst == '%' || pst == '^' || pst == 'P' || pst == 'C' || pst == '(' 
                || pst == 'e' || pst == 's' || pst == 'c' || pst == 't' || pst == 'S' || pst == 'H' || pst == 'T' || pst == 'g' || pst == 'r' || pst == '!';
    }
    public static boolean isChar(char pst){
        return pst >= 'a' && pst <='z';
    }
    //Hàm tính toán
    public static float excute(float num1, float num2, String math){
        float result = 0;
        switch (math) {
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "%" -> result = num1 % num2;
            case "^" -> result = exponent((int)num1, (int)num2);
            case "P" -> result = permutation((int)num2, (int)num1).floatValue();
            case "C" -> result = combination((int)num2,(int) num1).floatValue();
            default -> {
            }
        }
        return result;
    }
    
    public static float excute2(float num1, String math){
        float result = 0;
        switch (math) {
            case "e" -> result = (float) Math.exp(num1);
            case "r" -> result = (float) Math.sqrt(num1);
            case "s" -> result = (float) Math.sin(num1);
            case "c" -> result = (float) Math.cos(num1);
            case "t" -> result = (float) Math.tan(num1);
            case "S" -> result = (float) Math.sinh(num1);
            case "H" -> result = (float) Math.cosh(num1);
            case "T" -> result = (float) Math.tanh(num1);
            case "g" -> result = (float) Math.log(num1);
            case "!" -> result = function.Combination.factorial((int)num1).floatValue();
            case "^2" -> result = square((int)num1);
            case "^3" -> result = cube((int)num1);
            default -> {
            }
        }
        return result;
    }
    //Hàm xóa 1 phép toán
    public static void delete(String[] Math, int index){
        for(int i = index; i< Math.length-1; i++){
            Math[i] = Math[i+1];
        }
    }
    //Hàm xóa 1 số
    public static void deleteF(float[] Num, int index){
        for(int i = index; i< Num.length-1; i++){
            Num[i] = Num[i+1];
        }
    }
    
    //
    public static String XuLyChuoi(String chuoi) {
        // TODO code application logic here
        
        System.out.print(chuoi + " ");
        
        int Sl = 0;
        int beginIndex = 0;
        //Tạo 2 mảng Math chứa các phép toán và mảng Num chứa các số
        String[] Math = new String[100];
        float[] Num = new float[100];
        int n = Math.length;
        
        chuoi = "0".concat(chuoi);
        
        //Thêm các phần tử vào Math và Num
        try {
            for (int i = 0; i < chuoi.length(); i++){
            char pst = chuoi.charAt(i);
            if (isMath(pst)){
                Sl++;
                Math[Sl-1] = String.valueOf(chuoi.charAt(i));
                
//                Num[Sl-1] = Float.parseFloat(chuoi.substring(beginIndex, i));
                if(Character.isDigit(chuoi.charAt(i-1))){
                    Num[Sl-1] = Float.parseFloat(chuoi.substring(beginIndex, i));
                }
                beginIndex = i + 1;
            }
            if(i == chuoi.length()-1)
                if(Character.isDigit(chuoi.charAt(i)) && isMath(chuoi.charAt(i-1)) && isMath(chuoi.charAt(i-2))){
                    
                        
                        Num[Sl-1] = Float.parseFloat(chuoi.substring(beginIndex, chuoi.length()));
                        
                         
                    
                }
               else if (Character.isDigit(chuoi.charAt(i)) && isMath(chuoi.charAt(i-1)) &&Character.isDigit(chuoi.charAt(i-2))){
                        Num[Sl] = Float.parseFloat(chuoi.substring(beginIndex, chuoi.length()));
                        }
                else if(Character.isDigit(chuoi.charAt(i))&& !isMath(chuoi.charAt(i-1))){
                    Num[Sl] = Float.parseFloat(chuoi.substring(beginIndex, chuoi.length()));
                }
                else break;
//            }
            }
        } catch (NumberFormatException e) {
            chuoi = "0";
        }
        
        
        // thuc hien tinh toan nhân chia và các phép toán khác trước, thay thế các kq vào mảng Math và Num
        for(int i = 0; i < n; i++){
            if(Math[i] != null){
                if(Math[i].equals("/") || Math[i].equals("*") || Math[i].equals("C") || Math[i].equals("P") 
                        || Math[i].equals("%") || Math[i].equals("^") )
                {
                    Num[i] = excute(Num[i], Num[i+1], Math[i]);
                    
                    //Xóa ptu i cua Math và ptu i+1 của Num
                    delete(Math, i);
                    deleteF(Num, (i+1));
                    i--;
                }
                else if(Math[i].equals("e" ) || Math[i].equals("s") || Math[i].equals("c") || Math[i].equals("t") || Math[i].equals("S")
                        || Math[i].equals("H") || Math[i].equals("T")|| Math[i].equals("r") || Math[i].equals("g") || Math[i].equals("!")){

                    Num[i] = excute2(Num[i], Math[i]);
                    delete(Math, i);
//                    deleteF(Num, (i+1));
//                    i--;
                }
                else continue;
            }
        }
    
        
        //Thực hiện phép tính từ trái sang phải
        float kq = Num[0];
        for(int i = 0; i < Math.length; i++){
            if(Math[i] != null){
                kq = excute(Num[i], Num[i+1], Math[i]);
                Num[i+1] = kq;
            }
        }
        System.out.println(" = " + kq);
        String kqStr = String.valueOf(kq);
        
        return kqStr;
    }
}
