/**
 * Purpose - Total cost of tile it would take to cover a floor plan of width and height, using a cost entered by the user.
 * Author  - Vivek T S
 * Date    - 25/11/2018
 */
package com.vivekworks.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CostOfTile {
    public BigDecimal getCost(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the 4 specs : Width & Height of floor, Area and Cost of each Tile with commas separating them --> ");
        try {
            String[] floorSpec = reader.readLine().split(",");
            if(floorSpec.length == 4)
                return computeCost(floorSpec);
            else{
                System.out.print("Enter the 4 specs correctly!");
                getCost();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }

    public BigDecimal computeCost(String[] floorSpec){
        BigDecimal cost = null;
        BigDecimal floorArea = new BigDecimal(floorSpec[0]).multiply(new BigDecimal(floorSpec[1]));
        BigDecimal noOfTiles = floorArea.divide(new BigDecimal(floorSpec[2]), RoundingMode.DOWN);
        cost = noOfTiles.multiply(new BigDecimal(floorSpec[3]));
        return cost;
    }
}
