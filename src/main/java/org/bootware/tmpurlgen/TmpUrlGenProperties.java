package org.bootware.tmpurlgen;

import java.time.format.DateTimeFormatter;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("org.bootware.tmpurlgen")
@Data
public class TmpUrlGenProperties {

  private String dateTimeFormat = "yyyyMMddHHmmss";

  @Getter(lazy = true)
  private final DateTimeFormatter dateTimeFormatter =
      DateTimeFormatter.ofPattern(dateTimeFormat);
}
