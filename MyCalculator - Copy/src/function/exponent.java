/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author May-Pc
 */
public class exponent {
    public static long exponent(int num1, int num2){
        long result = num1;
        for(int i = 1; i < num2; i++){
                result = result * num1;
            }
        return result;        
    }
    
    public static long cube(int num1){
        return num1*num1*num1;
    }
    
    public static long square(int num1){
        return num1*num1;
    }
}
