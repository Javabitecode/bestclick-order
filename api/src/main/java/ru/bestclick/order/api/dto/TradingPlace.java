package ru.bestclick.order.api.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс TradingPlace(ru."Место совершения сделки") это сущность, сохраняемая в базу данных и
 * имеющая поля:
 * <ul>
 * <li>id - идентификатор
 * <li>geometry - географическое местоположение сделки
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
public class TradingPlace {

  private UUID id;
  private Geometry geometry;
}