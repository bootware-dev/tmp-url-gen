package org.bootware.tmpurlgen;

import java.nio.file.Path;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genurl")
public class TmpUrlGenController {

  @Autowired
  TmpUrlGenerator tmpURLGenerator;

  @Autowired
  TmpUrlGenProperties properties;

  @RequestMapping("limit")
  public String genTmpUrlLimit(
      @RequestParam("secret") String secret,
      @RequestParam("protectedPath") String protectedPath,
      @RequestParam("filePath") String filePath,
      @RequestParam("date") String limitDate) {

    return tmpURLGenerator.generateUrl(
        secret,
        Path.of(protectedPath),
        Path.of(filePath),
        LocalDateTime.parse(limitDate, properties.getDateTimeFormatter()));
  }

  @RequestMapping("seconds")
  public String genTmpUrlSeconds(
      @RequestParam("secret") String secret,
      @RequestParam("protectedPath") String protectedPath,
      @RequestParam("filePath") String filePath,
      @RequestParam("time") String timeSeconds) {

    return tmpURLGenerator.generateUrl(
        secret,
        Path.of(protectedPath),
        Path.of(filePath),
        Long.parseLong(timeSeconds));
  }
}
