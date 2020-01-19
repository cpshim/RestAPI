/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chris
 */
@RequestMapping("/people")
@RestController
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @PostMapping("/create")
    public String create(@RequestBody Person person){
        Person p = personService.create(person);
        return p.toString();
    }
        
    @GetMapping(value = "/{id}")
    public Optional<Person> getPerson(@PathVariable("id") String id){
        return personService.getById(id);
    }
    
    @GetMapping("/")
    public List<Person> getAll(){
        return personService.getAll();
    }
    
    @PutMapping(value = "/{id}")
    public String update(@PathVariable("id") String id, @RequestBody Person person){
        Person p = personService.updateById(id, person);
        return p.toString();
    }
    
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") String id){
        personService.deleteById(id);
        return ("Deleted");
    }
}
