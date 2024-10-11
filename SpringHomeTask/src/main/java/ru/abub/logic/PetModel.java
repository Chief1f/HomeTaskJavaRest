package ru.abub.logic;

import java.util.HashMap;
import java.util.Map;

public class PetModel {

    public static final PetModel instance = new PetModel();
    private final Map<Integer,Pet> model;

    public PetModel(){
        model = new HashMap<Integer, Pet>();
        model.put(1,new Pet("a","a",1));
        model.put(2,new Pet("b","b",2));
        model.put(3,new Pet("c","c",3));
    }

    public static PetModel getInstance(){
        return instance;
    }

    public void add(Pet pet, int id){
        model.put(id,pet);
    }
    public Pet getFromList(int id){
        return model.get(id);
    }


    public Map<Integer,Pet> getAll() {
        return model;
    }

    public void delete(int id){
        model.remove(id);
    }
    public void update(Pet pet, int id){

        model.put(id,pet);
    }

}
