package ru.bestclick.order.impl.helper;

import java.time.Clock;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//TODO Перенести в общую либу
@Component
@RequiredArgsConstructor
public class ClockHelper {

  private final Clock clock;

  public OffsetDateTime now() {
    return OffsetDateTime.now(clock);
  }
}
