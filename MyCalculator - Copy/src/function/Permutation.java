/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;
import java.math.*;
/**
 *
 * @author May-Pc
 */
public class Permutation {
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    public static BigInteger permutation(int k, int n) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(n - k);
        return numerator.divide(denominator);
    }
    
    public static void main(){
    }
}
