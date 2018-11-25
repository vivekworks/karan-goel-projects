/**
 * Purpose - Generate Fibonacci Sequence up to the given number
 * Author  - Vivek T S
 * Date    - 24/11/2018
 */
package com.vivekworks.numbers;

import java.math.BigDecimal;
import java.util.Scanner;

public class FibonacciSequence {
    public String beginFibonacci(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the number up to which the Fibonacci Sequence to be generated --> ");
        BigDecimal number = inputScanner.nextBigDecimal();
        if(number.compareTo(new BigDecimal(0)) >= 0){
            return generateSequence(number);
        } else{
            System.out.println("Enter a number greater than or equal to zero ");
            beginFibonacci();
        }
        return null;
    }

    public String generateSequence(BigDecimal number){
        StringBuilder fiboSequence = new StringBuilder();
        BigDecimal fibo1 = new BigDecimal(-1);
        BigDecimal fibo2 = new BigDecimal(1);
        BigDecimal fibo = new BigDecimal(0);
        while(true){
            fibo = fibo1.add(fibo2);
            fibo1 = fibo2;
            fibo2 = fibo;
            if(fibo.compareTo(number) <= 0)
                fiboSequence.append(fibo+" ");
            else {
                break;
            }
        }
        return String.valueOf(fiboSequence);
    }
}
