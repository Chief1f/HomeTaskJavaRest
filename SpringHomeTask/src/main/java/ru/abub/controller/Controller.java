package ru.abub.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;
import ru.abub.logic.Pet;
import ru.abub.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet",consumes = "application/json")
    public String createPet(@RequestBody Pet pet){
    petModel.add(pet, newId.getAndIncrement());
    return "Питомец успешно заведен";
    }

    @GetMapping(value = "/getAll",produces = "application/json")
    public Map<Integer,Pet> getAll(){
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet",consumes = "application/json",produces = "application/json")
    public Pet getPet(@RequestBody Map<String,Integer> id){
    return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet",consumes = "application/json",produces = "application/json")
    public Map<Integer,Pet> deletePet(@RequestBody Map<String,Integer> id){
        petModel.delete(id.get("id"));
        return petModel.getAll();
    }

    @PutMapping(value = "/updatePet{id:\\d+}",consumes = "application/json",produces = "application/json")
        public Map<Integer,Pet> updatePet(@RequestBody Pet pet,@PathVariable int id){
            petModel.update(pet,id);
            return petModel.getAll();
        }

}
