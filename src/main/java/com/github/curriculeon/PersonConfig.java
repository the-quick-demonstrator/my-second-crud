package com.github.curriculeon;

import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PersonConfig {
    @Autowired
    private PersonRepository personRepository;

    public PersonConfig() {
    }

    @PostConstruct
    public void setup() {
        Person leon = new Person();
        leon.setFirstName("Leon");
        leon.setLastName("Hunter");
        personRepository.save(new Person());
        personRepository.save(leon);
    }
}
