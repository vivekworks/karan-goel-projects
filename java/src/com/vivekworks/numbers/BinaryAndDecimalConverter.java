/**
 * Purpose - Develop a converter to convert a decimal number to binary or a binary number to its decimal equivalent.
 * Author  - Vivek T S
 * Date    - 28/11/2018
 */
package com.vivekworks.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class BinaryAndDecimalConverter {
    final BigDecimal two = new BigDecimal(2);
    public String runConverter(){
        System.out.println("----Choose an option----");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        System.out.print("Option ---> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String option = reader.readLine();
            System.out.print("Enter a whole number --> ");
            BigDecimal number = new BigDecimal(reader.readLine());
            if (option.equalsIgnoreCase("1"))
                return convertBinaryToDecimal(number);
            else
                return convertDecimalToBinary(number);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }

    private String convertBinaryToDecimal(BigDecimal number){
        char[] deciArray = String.valueOf(number).toCharArray();
        BigDecimal sum = BigDecimal.ZERO;
        for(int i=0;i<deciArray.length;i++){
            //System.out.println(two.pow(i)+" - "+new BigDecimal(deciArray[i]-'0').multiply(two.pow(i))+" - "+new BigDecimal(deciArray[i]-'0'));
            sum = sum.add(new BigDecimal(deciArray[i]-'0').multiply(two.pow(deciArray.length - (i+1))));
        }
        return String.valueOf(sum);
    }

    private String convertDecimalToBinary(BigDecimal number){
        //System.out.println("number - "+number);
        StringBuilder binaryValue = new StringBuilder();
        while (number.compareTo(BigDecimal.ZERO) > 0){
            BigDecimal[] divRem = number.divideAndRemainder(two);
            number = divRem[0];
            binaryValue = binaryValue.append(divRem[1]);
        }
        //binaryValue.append(number);
        return String.valueOf(binaryValue.reverse());
    }
}
