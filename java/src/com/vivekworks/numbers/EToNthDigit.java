/**
 * Purpose - Find e to the Nth Digit
 * Author  - Vivek T S
 * Date    - 24/11/2018
 * e = [ (n=0 to ∞) Σ (1/n!)]
 */
package com.vivekworks.numbers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class EToNthDigit {

    public BigDecimal beginE(){
        System.out.print("Enter the nth digit : ");
        Scanner scanInput = new Scanner(System.in);
        int nthDigit = scanInput.nextInt();
        if(nthDigit > 0 && nthDigit <= 32767){
            return computeE(nthDigit);
        } else{
            System.out.println("Enter a digit from 1 to 32767");
            beginE();
        }
        return null;
    }

    public BigDecimal getNthFactorial(int nthDigit, BigDecimal iterFactorial){
        if(nthDigit <= 0) return new BigDecimal(1);
        return new BigDecimal(nthDigit).multiply(iterFactorial);
    }

    public BigDecimal roundE(int nthDigit, BigDecimal e){
        return e.round(new MathContext(nthDigit+1,RoundingMode.FLOOR));
    }

    public BigDecimal computeE(int nthDigit){
        BigDecimal fact = new BigDecimal(0);
        BigDecimal iterFactorial = new BigDecimal(1);
        for (int n=0;n<=nthDigit;n++){
            iterFactorial = getNthFactorial(n,iterFactorial);
            //System.out.println(iterFactorial);
            fact = fact.add(new BigDecimal(1).divide(iterFactorial,32767, RoundingMode.UP));
            //System.out.println(fact);
        }
        return roundE(nthDigit, fact);
    }
}
