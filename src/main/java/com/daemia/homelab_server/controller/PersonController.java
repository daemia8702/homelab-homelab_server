package com.daemia.homelab_server.controller;

import com.daemia.homelab_server.dto.PersonDTO;
import com.daemia.homelab_server.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/list")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PostMapping("/save")
    public ResponseEntity<Long> savePerson(@RequestBody PersonDTO person) {
        return ResponseEntity.ok(personService.savePerson(person));
    }
}
