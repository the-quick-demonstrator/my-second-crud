package com.github.curriculeon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person readById(Long id) {
        return personRepository.findById(id).get();
    }

    public List<Person> readAll() {
        List<Person> result = new ArrayList<>();
        for(Person person : personRepository.findAll()) {
            result.add(person);
        }
        return result;
    }

    public Person update(Long id, Person newData) {
        Person personInDatabase = readById(id);
        personInDatabase.setFirstName(newData.getFirstName());
        personInDatabase.setLastName(newData.getLastName());
        personInDatabase.setAge(newData.getAge());
        return personRepository.save(personInDatabase);
    }

    public Person delete(Long id) {
        Person deletedPerson = readById(id);
        personRepository.deleteById(id);
        return deletedPerson;
    }
}
