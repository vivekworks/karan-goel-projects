/**
 * Purpose - Calculate Mortgage
 * Author  - Vivek T S
 * Date    - 25/11/2018
 * Formula - A = P*(1 + r%/n)^(n*t) = P * B ^ C
 *              A = the future value of the loan, including interest
 *              P = the principal loan amount
 *              r = the annual interest rate (decimal)
 *              n = the number of times that interest is compounded per year
 *              t = the number of years the money is borrowed for
 *              B = (1+r%/n)
 *              C = n*t
 *
 */
package com.vivekworks.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MortgageCalculator {
    public void calculateMortgage(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Loan Amount, Interest Rate, Interest compounded interval per year, term of the loan in years(comma separated) --> ");
        try {
            String[] mortgageSpec = reader.readLine().split(",");
            if(mortgageSpec.length == 4)
                computeLoan(mortgageSpec);
            else {
                System.out.print("Enter the 4 specs correctly!");
                calculateMortgage();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void computeLoan(String[] mortgageSpec){
        BigDecimal b = new BigDecimal(1).add((new BigDecimal(mortgageSpec[1]).divide((new BigDecimal(mortgageSpec[2]).multiply(new BigDecimal(100))),15, RoundingMode.UP))); // B = (1+r%/n)
        BigDecimal c = new BigDecimal(mortgageSpec[2]).multiply(new BigDecimal(mortgageSpec[3]));
        BigDecimal totalAmount = new BigDecimal(mortgageSpec[0]).multiply((b.pow(c.intValue())));
        BigDecimal totalInterestAmount = totalAmount.subtract(new BigDecimal(mortgageSpec[0]));
        BigDecimal monthlyPayment = totalAmount.divide(new BigDecimal(mortgageSpec[3]).multiply(new BigDecimal(12)),RoundingMode.UP);
        //System.out.println(totalAmount+" - "+totalInterestAmount+" - "+monthlyPayment);
        System.out.println("Principal Loan Amount        --> "+mortgageSpec[0]);
        System.out.println("Interest Rate                --> "+mortgageSpec[1]);
        System.out.println("Compounded interval per year --> "+mortgageSpec[2]);
        System.out.println("No. of years                 --> "+mortgageSpec[3]);
        System.out.println("Total Amount to be paid      --> "+totalAmount.round(new MathContext(totalAmount.toString().indexOf(".")+2,RoundingMode.UP)));
        System.out.println("Interest amount to be paid   --> "+totalInterestAmount.round(new MathContext(totalInterestAmount.toString().indexOf(".")+2,RoundingMode.UP)));
        System.out.println("Monthly payment amount       --> "+monthlyPayment.round(new MathContext(monthlyPayment.toString().indexOf(".")+2,RoundingMode.UP)));
    }
}
