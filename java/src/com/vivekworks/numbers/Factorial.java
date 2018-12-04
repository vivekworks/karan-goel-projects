/**
 * Purpose - The Factorial of a positive integer, n, is defined as the product of the sequence n, n-1, n-2, ...1 and the factorial of zero, 0, is defined as being 1. Solve this using both loops and recursion.
 * Author  - Vivek T S
 * Date    - 04/12/2018
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class Factorial {
    public long begin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a way to determine the factorial");
        System.out.println("1. Loops");
        System.out.println("2. Recursion");
        System.out.print("Option --> ");
        int option = input.nextInt();
        System.out.print("Enter the positive integer --> ");
        int n = input.nextInt();
        input.nextLine();
        if(option == 1)
            return loops(n);
        return recursion(n);
    }

    public long loops(int n){
        long fact=1;
        for(int i=n;i>0;i--)
            fact = fact * i;
        return fact;
    }

    public long recursion(int n){
        if(n==1) return 1;
        return (n * recursion(n-1));
    }
}
