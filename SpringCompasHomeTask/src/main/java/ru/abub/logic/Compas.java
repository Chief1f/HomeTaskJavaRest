package ru.abub.logic;

import java.util.HashMap;
import java.util.Map;

public class Compas {

    public static final Compas instance = new Compas();
    private Map<String,String> sidesAndLimits;

    public Map<String, String> getSidesAndLimits() {
        return sidesAndLimits;
    }


    public void setsidesAndLimits(Map<String, String> sidesAndLimits) {
        this.sidesAndLimits = sidesAndLimits;
    }

    public static Compas getInstance(){
        return instance;
    }

    public String search(int degree){
        String result = "Abub";
        for (Map.Entry<String, String> entry : sidesAndLimits.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String[] degrees = value.split("-");

            if (degree > Integer.parseInt (degrees[0]) & degree < Integer.parseInt (degrees[1])){
                result = key;
            }
        }

   return result;
    }




}
