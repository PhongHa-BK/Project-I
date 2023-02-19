/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author May-Pc
 */
public class radix {
    public static String convertDecimalToBinary(int num){
        String bin = Integer.toBinaryString(num);
        return bin;
    }
    
    public static String convertDecimalToHexa(int d){
        String digits = "0123456789ABCDEF";
        if (d <= 0) return "0";
        
        int base = 16;
        String hex = "";
        while(d>0){
            int digit = d % base;
            hex = digits.charAt(digit) + hex;
            d = d / base;
        }
        return hex;
    }
    
     public static String convertDecimalToOctal(int decimal)
    {
        int octalNumber = 0, i = 1;
        while (decimal != 0)
        {
            octalNumber += (decimal % 8) * i;
            decimal /= 8;
            i *= 10;
        }
        String octal = Integer.toString(octalNumber);
        return octal;
    }
     
    public static void main(String[] args) {
        
    }
}
