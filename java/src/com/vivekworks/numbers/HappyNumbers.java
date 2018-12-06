/**
 * Purpose - A happy number is defined by the following process. Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers, while those that do not end in 1 are unhappy numbers. Display an example of your output here. Find first 8 happy numbers.
 * Author  - Vivek T S
 * Date    - 05/12/2018
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class HappyNumbers {
    public void begin(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Happy Number check");
        System.out.println("2. First 8 Happy Numbers");
        System.out.print("Choose an option --> ");
        int option = input.nextInt();
        if(option == 1) {
            System.out.print("Enter the positive integer --> ");
            if (happyNumberCheck(input.nextInt()) == null)
                System.out.println("Not a happy number");
        } else{
            System.out.println(first8HappyNumbers());
        }
    }

    public String happyNumberCheck(int number){
        StringBuilder output = new StringBuilder(String.valueOf(number));
        int sum;
        try {
            while (number < Integer.MAX_VALUE && number != 1) {
                sum = 0;
                for (char val : String.valueOf(number).toCharArray()) {
                    sum += Math.pow(val - '0', 2);
                }
                number = sum;
                output.append(", " + number);
            }
        } catch (OutOfMemoryError oome){
            return null;
        }
        return String.valueOf(output);
    }

    public String first8HappyNumbers(){
        StringBuilder happyBuilder = new StringBuilder();
        int start = 2;
        int count=0;
        while(start < Integer.MAX_VALUE && count < 8){
            if(happyNumberCheck(start) != null) {
                count++;
                happyBuilder.append(start + ", ");
            }
            start++;
        }
        return String.valueOf(happyBuilder);
    }
}
