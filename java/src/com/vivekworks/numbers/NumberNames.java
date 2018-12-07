/**
 * Purpose - Show how to spell out a number in English. You can use a preexisting implementation or roll your own, but you should support inputs up to at least one million (or the maximum value of your language's default bounded integer type, if that's less). Optional: Support for inputs other than positive integers (like zero, negative integers, and floating-point numbers).
 * Author  - Vivek T S
 * Date    - 05/12/2018
 * System  - Indian System
 * 1. Ones
 * 2. Tens
 * 3. Hundreds
 * 4. Thousands
 * 5. Ten Thousands
 * 6. Lakhs
 * 7. Ten Lakhs
 * 8. Crores
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class NumberNames {
    public String begin() {
        System.out.print("Enter an integer (upto 11 digits) --> ");
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();
        if (number > 99999999999L)
            return "The number should not be more than 11 digits!!!";
        return getNumberNames(number);
    }

    public String getNumberNames(long number) {
        if(number == 0) return "Zero";
        StringBuilder numberNames = new StringBuilder();
        char[] numberArray = String.valueOf(Math.abs(number)).toCharArray();
        for (int i = 0; i < numberArray.length; i++) {
            int digit = numberArray[i] != '\0' ? numberArray[i] - '0' : numberArray[i];
            int digitPosition = numberArray.length - (i + 1);
            if (digitPosition > 2 ? (digitPosition % 2 == 0) : (digitPosition % 2 == 1)) {
                if (digitPosition % 7 == 1 && numberNames.length() != 0 && (digit != 0 || (numberArray[i + 1] - '0' != 0))) {
                    numberNames.append("and ");
                }
                if (digit == 1) {
                    numberNames.append(getWords('E', numberArray[i + 1] - '0'));
                    numberArray[i + 1] = '\0';
                } else {
                    if (digitPosition != 2 && digitPosition != 10) {
                        numberNames.append(getWords('T', digit));
                    } else {
                        numberNames.append(getWords('O', digit));
                    }
                }
            } else {
                if (digit != '\0') {
                    if (digit == 1 && digitPosition != 0) {
                        if (digitPosition == 2 || digitPosition == 10) {
                            numberNames.append(getWords('O', numberArray[i] - '0'));
                        } else {
                            if (digitPosition > 2 ? (digitPosition % 2 == 1) : (digitPosition % 2 == 0))
                                numberNames.append(getWords('O', digit));
                            else
                                numberNames.append(getWords('E', numberArray[i + 1] - '0'));
                        }
                    } else {
                        numberNames.append(getWords('O', digit));
                    }
                }
            }

            if (getMetricNames(digitPosition) != "" && ((digitPosition == 2 && digit != 0) || (digitPosition != 2)) && ((digitPosition == 10 && digit != 0) || (digitPosition != 10))) {
                numberNames.append(getWords('M', digitPosition));
            }
        }
        return number > 0 ? String.valueOf(numberNames).trim() : "Negative "+String.valueOf(numberNames).trim();
    }

    public String getWords(char type, int value) {
        String word = "";
        switch (type) {
            case 'E':
                word = getTeensNames(value);
                break;
            case 'T':
                word = getTensNames(value);
                break;
            case 'O':
                word = getOnesNames(value);
                break;
            case 'M':
                word = getMetricNames(value);
                break;
        }
        if (word != null && !word.equals("")) {
            word += " ";
        }
        return word;
    }

    public String getMetricNames(int index) {
        if (index > 0) {
            switch (index % 7) {
                case 1:
                    return "";
                case 2:
                    return "Hundred";
                case 3:
                    return "Thousand";
                case 4:
                    return "";
                case 5:
                    return "Lakh";
                case 6:
                    return "";
                case 0:
                    return "Crore";
                default:
                    return "";
            }
        }
        return "";
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
                return "";
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
                return "";
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
            case 0:
                return "Ten";
            default:
                return "";
        }
    }
}
