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
        BigDecimal hundredDollar = new BigDecimal(100).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal fiftyDollar = new BigDecimal(50).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal twentyDollar = new BigDecimal(20).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal tenDollar = new BigDecimal(10).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal fiveDollar = new BigDecimal(5).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal dollar = new BigDecimal(1).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal quarter = new BigDecimal(0.25).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal dime = new BigDecimal(0.10).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal nickel = new BigDecimal(0.05).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal penny = new BigDecimal(0.01).setScale(2,RoundingMode.HALF_EVEN);
        BigDecimal difference = itemCost.subtract(money).abs();
        StringBuilder change = new StringBuilder();
        while (difference.compareTo(BigDecimal.ZERO) > 0) {
            if (difference.compareTo(hundredDollar) >= 0)
                difference = processDifference(hundredDollar, difference, change,"Hundred Dollar");
            else if (difference.compareTo(fiftyDollar) >= 0)
                difference = processDifference(fiftyDollar, difference, change,"Fifty Dollar");
            else if (difference.compareTo(twentyDollar) >= 0)
                difference = processDifference(twentyDollar, difference, change,"Twenty Dollar");
            else if (difference.compareTo(tenDollar) >= 0)
                difference = processDifference(tenDollar, difference, change,"Ten Dollar");
            else if (difference.compareTo(fiveDollar) >= 0)
                difference = processDifference(fiveDollar, difference, change,"Five Dollar");
            else if (difference.compareTo(dollar) >= 0)
                difference = processDifference(dollar, difference, change,"One Dollar");
            else if (difference.compareTo(quarter) >= 0)
                difference = processDifference(quarter, difference, change,"Quarter");
            else if (difference.compareTo(dime) >= 0)
                difference = processDifference(dime, difference, change,"Dime");
            else if (difference.compareTo(nickel) >= 0)
                difference = processDifference(nickel, difference, change,"Nickel");
            else if (difference.compareTo(penny) >= 0)
                difference = processDifference(penny, difference, change,"Penny");
        }
        return String.valueOf(change);
    }

    private BigDecimal processDifference(BigDecimal currency, BigDecimal difference, StringBuilder change, String currencyType) {
        currency = currency.setScale(2,RoundingMode.HALF_EVEN);
        //System.out.println(difference+" - "+currency);
        //BigDecimal result = difference.compareTo(BigDecimal.ONE) <0 ?  difference.divide(currency,2,RoundingMode.FLOOR) : difference.divide(currency,0,RoundingMode.FLOOR);
        BigDecimal result = difference.divide(currency,0,RoundingMode.FLOOR);
        //System.out.println(result);
        if (result.compareTo(BigDecimal.ONE) >= 0) {
            difference = difference.subtract(result.multiply(currency)).abs();
            //System.out.println("after - "+difference);
            change.append("\n"+result + " "+currencyType+"(s) ($ " + currency + ")");
        }
        return difference;
    }
}
