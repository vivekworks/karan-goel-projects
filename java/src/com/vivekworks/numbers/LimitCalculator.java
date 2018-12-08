/**
 * Purpose - User to enter f(x) and the limit value, then return the value of the limit statement
 * Author  - Vivek T S
 * Date    - 07/12/2018
 */
package com.vivekworks.numbers;

import java.util.ArrayList;
import java.util.Scanner;

public class LimitCalculator {
    public double begin() {
        System.out.println("Use ^ for the 'to the power of' relation. Enter x as the variable and not others");
        System.out.print("Enter the equation in   : f(x)        --> ");
        Scanner input = new Scanner(System.in);
        String equation = input.nextLine().toLowerCase();
        System.out.print("Enter an integer limit  : lim x ->    --> ");
        int limit = input.nextInt();
        return calculate(equation, limit);
    }

    public double calculate(String equation, int limit) {
        ArrayList<String> subEquationList = new ArrayList<>();
        String[] subEquationArray = equation.split("\\+");
        for(int i=0;i<subEquationArray.length;i++){
            segregate(subEquationList,"\\+",subEquationArray[i].trim());
        }
        for(int i=0;i<subEquationList.size();i++){
            String val = subEquationList.get(0);
            subEquationList.remove(val);
            segregate(subEquationList,"-",val);
        }
        double sum=0;
        for(String row :subEquationList){
            sum = sum+processSubEquations(row,limit);
        }
        return sum;
    }

    public double processSubEquations(String subEquation,int limit){
        double n1=0,n2=0;
        if(subEquation.indexOf('x') > 0){
            if(subEquation.indexOf('^') > 0){
                n1 = Math.pow(limit,Double.parseDouble(subEquation.substring(subEquation.indexOf('^')+1)));
            } else{
                n1 = limit;
            }
            n2 = n1 * Double.parseDouble(subEquation.substring(0,subEquation.indexOf('x')));
        } else{
            n2 = Double.parseDouble(subEquation);
        }
        return n2;
    }

    public void segregate(ArrayList<String> subEquationList, String operation, String subEquation){
        boolean signFlag = subEquation.substring(0,1).trim().equalsIgnoreCase("-");
        String[] subEquationArray = subEquation.split(operation);
        for(int i=0;i<subEquationArray.length;i++){
            String val = subEquationArray[i].trim();
            if(val != null && !(val.equals(""))) {
                subEquationList.add( i==1 && signFlag ? "-"+val:(operation.equals("-") && (i!=0) ? "-"+val: val));
            }
        }
    }
}