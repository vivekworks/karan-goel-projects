package com.vivekworks;

import com.vivekworks.numbers.EToNthDigit;
import com.vivekworks.numbers.PiToNthDigit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        /*BigDecimal a = new BigDecimal(3.1415926535417929768);
        System.out.println(a.round(new MathContext(5,RoundingMode.HALF_UP)));
        a = new BigDecimal(3.1415926535417929768);
        System.out.println(a.round(new MathContext(5,RoundingMode.HALF_DOWN)));
        a = new BigDecimal(3.1415926535417929768);
        System.out.println(a.round(new MathContext(5,RoundingMode.HALF_EVEN)));
        a = new BigDecimal(3.1415926535417929768);
        System.out.println(a.round(new MathContext(5,RoundingMode.FLOOR)));
        a = new BigDecimal(3.1415926535417929768);
        System.out.println(a.round(new MathContext(5,RoundingMode.UP)));
        a = new BigDecimal(3.1415926535417929768);
        System.out.println(a.round(new MathContext(5,RoundingMode.DOWN)));
        a = new BigDecimal(3.1415926535417929768);
        System.out.println(a.round(new MathContext(5,RoundingMode.CEILING)));*/
        new Main().begin();
    }

    public void begin(){
        Scanner programInput = new Scanner(System.in);
        System.out.println("1. Pi to Nth Digit");
        System.out.println("2. e to Nth Digit");
        System.out.print("Choose a program number to run--> ");
        int programNo = programInput.nextInt();
        switch(programNo){
            case 1 : piToNthDigit();
                break;
            case 2 : etoNthDigit();
                break;
            default: piToNthDigit();
        }
    }

    public void piToNthDigit(){
        PiToNthDigit piProgram = new PiToNthDigit();
        System.out.println(piProgram.beginPi());
    }

    public void etoNthDigit(){
        EToNthDigit eProgram = new EToNthDigit();
        System.out.println(eProgram.beginE());
    }
}
