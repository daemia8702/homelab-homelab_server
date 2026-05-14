package com.daemia.homelab_server.service;

import com.daemia.homelab_server.dto.PersonDTO;
import com.daemia.homelab_server.mapper.PersonMapper;
import com.daemia.homelab_server.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toPersonDTO)
                .toList();
    }

    @Transactional
    public Long savePerson(PersonDTO personDTO) {
        return personRepository.save(personMapper.toPerson(personDTO)).getId();
    }
}
