/**
 * Purpose - Tax Calculator - Asks the user to enter a cost and either a country or state tax. It then returns the tax plus the total cost with tax.
 * Author  - Vivek T S
 * Date    - 04/12/2018
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class TaxCalculator {
    public String begin(){
        System.out.print("Enter the cost                --> ");
        Scanner input = new Scanner(System.in);
        long cost = input.nextLong();
        System.out.print("Enter the state/country tax   --> ");
        double tax = input.nextDouble();
        return "Tax : "+(tax * cost)/100+", Total cost : "+ (cost+(tax * cost)/100);
    }
}
