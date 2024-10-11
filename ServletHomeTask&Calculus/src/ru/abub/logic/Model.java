package ru.abub.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private static final Model instance = new Model();
    private final Map<Integer, User> model;

    public static Model getInstance(){
        return instance;
    }

    private Model(){
        model = new HashMap<>();
        model.put(1,new User("Nick","Petrov",104.3));
        model.put(2,new User("Ivan","Ivanov",23.6));
        model.put(3,new User("Jack","EastWood",34.6));
    }

    public void add(User user, int id){
        model.put(id,user);
    }

    public void delete(int id){
        model.remove(id);
    }

    public void update(int id,String name, String surname, double salary){
        User user = new User(name,surname,salary);
        model.put(id,user);
    }

    public Map<Integer, User> getFromList(){
        return model;
    }

    public User get(int id) {
        return model.get(id);
    }
}
