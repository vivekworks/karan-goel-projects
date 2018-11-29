/**
 * Purpose - Calculator to perform arithmetic operations - Addition, Subtraction, Multiplication, Division, Modulo Division
 * Author  - Vivek T S
 * Date    - 29/11/2018
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class Calculator {

    public int runCalculator(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("----Calculator----");
        System.out.print("Choose the operation to be performed (+,-,*,/,%) --> ");
        String operation = inputScanner.nextLine().trim();
        System.out.print("Enter the numbers with comma separated between them --> ");
        String[] numbers = inputScanner.nextLine().split(",");
        return calculate(numbers,operation);
    }

    private int calculate(String[] numbers,String operation){
        int num1 = Integer.parseInt(numbers[0]),num2= Integer.parseInt(numbers[1]);
        switch (operation.charAt(0)){
            case '+' : return (num1+num2);
            case '-' : return (num1-num2);
            case '*' : return (num1*num2);
            case '/' : return (num1/num2);
            case '%' : return (num1%num2);
        }
        return 0;
    }
}
