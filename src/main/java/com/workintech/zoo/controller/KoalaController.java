package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.Validation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas/")
public class KoalaController {
    private Map<Integer, Koala> koalas;
    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
    }

    @GetMapping("/")
    public List<Koala> get(){
        return koalas.values().stream().toList();
    }

    @GetMapping("{id}")
    public Koala get(@PathVariable int id){
        Validation.isIdValid(id);
        Validation.isIdNotExist(koalas,id);
        return koalas.get(id);
    }

    @PostMapping("/")
    public Koala save(@RequestBody Koala koala) {

        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala){

        koalas.put(id,koala);
        return koalas.get(id);
    }

    @DeleteMapping("{id}")
    public Koala delete(@PathVariable int id){

        koalas.remove(id);
        return koalas.get(id);
    }
}
