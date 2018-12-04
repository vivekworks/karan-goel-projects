/**
 * Purpose      - Takes in a credit card number from a common credit card vendor (Visa, MasterCard, American Express, Discoverer) and validates it to make sure that it is a valid number (look into how credit cards use a checksum).
 * Author       - Vivek T S
 * Date         - 04/12/2018
 * Algorithm    - Luhn Algorithm
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class CreditCardValidator {
    public boolean begin() {
        System.out.print("Enter the credit card no. --> ");
        Scanner input = new Scanner(System.in);
        String creditCardNo = input.nextLine();
        return validateCard(creditCardNo);
    }

    public boolean validateCard(String creditCardNo) {
        int sum = 0, add = 0;
        for (int i = creditCardNo.length() - 1; i >= 0; i--) {
            add = Integer.parseInt(creditCardNo.substring(i, i + 1));
            if ((creditCardNo.length() - i) % 2 == 0)
                add = (2 * add);
            add = add / 10 + add % 10;
            sum += add;
        }
        return sum % 10 == 0;
    }
}
