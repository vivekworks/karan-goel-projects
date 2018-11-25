/**
 * Purpose - Find prime numbers until the user chooses to stop asking for the next one.
 * Author  - Vivek T S
 * Date    - 25/11/2018
 */
package com.vivekworks.numbers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NextPrimeNumber {
    public void getNextPrime() {
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<BigDecimal> primeList = new ArrayList<>();
        System.out.print("Do you want to print the next Prime? (Y/N) --> ");
        while ((inputScanner.nextLine()).equalsIgnoreCase("Y")) {
            System.out.println(generatePrime(primeList));
            System.out.print("Do you want to print the next Prime? (Y/N) --> ");
        }
    }

    public BigDecimal generatePrime(ArrayList<BigDecimal> primeList) {
        BigDecimal nextPrime = null;
        if (primeList.size() == 0) {
            nextPrime = new BigDecimal(2);
            primeList.add(nextPrime);
            return nextPrime;
        }
        BigDecimal nextNum = primeList.get(primeList.size() - 1), prime = null;
        while (nextPrime == null) {
            nextNum = nextNum.add(new BigDecimal(1));
            //System.out.println(nextNum);
            boolean flag = true;
            Iterator<BigDecimal> primeIter = primeList.iterator();
            while (flag && primeIter.hasNext()) {
                prime = primeIter.next();
                //System.out.println(prime);
                if (nextNum.remainder(prime).compareTo(new BigDecimal(0)) == 0)
                    flag = false;
            }
            if (flag) {
                nextPrime = nextNum;
                primeList.add(nextPrime);
            }
        }
        return nextPrime;
    }
}
