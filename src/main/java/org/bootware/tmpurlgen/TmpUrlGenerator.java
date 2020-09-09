package org.bootware.tmpurlgen;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Component;

@Component
public class TmpUrlGenerator {

  public String generateUrl(
      String secret, Path protectedPath, Path filePath,
      long secondsTime) {

    String filePathName = filePath.normalize().toString();

    // Same as AuthTokenPrefix
    // boolean ipLimitation=false;

    // timestamp of java is longer than PHP
    String hexTime = Long.toHexString(secondsTime);

    // hexTime in Hexadecimal
    String token = getMD5((secret + filePathName + hexTime).getBytes());

    return protectedPath.resolve(token)
        .resolve(hexTime).resolve(filePathName).normalize().toString();
  }

  public String generateUrl(String secret, Path protectedPath, Path filePath,
      LocalDateTime limitDateTime) {

    // Same as AuthTokenLimitByIp
    long secondsTime = LocalDateTime.now().until(limitDateTime, ChronoUnit.SECONDS);

    return generateUrl(secret, protectedPath, filePath, secondsTime);
  }

  public String getMD5(byte[] source) {

    String s = null;

    char hexDigits[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    try {
      java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
      md.update(source);
      byte tmp[] = md.digest();
      char str[] = new char[16 * 2];
      int k = 0;
      for (int i = 0; i < 16; i++) {
        byte byte0 = tmp[i];
        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
        str[k++] = hexDigits[byte0 & 0xf];
      }
      s = new String(str);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return s;
  }
}
