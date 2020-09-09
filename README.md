# Temporary URL Generator

## Requires
 - Java 11 (Amazon Corretto)
 - [mod-auth-token](https://code.google.com/archive/p/mod-auth-token/)
 
## How to Use
 
### Deploy to Tomcat Server on Docker

```sh
docker-compose up -d

./mvnw clean package -Dmaven.test.skip

docker cp target/tmp-url-gen-0.0.1-SNAPSHOT.war tmp-url-gen_tomcat_1:/usr/local/tomcat/webapps/tmpurlgen.war

docker logs tmp-url-gen_tomcat_1
```

### Access to Web Application

```sh
open http://localhost:8080/tmpurlgen/genurl/limit?secret=SecretString&protectedPath=path&filePath=file.mp4&date=20201010235959
```
