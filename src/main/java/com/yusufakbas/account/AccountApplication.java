package com.yusufakbas.account;

import com.yusufakbas.account.model.Customer;
import com.yusufakbas.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.util.HashSet;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public AccountApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

//    @Bean
//    public OpenAPI customOpenAPI(@Value("${application-description}") String description,
//                                 @Value("${application-version}") String version){
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Account API")
//                        .version(version)
//                        .description(description)
//                        .license(new License().name("Account API Licence")));
//    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Override
    public void run(String... args)  {
        Customer customer = customerRepository.save(new Customer("Cagri", "Dursun"));
        Customer customer2 = customerRepository.save(new Customer("Alice", "Bob"));

        System.out.println(customer);
        System.out.println(customer2);

    }



}
