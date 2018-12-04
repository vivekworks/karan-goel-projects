/**
 * Purpose - Calculates the distance between two cities and allows the user to specify a unit of distance. This program may require finding coordinates for the cities like latitude and longitude.
 * Author  - Vivek T S
 * Date    - 04/12/2018
 * Formula - Haversine Formula
 */
package com.vivekworks.numbers;

import java.util.HashMap;
import java.util.Scanner;


enum Cities {
    ADELAIDE("34.9166666666667,138.6"),
    AMSTERDAM("52.3666666666667,4.88333333333333"),
    BARCELONA("41.3833333333333,2.15"),
    BERLIN("52.5,13.4166666666667"),
    BIRMINGHAM("52.4166666666667,1.91666666666667"),
    BOMBAY("19,72.8"),
    BUDAPEST("47.5,19.0833333333333"),
    CALCUTTA("22.5666666666667,88.4"),
    DUBLIN("53.3333333333333,6.25"),
    DURBAN("29.8833333333333,30.8833333333333"),
    EDINBURGH("55.9166666666667,3.16666666666667"),
    FRANKFURT("50.1166666666667,8.68333333333333"),
    HONG_KONG("22.3333333333333,114.183333333333"),
    KUALA_LUMPUR("3.13333333333333,101.7"),
    LIVERPOOL("53.4166666666667,3"),
    LONDON("51.5333333333333,0.0833333333333333"),
    MADRID("40.4333333333333,3.7"),
    MANCHESTER("53.5,2.25"),
    MECCA("21.4833333333333,39.75"),
    MELBOURNE("37.7833333333333,144.966666666667"),
    MILAN("45.45,9.16666666666667"),
    MOSCOW("55.75,37.6"),
    MUNICH("48.1333333333333,11.5833333333333"),
    NAGASAKI("32.8,129.95"),
    NEW_DELHI("28.5833333333333,77.2"),
    PARIS("48.8,2.33333333333333"),
    ROME("41.9,12.45"),
    SINGAPORE("1.23333333333333,103.916666666667"),
    SYDNEY("34,151"),
    TOKYO("35.6666666666667,139.75");
    private String coordinates;

    public String getCoordinates() {
        return this.coordinates;
    }

    Cities(String coordinates) {
        this.coordinates = coordinates;
    }
}

public class DistanceBetweenCities {
    public String begin() {
        HashMap<Integer, Cities> cityMap = getMap();
        for (int i = 1; i <= cityMap.size(); i++) {
            System.out.println(i+". "+cityMap.get(i));
        }
        System.out.println("Choose two cities to find the distance between them");
        System.out.print("Enter the serial no. for city 1 --> ");
        Scanner inputScanner = new Scanner(System.in);
        int city1 = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.print("Enter the serial no. for city 2 --> ");
        int city2 = inputScanner.nextInt();
        inputScanner.nextLine();
        String[] city1cor = cityMap.get(city1).getCoordinates().split(",");
        String[] city2cor = cityMap.get(city2).getCoordinates().split(",");
        System.out.print("Distance between "+cityMap.get(city1)+" and "+cityMap.get(city2)+" --> ");
        return calculateDistance(Double.parseDouble(city1cor[0]),Double.parseDouble(city1cor[1]),Double.parseDouble(city2cor[0]),Double.parseDouble(city2cor[1]));
    }

    public String calculateDistance(double lat1, double long1, double lat2, double long2) {
        double EARTH_RADIUS = 6371.0;
        /**
         * Haversine formula:
         * a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
         * c = 2 ⋅ atan2( √a, √(1−a) )
         * d = R ⋅ c
         * where φ is latitude
         *       λ is longitude
         *       R is earth’s radius (mean radius = 6,371km)
         * note that angles need to be in radians to pass to trig functions!
         */
        double latitude = StrictMath.toRadians((lat2 - lat1));
        double longitude = StrictMath.toRadians((long2 - long1));
        double a = StrictMath.pow(StrictMath.sin(latitude/2), 2) + (StrictMath.cos(StrictMath.toRadians(lat1)) * StrictMath.cos(StrictMath.toRadians(lat2)) * StrictMath.pow(StrictMath.sin(longitude/2), 2));
        double c = 2 * StrictMath.atan2(StrictMath.sqrt(a), StrictMath.sqrt((1 - a)));
        return Math.round(EARTH_RADIUS * c)+" Km";
    }

    public HashMap<Integer, Cities> getMap() {
        HashMap<Integer, Cities> cityMap = new HashMap<>();
        //Cities[] cityArray = Cities.values();
        int count = 1;
        for (Cities city : Cities.values()) {
            cityMap.put(count, city);
            count++;
        }
        return cityMap;
    }
}
