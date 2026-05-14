package com.daemia.homelab_server.mapper;

import com.daemia.homelab_server.dto.PersonDTO;
import com.daemia.homelab_server.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PersonMapper {

    PersonDTO toPersonDTO(Person person);

    @Mapping(target = "id", ignore = true)
    Person toPerson(PersonDTO personDTO);
}
