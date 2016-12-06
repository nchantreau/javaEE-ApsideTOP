package fr.apside.formation.ws.bean.converter;

/**
 *
 * @param <E> entité
 * @param <D> DTO
 * @author François Robert
 */
public interface EntityDTOConverter<E, D> {

  /**
   * Converti l'entité en DTo
   * @param entity entité
   * @return representation DTO
   */
  D toDTO(E entity);

  /**
   * Converti le DTO en entity
   * @param dto dot
   * @return entité
   */
  E toEntity(D dto);

}
