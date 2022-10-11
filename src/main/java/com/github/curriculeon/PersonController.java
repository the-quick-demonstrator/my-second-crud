package com.github.curriculeon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/person-controller")
public class PersonController {

    @Autowired
    private PersonService service;

    // POST means create data
    @PostMapping(value = "/create")
    public ResponseEntity<Person> create(@RequestBody Person personToBeCreated) {
        Person newlyCreatedPerson = service.create(personToBeCreated);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(newlyCreatedPerson, status);
    }

    // GET means fetch data
    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Person> read(@PathVariable Long id) {
        Person personInDatabase = service.readById(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(personInDatabase, status);
    }
    // GET means fetch data
    @GetMapping(value = "/read-all")
    public ResponseEntity<List<Person>> readAll() {
        List<Person> list = service.readAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(list, status);
    }

    // PUT means update data
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person newData) {
        Person updatedPerson = service.update(id, newData);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(updatedPerson, status);
    }

    // DELETE means remove data
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        Person deletedPerson = service.delete(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(deletedPerson, status);
    }
}
