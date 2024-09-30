## Use uma imagem base do OpenJDK
FROM openjdk:21-jdk
#
## Defina o diretório de trabalho
WORKDIR /app
#
## Copie o JAR da aplicação para o contêiner
COPY target/ebookstore-0.0.1-SNAPSHOT.jar app.jar
#
## Exponha a porta em que a aplicação estará rodando
EXPOSE 8080
#
## Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]