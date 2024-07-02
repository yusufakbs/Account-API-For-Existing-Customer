FROM openjdk:17 AS build

# Maven Wrapper dosyalarını ve pom.xml dosyasını kopyala
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Maven wrapper dosyasına çalıştırma izni ver
RUN chmod +x ./mvnw

# Projeyi derle
RUN ./mvnw dependency:resolve

# Kaynak kodları kopyala
COPY src src

# Projeyi paketle
RUN ./mvnw package

FROM openjdk:17

# Çalışma dizinini ayarla
WORKDIR /account

# Derlenmiş jar dosyasını kopyala
COPY --from=build target/*.jar account.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "account.jar"]