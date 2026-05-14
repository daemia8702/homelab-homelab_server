package com.daemia.homelab_server.repository;

import com.daemia.homelab_server.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
