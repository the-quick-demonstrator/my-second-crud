package com.github.curriculeon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// this class speaks to the database
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
