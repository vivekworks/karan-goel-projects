/**
 * Purpose - User to enter 2 integers a and b and output a^b (i.e. pow(a,b)) in O(lg n) time complexity.
 * Author  - Vivek T S
 * Date    - 08/12/2018
 * Since I don't know about the O(log n) time complexity concept, I've done it this way now. Will come back to edit once I learn that concept.
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class FastExponentiation {
    public double begin(){
        System.out.print("Enter the two numbers in a,b format --> ");
        String[] input = new Scanner(System.in).nextLine().trim().split(",");
        if(input.length < 2)
            System.out.println("Enter the numbers in the correct format!!!");
        else
            return pow(Double.parseDouble(input[0]),Double.parseDouble(input[1]));
        return 0;
    }

    public double pow(double a, double b){
        double product=1;
        for (int i=0;i<Math.floor(b/2);i++){
            product*=a;
        }
        return b/2 == (int)(b/2) ? product * product : product*product*a;
    }
}
