package ru.bestclick.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс Geometry это сущность, сохраняемая в базу данных и имеющая поля:
 * <ul>
 * <li>longitude - долгота
 * <li>width - широта
 * </ul>
 * <p>
 *
 * @author JavaBiteCode
 * @version 1
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Geometry {

  private String longitude;
  private String width;
}
