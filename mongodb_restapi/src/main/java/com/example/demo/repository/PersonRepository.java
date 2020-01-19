/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Person;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String>{
    public Person getByFirstName(String firstName);
    public List<Person>findByAge(int age);
}
