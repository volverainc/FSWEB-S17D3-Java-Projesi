package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.Validation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.awt.event.AdjustmentEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos/")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;
    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
    }

    @GetMapping("/")
    public List<Kangaroo> get(){
        return kangaroos.values().stream().toList();
    }

    @GetMapping("{id}")
    public Kangaroo get(@PathVariable int id){
        Validation.isIdValid(id);
        Validation.isIdNotExist(kangaroos, id);
        return kangaroos.get(id);
    }

    @PostMapping("/")
    public Kangaroo save(@RequestBody Kangaroo kangaroo) {

        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("{id}")
    public Kangaroo update(@PathVariable int id, @RequestBody Kangaroo kangaroo){

        kangaroo.setId(id);
        kangaroos.put(id,kangaroo);
        return kangaroo;
    }

    @DeleteMapping("{id}")
    public Kangaroo delete(@PathVariable int id){

        kangaroos.remove(id);
        return kangaroos.get(id);
    }
}
