/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;
//Xử lý dãy phép tính được lấy từ màn hình và trả về kết quả
/**
 *
 * @author myPC
 */
public class XuLyChuoi {
    
    // Tìm kiếm các phép toán trong chuỗi nhập vào của người dùng
    public static boolean isMath(char pst){
        return pst == '+' || pst == '-' || pst == 'x' || pst == ':';
    }
    //Hàm tính toán
    public static float excute(float num1, float num2, String math){
        float result = 0;
        switch (math) {
            case "x" -> result = num1 * num2;
            case ":" -> result = num1 / num2;
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
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
        
        chuoi = "0".concat(chuoi);
        
        //Thêm các phần tử vào Math và Num
        try {
            for (int i = 0; i < chuoi.length(); i++){
            char pst = chuoi.charAt(i);
            if (isMath(pst)){
                Sl++;
                Math[Sl-1] = String.valueOf(chuoi.charAt(i));
                Num[Sl-1] = Float.parseFloat(chuoi.substring(beginIndex, i));
                beginIndex = i + 1;
            }
            if(i == chuoi.length()-1)
                Num[Sl] = Float.parseFloat(chuoi.substring(beginIndex, chuoi.length()));
            }
        } catch (NumberFormatException e) {
            chuoi = "0";
        }
        
        
        // thuc hien tinh toan nhân và chia trước, thay thế các kq vào mảng Math và Num
        for(int i = 0; i < Math.length; i++){
            if(Math[i] != null){
                if(Math[i].equals(":") || Math[i].equals("x")){
                    Num[i] = excute(Num[i], Num[i+1], Math[i]);
                    
                    //Xóa ptu i cua Math và ptu i+1 của Num
                    delete(Math, i);
                    deleteF(Num, (i+1));
                    i--;
                }
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
