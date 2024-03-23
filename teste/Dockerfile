# Qual imagem eu quero que ele crie
FROM ubuntu:latest AS build
LABEL authors="Rodney"

# atualizar o Docker e Instalação do jdk 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Copia os arquivos dentro do spring boot p/ docker
COPY . .

#Instalar o maven
RUN apt-get install maven -y
RUN mvn clean install


FROM openjdk:17-jdk-slim

EXPOSE 1200

COPY --from=build /target/deploy_render-1.0.0.jar app.jar

# O que eu quero que ele execute
ENTRYPOINT ["java", "-jar", "app.jar"]