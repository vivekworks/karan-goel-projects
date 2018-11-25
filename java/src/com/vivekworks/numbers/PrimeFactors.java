/**
 * Purpose - Find the prime factors of the given number
 * Author  - Vivek T S
 * Date    - 24/11/2018
 */
package com.vivekworks.numbers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactors {
    final BigDecimal zero = new BigDecimal(0);
    public String getPrimeFactors() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a number to find it's prime factors --> ");
        BigDecimal number = inputScanner.nextBigDecimal();
        if (number.compareTo(new BigDecimal(0)) > 0) {
            return generateFactors(number);
        } else {
            System.out.println("Enter a positive number");
            getPrimeFactors();
        }
        return null;
    }

    public String generateFactors(BigDecimal number) {
        ArrayList<BigDecimal> primeList = findAllPrimes(number);
        ArrayList<BigDecimal> primeFactorsList = new ArrayList<>();
        //System.out.println(primeList);
        boolean flag = true;
        for (BigDecimal prime : primeList) {
            //System.out.println("Prime - "+prime);
            if (number.remainder(prime).compareTo(zero) == 0) {
                flag = false;
                primeFactorsList.add(prime);
                number = number.divide(prime, RoundingMode.UP);
                //System.out.println(number+" - "+number.remainder(prime));
                if (number.remainder(prime).compareTo(zero) == 0)
                    break;
                flag = true;
                generateFactors(number);
            }
        }
        //System.out.println(flag+" - "+number);
        if (flag) primeFactorsList.add(number);
        //System.out.println(primeFactorsList);
        return String.valueOf(primeFactorsList);
    }

    /**
     * Gives out all primes that are lesser than the sqrt of the input value
     * @param value - Number whose prime list to be found
     * @return - List of all primes lesser than the sqrt of the given number
     */
    public ArrayList<BigDecimal> findAllPrimes(BigDecimal value) {
        final BigDecimal one = new BigDecimal(1);
        BigDecimal approxSqrtValue = value.sqrt(new MathContext(value.toString().length() % 2 == 0 ? value.toString().length() / 2 : value.toString().length() / 2 + 1, RoundingMode.FLOOR));
        BigDecimal primeValue = one;
        ArrayList<BigDecimal> primeList = new ArrayList<>();
        boolean flag = true;
        //System.out.println(approxSqrtValue);
        while (primeValue.compareTo(approxSqrtValue) <= 0) {
            primeValue = primeValue.add(one);
            for (BigDecimal list : primeList) {
                flag = true;
                if (primeValue.remainder(list).compareTo(zero) == 0) {
                    flag = false;
                    break;
                }
            }
            //System.out.println(primeValue+" - "+flag);
            if (flag) primeList.add(primeValue);
            //System.out.println(primeValue + " - " + primeList);
        }
        return primeList;
    }
}
