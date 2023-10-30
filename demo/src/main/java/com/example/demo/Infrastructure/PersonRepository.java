package com.example.demo.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Domain.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {}