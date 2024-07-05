
# Account API For Existing Customer

Bu proje, mevcut müşteriler için yeni bir hesap oluşturmayı sağlar.

## Özet

Bu proje, var olan müşteriler için yeni bir "vadeli hesap" açmak için kullanılan bir API sağlar.

## Gereksinimler

- API, kullanıcı bilgilerini (customerID, initialCredit) kabul eden bir endpoint sunacaktır.
  
- Endpoint çağrıldığında, customerID'si belirtilen kullanıcıya bağlı yeni bir hesap açılacaktır.
  
- initialCredit 0 değilse, yeni hesaba bir işlem gönderilecektir.
  
- Başka bir endpoint, adı, soyadı, bakiyesi ve hesap işlemlerini gösteren kullanıcı bilgilerini çıktı olarak verecektir.

## Uygulama API'leri

- AccountAPI
  - POST /v1/account - mevcut müşteri için yeni bir hesap oluşturur
- CustomerAPI
  - GET /v1/customer/{customerId} - belirtilen müşteriyi getirir
  - GET /v1/customer - tüm müşterileri getirir

## Test Kapsamı

- JUnit ve entegrasyon testleri mevcuttur.

## Kullanılan Teknolojiler

- Java
- Spring Boot
- Spring Data JPA
- Kotlin
- Restful API
- H2 In-Memory veritabanı
- Docker
- JUnit

## Gereksinimler

- Maven
- Docker

Uygulama, varsayılan olarak 8080 portunda çalışacaktır.



