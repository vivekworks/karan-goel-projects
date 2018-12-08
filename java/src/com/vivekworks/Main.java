/**
 * Purpose - Main program to call all the programs under Numbers section
 * Author  - Vivek T S
 * Date    - 20/11/2018
 */
package com.vivekworks;

import com.vivekworks.numbers.*;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        new Main().begin();
    }

    private void begin(){
        Scanner programInput = new Scanner(System.in);
        System.out.println("01. Pi to Nth Digit");
        System.out.println("02. e to Nth Digit");
        System.out.println("03. Fibonacci Sequence");
        System.out.println("04. Prime Factors");
        System.out.println("05. Next Prime Number");
        System.out.println("06. Cost of Tiles");
        System.out.println("07. Mortgage Calculator");
        System.out.println("08. Change Return");
        System.out.println("09. Binary And Decimal Converter");
        System.out.println("10. Calculator");
        System.out.println("11. Unit Converter");
        System.out.println("12. Alarm Clock");
        System.out.println("13. Distance between two cities");
        System.out.println("14. Credit card validator");
        System.out.println("15. Tax Calculator");
        System.out.println("16. The Factorial");
        System.out.println("17. Complex Number");
        System.out.println("18. Happy Numbers");
        System.out.println("19. Number Names");
        System.out.println("20. Coin Flip Simulation");
        System.out.println("21. Limit Calculator");
        System.out.println("22. Fast Exponentiation");
        System.out.println("99. Exit");
        System.out.print("Choose a program number to run --> ");
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
            case 18 : happyNumbers();
                break;
            case 19 : numberNames();
                break;
            case 20 : coinFlipSimulator();
                break;
            case 21 : limitCalculator();
                break;
            case 22 : fastExponentiation();
                break;
            case 99: System.out.println("Goodbye!");
                break;
            default: System.out.println("Wrong option!");
        }
    }

    private void piToNthDigit(){
        PiToNthDigit piProgram = new PiToNthDigit();
        System.out.println(piProgram.beginPi());
    }

    private void etoNthDigit(){
        EToNthDigit eProgram = new EToNthDigit();
        System.out.println(eProgram.beginE());
    }

    private void fibonacciSequence(){
        FibonacciSequence fiboProgram = new FibonacciSequence();
        System.out.println(fiboProgram.beginFibonacci());
    }

    private void primeFactors(){
        PrimeFactors primeFactorProgram = new PrimeFactors();
        System.out.println(primeFactorProgram.getPrimeFactors());
    }

    private void nextPrimeNumber(){
        new NextPrimeNumber().getNextPrime();
    }

    private void costOfTiles(){
        System.out.println(new CostOfTile().getCost());
    }

    private void mortgageCalculator(){
        new MortgageCalculator().calculateMortgage();
    }

    private void changeReturn(){
        System.out.println(new ChangeReturn().returnChange());
    }

    private void binaryAndDecimalConverter(){
        System.out.println(new BinaryAndDecimalConverter().runConverter());
    }

    private void calculator(){
        System.out.println(new Calculator().runCalculator());
    }

    private void unitConverter(){
        System.out.println(new UnitConverter().runConverter());
    }

    private void alarmClock(){
        new AlarmClock().runAlarmClock();
    }

    private void distanceBetweenCities(){
        System.out.println(new DistanceBetweenCities().begin());
    }

    private void creditCardValidator(){
        System.out.println(new CreditCardValidator().begin());
    }

    private void taxCalculator(){
        System.out.println(new TaxCalculator().begin());
    }

    private void factorial(){
        System.out.println(new Factorial().begin());
    }

    private void complexNumber(){
        new ComplexNumber().begin();
    }

    private void happyNumbers(){
        new HappyNumbers().begin();
    }

    private void numberNames(){
        System.out.println(new NumberNames().begin());
    }

    private void coinFlipSimulator(){
        System.out.println(new CoinFlipSimulator().begin());
    }

    private void limitCalculator(){
        System.out.println(new LimitCalculator().begin());
    }

    private void fastExponentiation(){
        System.out.println(new FastExponentiation().begin());
    }
}
