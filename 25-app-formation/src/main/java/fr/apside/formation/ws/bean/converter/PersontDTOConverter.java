package fr.apside.formation.ws.bean.converter;

import fr.apside.formation.model.Person;
import fr.apside.formation.ws.bean.PersonDTO;

/**
 * @author François Robert
 */
public interface PersontDTOConverter extends EntityDTOConverter<Person, PersonDTO> {

  @Override
  default PersonDTO toDTO(Person entity) {
    PersonDTO personDTO = new PersonDTO();
    personDTO.setId(entity.getId());
    personDTO.setLogin(entity.getLogin());
    return personDTO;
  }

  @Override
  default Person toEntity(PersonDTO dto) {
    return new Person(dto.getLogin(), null, null);
  }
}
