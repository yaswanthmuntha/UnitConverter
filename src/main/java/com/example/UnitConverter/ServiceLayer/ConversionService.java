package com.example.UnitConverter.ServiceLayer;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConversionService {
    public static double convert(String category, String from, String to, double value) {
        switch (category) {
            case "length":
                return convertLength(from, to, value);
            case "weight":
                return convertWeight(from, to, value);
            case "temperature":
                return convertTemperature(from, to, value);
            default:
                return 0;
        }
    }

    private static double convertLength(String from, String to, double value) {
        // Example: Convert everything to meters first
        Map<String, Double> toMeter = Map.of(
                "millimeter", 0.001,
                "centimeter", 0.01,
                "meter", 1.0,
                "kilometer", 1000.0,
                "inch", 0.0254,
                "foot", 0.3048,
                "yard", 0.9144,
                "mile", 1609.34
        );
        return value * toMeter.get(from) / toMeter.get(to);
    }

    private static double convertWeight(String from, String to, double value) {
        Map<String, Double> toKg = Map.of(
                "milligram", 0.000001,
                "gram", 0.001,
                "kilogram", 1.0,
                "ounce", 0.0283495,
                "pound", 0.453592
        );
        return value * toKg.get(from) / toKg.get(to);
    }

    private static double convertTemperature(String from, String to, double value) {
        // Basic logic: Convert everything to Celsius, then to target
        double celsius;
        if (from.equals("fahrenheit")) celsius = (value - 32) * 5 / 9;
        else if (from.equals("kelvin")) celsius = value - 273.15;
        else celsius = value;

        if (to.equals("fahrenheit")) return (celsius * 9 / 5) + 32;
        if (to.equals("kelvin")) return celsius + 273.15;
        return celsius;
    }
}
