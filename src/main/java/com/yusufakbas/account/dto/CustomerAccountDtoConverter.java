package com.yusufakbas.account.dto;

import com.yusufakbas.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(from.getId(), from.getBalance(), from.getTransactions().stream().map(converter::convert).collect(Collectors.toSet()), from.getCreationDate());
    }

}
