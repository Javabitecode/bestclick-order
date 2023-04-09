package ru.bestclick.order.impl.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jooq.JSONB;

/**
 * Класс Order(ru."Объявдление") это сущность, сохраняемая в базу данных и имеющая поля:
 * <ul>
 * <li>id - идентификатор
 * <li>title - название
 * <li>description - описание
 * <li>price - цена
 * <li>quantity - количество доступных едениц
 * <li>quota - количество дней размещения
 * <li>tradingPlace - место совершения сделки
 * <li>fullUserId - идентификатор пользователя создавшего Order
 * <li>categoryId - идентификатор категории Order
 * <li>galleryId - идентификатор фото и видео прикрепленного к данному Order
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
public class Order {

  private UUID id;
  private String title;
  private String description;
  private BigDecimal price;
  private int quantity;
  private int quota;
  private JSONB tradingPlace;
  private UUID fullUserId;
  private UUID categoryId;
  private UUID galleryId;
  private OffsetDateTime createDate;
  private OffsetDateTime updateDate;
}
