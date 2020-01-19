/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    
    public Person create(Person person){
        return personRepository.save(new Person(person.getFirstName(), person.getLastName(), person.getAge()));
    }
    
    public List<Person> getAll(){
        return personRepository.findAll();
    }
 
    public Optional<Person> getById(String id){
        return personRepository.findById(id);
    }
    
    public Person updateById(String id, Person person){
        Person p = personRepository.findById(id).orElse(null);
        p.setAge(person.getAge());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        return personRepository.save(p);
    }
    
    public void deleteById(String id){
        Person p = personRepository.findById(id).orElse(null);
        personRepository.delete(p);
    }
}
