package br.com.ldf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ldf.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
