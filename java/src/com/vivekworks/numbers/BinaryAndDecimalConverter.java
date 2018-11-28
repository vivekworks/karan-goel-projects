/**
 * Purpose - Develop a converter to convert a decimal number to binary or a binary number to its decimal equivalent.
 * Author  - Vivek T S
 * Date    - 28/11/2018
 */
package com.vivekworks.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryAndDecimalConverter {

    public String runConverter(){
        System.out.println("----Choose an option----");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        System.out.print("Option ---> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            if (reader.readLine().equalsIgnoreCase("1"))
                return convertBinaryToDecimal();
            else
                return convertDecimalToBinary();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }

    public String convertBinaryToDecimal(){
        return null;
    }

    public String convertDecimalToBinary(){
        return null;
    }
}
