package com.yusufakbas.account.service;

import com.yusufakbas.account.dto.AccountDto;
import com.yusufakbas.account.dto.converter.AccountDtoConverter;
import com.yusufakbas.account.dto.CreateAccountRequest;
import com.yusufakbas.account.model.Account;
import com.yusufakbas.account.model.Customer;
import com.yusufakbas.account.model.Transaction;
import com.yusufakbas.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;
    private final Clock clock;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter, Clock clock) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
        this.clock = clock;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                getLocalDateTimeNow());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    getLocalDateTimeNow(),
                    account);

            account.getTransactions().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

    private LocalDateTime getLocalDateTimeNow() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }
}