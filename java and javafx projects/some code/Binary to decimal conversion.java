import java.util.Scanner;
 
import static java.lang.Math.decrementExact;
import static java.lang.Math.pow;
 
public class Main {
 
    public static void main(String[] args) {
	  String binary;
        Scanner scanner = new Scanner(System.in);
         binary= scanner.nextLine();
       String b1;
        String b2;
        String b3;
       long num1 = 0,num2,num3;

       long decimalNum,decimalNum2,decimalNum3;
       decimalNum=0;
       decimalNum2=0;
       decimalNum3=0;
     int i=binary.length()-1;
       int j=0;
       int k=0;
       int count=0,count2=0;
        while (binary.length()!=count)
        {
              
            num1= Character.getNumericValue(binary.charAt(i));
            decimalNum += num1* pow(2, count);
          
            i--;
            count++;
 
            
 
        }
        
 
 
 
   
 
       
 
         System.out.println(decimalNum);
         
 
    }
}