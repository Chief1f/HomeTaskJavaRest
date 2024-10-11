package ru.abub.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.abub.logic.Compas;

import java.util.Collections;
import java.util.Map;

@RestController
public class Controller {
    private static final Compas compas = Compas.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @PostMapping(value = "/createRange",consumes = "application/json")
    public Map<String, String> createRange(@RequestBody Map<String, String> input){
        compas.setsidesAndLimits(input);
     return input;

    }

    @GetMapping(value = "/search",consumes = "application/json",produces = "application/json")
    public Map<String, String> getResult(@RequestBody Map<String,Integer> id){
        String result = compas.search(id.get("Degree"));

        return Collections.singletonMap("Side", result);
    }


}
