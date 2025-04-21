package com.example.UnitConverter.Controller;

import com.example.UnitConverter.ServiceLayer.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class UnitController {

    private final ConversionService conversionService;

    @Autowired
    public UnitController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/convert")
    public String showConverter(@RequestParam(value = "tab", required = false, defaultValue = "length") String tab,
                                Model model) {
        List<String> lengthUnits = Arrays.asList("meter", "kilometer", "inch", "foot", "yard", "mile");
        List<String> weightUnits = Arrays.asList("gram", "kilogram", "pound", "ounce");
        List<String> temperatureUnits = Arrays.asList("celsius", "fahrenheit", "kelvin");

        model.addAttribute("lengthUnits", lengthUnits);
        model.addAttribute("weightUnits", weightUnits);
        model.addAttribute("temperatureUnits", temperatureUnits);
        model.addAttribute("selectedTab", tab);
        return "index"; // name of the Thymeleaf file: index.html
    }

    @PostMapping("/convert")
    public String getValues(
            @RequestParam String category,
            @RequestParam String fromUnit,
            @RequestParam String toUnit,
            @RequestParam double value,
            Model model
    ) {
        double result = conversionService.convert(category, fromUnit, toUnit, value);
        model.addAttribute("result", result);
        model.addAttribute("selectedTab", category);
        model.addAttribute("selectedFromUnit", fromUnit);  // Keep selected 'From' unit
        model.addAttribute("selectedToUnit", toUnit);      // Keep selected 'To' unit
        model.addAttribute("inputValue", value);           // Keep entered value
        return "index";
    }
}
