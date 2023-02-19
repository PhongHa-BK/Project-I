/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author May-Pc
 */
public class IEEE {
    public static String GetBinary32( float value )  
    {  
    	    int intBits = Float.floatToIntBits(Math.abs(value));
    	    String ans = Integer.toBinaryString(intBits);
    	    if(value < 0 ) return "1"+ans;
    	    return "0" + ans;
    }
    
    public static void main(){
        GetBinary32(3);
    }
}
