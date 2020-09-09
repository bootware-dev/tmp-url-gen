package org.bootware.tmpurlgen;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TmpUrlGeneratorTest {

  @Autowired
  TmpUrlGenerator tmpURLGenerator;

  @Test
  public void generateUrl() throws MalformedURLException {

    String secret = "secret string";

    LocalDateTime limitDateTime = LocalDateTime.now().plusDays(1);

    Path protectedPath = Path.of("vod");

    Path filePath = Path.of("file/data.mp4");

    String url = tmpURLGenerator.generateUrl(secret, protectedPath, filePath, limitDateTime);

    log.info("uri={}", url);
  }
}