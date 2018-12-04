/**
 * Purpose - Main program to call all the programs under Numbers section
 * Author  - Vivek T S
 * Date    - 20/11/2018
 */
package com.vivekworks;

import com.vivekworks.numbers.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        new Main().begin();
        //System.out.println(Calendar.getInstance().getTimeInMillis());
    }

    public void begin(){
        Scanner programInput = new Scanner(System.in);
        System.out.println("1. Pi to Nth Digit");
        System.out.println("2. e to Nth Digit");
        System.out.println("3. Fibonacci Sequence");
        System.out.println("4. Prime Factors");
        System.out.println("5. Next Prime Number");
        System.out.println("6. Cost of Tiles");
        System.out.println("7. Mortgage Calculator");
        System.out.println("8. Change Return");
        System.out.println("9. Binary And Decimal Converter");
        System.out.println("10. Calculator");
        System.out.println("11. Unit Converter");
        System.out.println("12. Alarm Clock");
        System.out.println("13. Distance between two cities");
        System.out.println("14. Credit card validator");
        System.out.println("15. Tax Calculator");
        System.out.println("16. The Factorial");
        System.out.println("17. Complex Number");
        System.out.println("99. Exit");
        System.out.print("Choose a program number to run--> ");
        int programNo = programInput.nextInt();
        switch(programNo){
            case 1 : piToNthDigit();
                break;
            case 2 : etoNthDigit();
                break;
            case 3 : fibonacciSequence();
                break;
            case 4 : primeFactors();
                break;
            case 5 : nextPrimeNumber();
                break;
            case 6 : costOfTiles();
                break;
            case 7 : mortgageCalculator();
                break;
            case 8 : changeReturn();
                break;
            case 9 : binaryAndDecimalConverter();
                break;
            case 10 : calculator();
                break;
            case 11 : unitConverter();
                break;
            case 12 : alarmClock();
                break;
            case 13 : distanceBetweenCities();
                break;
            case 14 : creditCardValidator();
                break;
            case 15 : taxCalculator();
                break;
            case 16 : factorial();
                break;
            case 17 : complexNumber();
                break;
            case 99: System.out.println("Goodbye!");
                break;
            default: System.out.println("Wrong option!");
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

    public void fibonacciSequence(){
        FibonacciSequence fiboProgram = new FibonacciSequence();
        System.out.println(fiboProgram.beginFibonacci());
    }

    public void primeFactors(){
        PrimeFactors primeFactorProgram = new PrimeFactors();
        System.out.println(primeFactorProgram.getPrimeFactors());
    }

    public void nextPrimeNumber(){
        new NextPrimeNumber().getNextPrime();
    }

    public void costOfTiles(){
        System.out.println(new CostOfTile().getCost());
    }

    public void mortgageCalculator(){
        new MortgageCalculator().calculateMortgage();
    }

    public void changeReturn(){
        System.out.println(new ChangeReturn().returnChange());
    }

    public void binaryAndDecimalConverter(){
        System.out.println(new BinaryAndDecimalConverter().runConverter());
    }

    public void calculator(){
        System.out.println(new Calculator().runCalculator());
    }

    public void unitConverter(){
        System.out.println(new UnitConverter().runConverter());
    }

    public void alarmClock(){
        new AlarmClock().runAlarmClock();
    }

    public void distanceBetweenCities(){
        System.out.println(new DistanceBetweenCities().begin());
    }

    public void creditCardValidator(){
        System.out.println(new CreditCardValidator().begin());
    }

    public void taxCalculator(){
        System.out.println(new TaxCalculator().begin());
    }

    public void factorial(){
        System.out.println(new Factorial().begin());
    }

    public void complexNumber(){
        new ComplexNumber().begin();
    }
}
