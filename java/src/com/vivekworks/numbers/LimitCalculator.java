/**
 * Purpose - User to enter f(x) and the limit value, then return the value of the limit statement
 * Author  - Vivek T S
 * Date    - 07/12/2018
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class LimitCalculator {
    public String begin(){
        System.out.println("Use ^ for the 'to the power of' relation. Enter x as the variable and not others");
        System.out.print("Enter the equation : f(x)        --> ");
        Scanner input = new Scanner(System.in);
        String equation = input.nextLine();
        System.out.print("Enter the limit    : lim x ->    --> ");
        int limit = input.nextInt();
        return calculate(equation,limit);
    }

    public String calculate(String equation, int limit){
        //char[] equationArray = equation.toCharArray();
        double output=0.0,buffer=0.0;
        String[] strArray = equation.substring(0,1).equals("-") ? equation.substring(1).split("\\+") : equation.split("\\+");
        for(String val :strArray){

        }
        /*for(int i=0;i<equationArray.length;i++){
            System.out.println(equationArray[i]);
            if(equationArray[i]-'0' >=0 && equationArray[i]-'0' <= 9)
                buffer =equationArray[i];
        }*/
        return null;
    }

    public String segregate(String module, String operation){
        return null;
    }
}