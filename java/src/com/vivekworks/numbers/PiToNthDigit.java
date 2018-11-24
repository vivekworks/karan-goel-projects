/**
 * Purpose   - Find Pi to the Nth Digit
 * Author    - Vivek T S
 * Date      - 20/11/2018
 * Algorithm - Chudnovsky Algorithm
 * Pi = C * [ (k=0 to ∞) Σ Mk * Lk / Xk ] ^ -1
 */
package com.vivekworks.numbers;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
public class PiToNthDigit{

    private final BigDecimal C = new BigDecimal(426880 * Math.sqrt(10005));
    private final BigDecimal L = new BigDecimal(545140134.0);
    private final BigDecimal X = new BigDecimal(-262537412640768000.0);
    private final BigDecimal K = new BigDecimal(12);

    public BigDecimal computeNextSum(BigDecimal Mk, BigDecimal Lk, BigDecimal Xk){
        return (Mk.multiply(Lk).divide(Xk,32767,RoundingMode.HALF_UP));
    }
    public BigDecimal computeNextM(BigDecimal Mk, BigDecimal Kk, int k){
        return Mk.multiply(((Kk.pow(3)).subtract(Kk.multiply(new BigDecimal(16)))).divide(((new BigDecimal(k+1)).pow(3)),32767, RoundingMode.UP));
    }
    public BigDecimal computeNextL(BigDecimal Lk){
        return Lk.add(L);
    }
    public BigDecimal computeNextX(BigDecimal Xk){
        return Xk.multiply(X);
    }
    public BigDecimal computeNextK(BigDecimal Kk){
        return Kk.add(K);
    }
    public BigDecimal roundPi(BigDecimal pi,int nthDigit){
        return pi.round(new MathContext(nthDigit+1,RoundingMode.FLOOR));
    }
    public BigDecimal beginPi(){
        System.out.print("Enter the nth digit : ");
        Scanner userInput = new Scanner(System.in);
        int nthDigit = userInput.nextInt();
        if (nthDigit > 0 && nthDigit <= 32767)
            return computePi(nthDigit);
        else {
            System.out.println("Enter a digit from 1 to 32767");
            beginPi();
        }
        return null;
    }
    public BigDecimal computePi(int nthDigit){
        System.out.print("");
        BigDecimal Mk = new BigDecimal(1.0);
        BigDecimal Lk = new BigDecimal(13591409.0);
        BigDecimal Xk = new BigDecimal(1.0);
        BigDecimal Kk = new BigDecimal(6.0);
        BigDecimal sum = new BigDecimal(0.0);
        for (int k=0;k<=nthDigit;k++){
            sum = sum.add(computeNextSum(Mk,Lk,Xk));
            Mk = computeNextM(Mk,Kk,k);
            Lk = computeNextL(Lk);
            Xk = computeNextX(Xk);
            Kk = computeNextK(Kk);
        }
        BigDecimal pi = C.multiply(new BigDecimal(1).divide(sum,32767,RoundingMode.UP));
        return roundPi(pi,nthDigit);
    }
}