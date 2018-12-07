/**
 * Purpose - Simulate flipping a single coin however many times the user decides. The code should record the outcomes and count the number of tails and heads.
 * Author  - Vivek T S
 * Date    - 07/12/2018
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class CoinFlipSimulator {
    public String begin(){
        StringBuilder flipBuilder = new StringBuilder();
        System.out.print("Enter the times to flip the coin --> ");
        int times = new Scanner(System.in).nextInt();
        for(int i=0;i<times;i++)
            flipBuilder.append((i+1)+". "+((int)(Math.random() * 2) == 0 ? "Heads" : "Tails")+"\n");
        return String.valueOf(flipBuilder);
    }
}
