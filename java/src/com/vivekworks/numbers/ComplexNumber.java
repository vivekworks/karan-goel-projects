/**
 * Purpose - Show addition, multiplication, negation, and inversion of complex numbers in separate functions. (Subtraction and division operations can be made with pairs of these operations.) Prdouble the results for each operation tested.
 * Author  - Vivek T S
 * Date    - 04/12/2018
 */
package com.vivekworks.numbers;

import java.util.Scanner;

public class ComplexNumber {
    public void begin() {
        System.out.println("Enter the complex numbers in a+bi format");
        Scanner input = new Scanner(System.in);
        System.out.print("Complex Number 1 : -->");
        String complexNo1 = input.nextLine();
        System.out.print("Complex Number 2 : -->");
        String complexNo2 = input.nextLine();
        splitInputs(complexNo1.trim(), complexNo2.trim());
    }

    public void splitInputs(String complexNo1, String complexNo2) {
        double[] complexArray1 = segregate(complexNo1,"+");
        if(complexArray1 == null)
            complexArray1 = segregate(complexNo1,"-");
        double[] complexArray2 = segregate(complexNo2,"+");
        if(complexArray2 == null)
            complexArray2 = segregate(complexNo2,"-");
        System.out.println("Addition : "+getComplexNumberForm(add(complexArray1[0],complexArray1[1],complexArray2[0],complexArray2[1])));
        System.out.println("Subtraction : "+getComplexNumberForm(subtract(complexArray1[0],complexArray1[1],complexArray2[0],complexArray2[1])));
        System.out.println("Multiplication : "+getComplexNumberForm(multiply(complexArray1[0],complexArray1[1],complexArray2[0],complexArray2[1])));
        System.out.println("Division : "+getComplexNumberForm(divide(complexArray1[0],complexArray1[1],complexArray2[0],complexArray2[1])));
        System.out.println(complexNo1+" Inversion : "+getComplexNumberForm(invert(1.0,0.0,complexArray1[0],complexArray1[1])));
        System.out.println(complexNo2+" Inversion : "+getComplexNumberForm(invert(1.0,0.0,complexArray2[0],complexArray2[1])));
    }

    public double[] segregate(String complexNo, String operation) {
        double[] complexArray = new double[2];
        if (complexNo.contains(operation) & complexNo.indexOf(operation) >= 1){
            complexArray[0]= Double.parseDouble(complexNo.substring(0, complexNo.indexOf(operation)));
            complexArray[1]= Double.parseDouble(complexNo.substring(complexNo.indexOf(operation), complexNo.length() - 1));
            return complexArray;
        }
        return null;
    }

    public double[] add(double real1, double img1, double real2, double img2) {
        double[] sum = {(real1+real2),(img1+img2)};
        return sum;
    }

    public double[] subtract(double real1, double img1, double real2, double img2) {
        double[] diff = {(real1-real2),(img1-img2)};
        return diff;
    }

    public double[] multiply(double real1, double img1, double real2, double img2) {
        double[] product={((real1*real2)+(-(img1*img2))),(real1*img2)+(real2*img1)};
        return product;
    }

    public double[] divide(double real1, double img1, double real2, double img2) {
        double[] numer = multiply(real1, img1, real2, -img2);
        double denom = Math.pow(real2,2)+Math.pow(img2,2);
        double[] div = {(numer[0]/denom),(numer[1]/denom)};
        return div;
    }

    public double[] invert(double real1, double img1, double real2, double img2) {
        return divide(real1, img1, real2, img2);
    }

    public String getComplexNumberForm(double[] complexNoArray){
        StringBuilder complexFormBuilder = new StringBuilder();
        if(complexNoArray[0] != 0.0)
            complexFormBuilder.append(complexNoArray[0]);
        if(complexNoArray[1] != 0.0){
            if(complexNoArray[1] > 0.0 && complexNoArray[0] != 0.0)
                complexFormBuilder.append("+");
            complexFormBuilder.append(complexNoArray[1]+"i");
        }
        return String.valueOf(complexFormBuilder);
    }
}
