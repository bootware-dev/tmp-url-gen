package org.bootware.tmpurlgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TmpUrlGenApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(TmpUrlGenApplication.class, args);
  }
}
