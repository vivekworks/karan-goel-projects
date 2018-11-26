/**
 * Purpose - Figure out the change and the number of quarters, dimes, nickels, pennies needed for the change against the cost of an item and the money provided.
 * Author  - Vivek T S
 * Date    - 25/11/2018
 * Values  -   Dollar          : $1
 * Quarter         : $0.25
 * Dime            : $0.10
 * Nickel          : $0.05
 * Penny(cent)     : $0.01
 * Dollars used    : $1, $5, $10, $20, $50, $100
 */
package com.vivekworks.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class ChangeReturn {
    public String returnChange() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the cost --> ");
            BigDecimal itemCost = new BigDecimal(reader.readLine());
            System.out.print("Enter the money --> ");
            BigDecimal money = new BigDecimal(reader.readLine());
            reader.close();
            return computeChange(itemCost, money);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    private String computeChange(BigDecimal itemCost, BigDecimal money) {
        BigDecimal hundredDollar = new BigDecimal(100);
        BigDecimal fiftyDollar = new BigDecimal(50);
        BigDecimal twentyDollar = new BigDecimal(20);
        BigDecimal tenDollar = BigDecimal.TEN;
        BigDecimal fiveDollar = new BigDecimal(5);
        BigDecimal dollar = BigDecimal.ONE;
        BigDecimal quarter = new BigDecimal(0.25);
        BigDecimal dime = new BigDecimal(0.10);
        BigDecimal nickel = new BigDecimal(0.05);
        BigDecimal penny = new BigDecimal(0.01);
        BigDecimal difference = itemCost.subtract(money).abs();
        StringBuilder change = new StringBuilder();
        while (difference.compareTo(BigDecimal.ZERO) > 0) {
            if (difference.compareTo(hundredDollar) >= 0)
                difference = processDifference(hundredDollar, difference, change);
            else if (difference.compareTo(fiftyDollar) >= 0)
                difference = processDifference(fiftyDollar, difference, change);
            else if (difference.compareTo(twentyDollar) >= 0)
                difference = processDifference(twentyDollar, difference, change);
            else if (difference.compareTo(tenDollar) >= 0)
                difference = processDifference(tenDollar, difference, change);
            else if (difference.compareTo(fiveDollar) >= 0)
                difference = processDifference(fiveDollar, difference, change);
            else if (difference.compareTo(dollar) >= 0)
                difference = processDifference(dollar, difference, change);
            else if (difference.compareTo(quarter) >= 0)
                difference = processDifference(quarter, difference, change);
            else if (difference.compareTo(dime) >= 0)
                difference = processDifference(dime, difference, change);
            else if (difference.compareTo(nickel) >= 0)
                difference = processDifference(nickel, difference, change);
            else if (difference.compareTo(penny) >= 0)
                difference = processDifference(penny, difference, change);
        }
        return String.valueOf(change);
    }

    private BigDecimal processDifference(BigDecimal currency, BigDecimal difference, StringBuilder change) {
        System.out.println(difference+" - "+currency);
        BigDecimal result = difference.divide(currency,0,RoundingMode.HALF_EVEN).setScale(0,RoundingMode.FLOOR);//, difference.toString().length() + 2, RoundingMode.UP);
        System.out.println(result);
        if (result.compareTo(BigDecimal.ONE) >= 0) {
            difference = difference.subtract(result.multiply(currency)).abs();
            System.out.println("after - "+difference);
            change.append(result + " $" + currency + " bills");
        }
        return difference;
    }
}
