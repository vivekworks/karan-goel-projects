/**
 * Purpose - Show how to spell out a number in English. You can use a preexisting implementation or roll your own, but you should support inputs up to at least one million (or the maximum value of your language's default bounded integer type, if that's less). Optional: Support for inputs other than positive integers (like zero, negative integers, and floating-point numbers).
 * Author  - Vivek T S
 * Date    - 05/12/2018
 * System  - Indian System
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class NumberNames {
    public String begin() {
        System.out.print("Enter a number --> ");
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        return getNumberNames(number);
    }

    public String getNumberNames(long number) {
        StringBuilder numberNames = new StringBuilder();
        char[] numberArray = String.valueOf(number).toCharArray();
        for (int i = 0; i < numberArray.length; i++) {
            int digit = numberArray[i] - '0';
            if ((numberArray.length - i - 1) != 0 && (numberArray.length - i - 1) != 1 && (numberArray.length - i - 1) != 2) {
                if ((numberArray.length - i - 1)%2 == 1) {
                    if (i-1>=0 && numberArray[i -1] - '0' == 1)
                        continue;
                    else {
                        if(getOnesNames(numberArray[i] - '0') != null)
                            numberNames.append(getOnesNames(numberArray[i] - '0'));
                    }
                } else{
                    if(digit ==1) {
                        if(getTeensNames(numberArray[i + 1] - '0') != null)
                            numberNames.append(getTeensNames(numberArray[i + 1] - '0'));
                    }
                    else {
                        if(getOnesNames(numberArray[i] - '0') != null)
                            numberNames.append(getOnesNames(numberArray[i] - '0'));
                    }
                }
            } else if ((numberArray.length - i - 1) == 2) {
                if(getOnesNames(numberArray[i] - '0') != null)
                    numberNames.append(getOnesNames(numberArray[i] - '0'));
            }
             else if ((numberArray.length - i - 1) == 1) {
                if (digit == 1) {
                    if(getTeensNames(numberArray[i + 1] - '0') != null)
                        numberNames.append(getTeensNames(numberArray[i + 1] - '0'));
                }
                else {
                    if(getTensNames(numberArray[i] - '0') != null)
                        numberNames.append(getTensNames(numberArray[i] - '0'));
                }
            } else if ((numberArray.length - i - 1) == 0) {
                if (numberArray[i - 1] - '0' != 1) {
                    if(getOnesNames(numberArray[i] - '0') != null)
                        numberNames.append(getOnesNames(numberArray[i] - '0'));
                }
            }
             if(getMetricNames(i) != null)
                 numberNames.append(getMetricNames(i));
        }
        return String.valueOf(numberNames);
    }

    public String getMetricNames(int index) {
        switch (index) {
            case 2:
                return "Hundred";
            case 3:
                return "Thousand";
            case 4:
                return null;
            case 5:
                return "Lakh";
            case 6:
                return null;
            case 7:
                return "Crore";
            default:
                return null;
        }
    }

    public String getTensNames(int value) {
        switch (value) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return null;
        }
    }

    public String getOnesNames(int value) {
        switch (value) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            default:
                return null;
        }
    }

    public String getTeensNames(int value) {
        switch (value) {
            case 1:
                return "Eleven";
            case 2:
                return "Twelve";
            case 3:
                return "Thirteen";
            case 4:
                return "Fourteen";
            case 5:
                return "Fifteen";
            case 6:
                return "Sixteen";
            case 7:
                return "Seventeen";
            case 8:
                return "Eighteen";
            case 9:
                return "Nineteen";
            default:
                return null;
        }
    }
}
