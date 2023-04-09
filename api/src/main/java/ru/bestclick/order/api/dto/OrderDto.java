package ru.bestclick.order.api.dto;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JavaBiteCode
 * @version 1
 */

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

  private UUID id;
  @NotBlank
  private String title;
  @NotBlank
  private String description;
  private BigDecimal price;
  private int quantity;
  private int quota;
  private TradingPlace tradingPlace;
  private UUID fullUserId;
  private UUID categoryId;
  private UUID galleryId;
  private OffsetDateTime createDate;
  private OffsetDateTime updateDate;
}