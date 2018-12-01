/**
 * Purpose - (temp, currency, volume, mass and more) - Convert various units between one another. The user enters the type of unit being entered, the type of unit they want to convert to and then the value. The program will then make the conversion.
 * Author  - Vivek T S
 * Date    - 29/11/2018
 */
package com.vivekworks.numbers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class UnitConverter {

    Scanner inputScanner = new Scanner(System.in);

    public double runConverter() {
        System.out.println("----Converters----");
        System.out.println("1. Temperature");
        System.out.println("2. Currency");
        System.out.println("3. Mass");
        System.out.println("4. Volume");
        System.out.print("Choose an option --> ");
        int option = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.println("");
        switch (option) {
            case 1:
                return convertTemperature();
            case 2:
                return convertCurrency();
            case 3:
                return convertMass();
            case 4:
                return convertVolume();
            default:
                System.out.println("Wrong option");
        }
        return 0.0;
    }

    public double convertTemperature() {
        return new TemperatureConverter().convert();
    }

    public double convertCurrency() {
        return new CurrencyConverter().convert();
    }

    public double convertMass() {
        return new MassConverter().convert();
    }

    public double convertVolume() {
        return new VolumeConverter().convert();
    }

    public class TemperatureConverter {
        String fromTemp, toTemp;
        double temperature;

        public double convert() {
            getData();
            if (fromTemp != null && toTemp != null)
                return convertTemperatures();
            return 0.0;
        }

        public void getData() {
            System.out.println("----Temperature & Notations----");
            System.out.println("1. Celsius        - C");
            System.out.println("2. Fahrenheit     - F");
            System.out.println("3. Kelvin         - K");
            System.out.println("");
            System.out.print("Choose a Temperature Notation from above to convert      --> ");
            fromTemp = inputScanner.nextLine().toUpperCase().trim();
            if (fromTemp != null && !(fromTemp.matches("C|F|K"))) {
                System.out.println("Wrong Temperature Notation!");
                return;
            }
            System.out.print("Choose a Temperature Notation from above to be converted --> ");
            toTemp = inputScanner.nextLine().toUpperCase().trim();
            if (toTemp != null && !(toTemp.matches("C|F|K")) && !(toTemp.equals(fromTemp))) {
                System.out.println("Wrong Temperature Notation!");
                return;
            }
            System.out.print("Enter the temperature to be converted                    --> ");
            temperature = inputScanner.nextDouble();
        }

        public double convertTemperatures() {
            double result = fromTemp.equals("C") ? temperature : (fromTemp.equals("K") ? temperature - 273.15 : (temperature - 32) / (1.8));
            System.out.print(temperature + fromTemp + " in " + toTemp + " --> ");
            return new BigDecimal(toTemp.equals("C") ? result : (toTemp.equals("K") ? result + 273.15 : (result * 1.8) + 32)).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        }
    }

    public class CurrencyConverter {
        String fromCurrency, toCurrency, amount;
        URL url;

        public double convert() {
            displayList();
            getData();
            String jsonStr = null;
            if (fromCurrency != null && toCurrency != null) {
                try {
                    url = new URL(getURL());
                    //System.out.println(url);
                } catch (MalformedURLException mue) {
                    mue.printStackTrace();
                }
            }
            if (url != null)
                jsonStr = callAPI();
            if (jsonStr != null)
                return parseJSON(jsonStr);
            return 0.0;
        }

        public void displayList() {
            System.out.println("----Currencies & abbreviations----");
            System.out.println("1. Indian Rupee             - INR");
            System.out.println("2. United States Dollar     - USD");
            System.out.println("3. British Pound Sterling   - GBP");
            System.out.println("4. Bitcoin                  - BTC");
            System.out.println("5. Euro                     - EUR");
            System.out.println("");
        }

        public void getData() {
            System.out.print("Choose a currency abbreviation from above to convert      --> ");
            fromCurrency = inputScanner.nextLine().toUpperCase().trim();
            if (fromCurrency != null && !(fromCurrency.matches("INR|USD|GBP|BTC|EUR"))) {
                System.out.println("Wrong currency abbreviation!");
                return;
            }
            System.out.print("Choose a currency abbreviation from above to be converted --> ");
            toCurrency = inputScanner.nextLine().toUpperCase().trim();
            if (toCurrency != null && !(toCurrency.matches("INR|USD|GBP|BTC|EUR"))) {
                System.out.println("Wrong currency abbreviation!");
                return;
            }
            System.out.print("Enter the amount to be converted                          --> ");
            amount = inputScanner.nextLine().trim();
        }

        public String getURL() {
            return "http://apilayer.net/api/live?access_key=987aed9c8600798f197c45f76f5286c0&currencies=" + fromCurrency + "," + toCurrency;
        }

        public String callAPI() {
            String response = "";
            try {
                URLConnection urlConn = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                String line = "";
                StringBuilder outputBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null)
                    outputBuilder.append(line.trim());
                response = String.valueOf(outputBuilder);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return response;
        }

        public double parseJSON(String jsonStr) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                boolean success = jsonObject.getBoolean("success");
                if (success) {
                    JSONObject quotes = jsonObject.getJSONObject("quotes");
                    double fromConverted = quotes.getDouble("USD" + fromCurrency);
                    double toConverted = quotes.getDouble("USD" + toCurrency);
                    double result = ((toConverted / fromConverted) * Double.parseDouble(amount));
                    System.out.print(amount + " " + fromCurrency + " in " + toCurrency + " --> ");
                    return new BigDecimal(result).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
                } else
                    System.out.println(jsonObject.getJSONObject("error").getJSONObject("code") + " - " + jsonObject.getJSONObject("error").getJSONObject("info"));
            } catch (org.json.JSONException ojj) {
                ojj.printStackTrace();
            }
            return 0.0;
        }
    }

    public class MassConverter {
        String fromMass, toMass;
        double massUnit;

        public double convert() {
            getData();
            if (fromMass != null && toMass != null)
                return new BigDecimal(convertMass()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            return 0.0;
        }

        public void getData() {
            System.out.println("----Mass & Units----");
            System.out.println("1. Kilogram        - kg");
            System.out.println("2. Pound           - lb");
            System.out.println("3. Ounce           - oz");
            System.out.println("");
            System.out.print("Choose a Mass Unit from above to convert      --> ");
            fromMass = inputScanner.nextLine().toLowerCase().trim();
            if (fromMass != null && !(fromMass.matches("kg|lb|oz"))) {
                System.out.println("Wrong Mass Unit!");
                return;
            }
            System.out.print("Choose a Mass Unit from above to be converted --> ");
            toMass = inputScanner.nextLine().toLowerCase().trim();
            if (toMass != null && !(toMass.matches("kg|lb|oz")) && !(toMass.equals(fromMass))) {
                System.out.println("Wrong Mass Unit!");
                return;
            }
            System.out.print("Enter the mass to be converted                --> ");
            massUnit = inputScanner.nextDouble();
        }

        public double convertMass() {
            System.out.print(massUnit + fromMass + " in " + toMass + " --> ");
            if (fromMass.equals("kg"))
                return toMass.equals("lb") ? 2.2046226218 * massUnit : 35.27396195 * massUnit;
            else if (fromMass.equals("lb"))
                return toMass.equals("oz") ? 16 * massUnit : 0.45359237 * massUnit;
            return toMass.equals("kg") ? 0.0283495231 * massUnit : 0.0625 * massUnit;
        }
    }

    public class VolumeConverter{
        String fromVolume, toVolume;
        double volumeUnit;

        public double convert() {
            getData();
            if (fromVolume != null && toVolume != null)
                return new BigDecimal(convertVolume()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            return 0.0;
        }

        public void getData() {
            System.out.println("----Volume & Units----");
            System.out.println("1. Liter           - l");
            System.out.println("2. Gallon (US)     - gal");
            System.out.println("3. Pint   (US)     - pt");
            System.out.println("");
            System.out.print("Choose a Volume Unit from above to convert      --> ");
            fromVolume = inputScanner.nextLine().toLowerCase().trim();
            if (fromVolume != null && !(fromVolume.matches("l|gal|pt"))) {
                System.out.println("Wrong Volume Unit!");
                return;
            }
            System.out.print("Choose a Volume Unit from above to be converted --> ");
            toVolume = inputScanner.nextLine().toLowerCase().trim();
            if (toVolume != null && !(toVolume.matches("l|gal|pt")) && !(toVolume.equals(fromVolume))) {
                System.out.println("Wrong Volume Unit!");
                return;
            }
            System.out.print("Enter the Volume to be converted                --> ");
            volumeUnit = inputScanner.nextDouble();
        }

        public double convertVolume() {
            System.out.print(volumeUnit + fromVolume + " in " + toVolume + " --> ");
            if (fromVolume.equals("l"))
                return toVolume.equals("gal") ? 0.2641720524 * volumeUnit : 2.1133764189 * volumeUnit;
            else if (fromVolume.equals("gal"))
                return toVolume.equals("pt") ? 8 * volumeUnit : 3.785411784 * volumeUnit;
            return toVolume.equals("l") ? 0.473176473 * volumeUnit : 0.125 * volumeUnit;
        }
    }
}