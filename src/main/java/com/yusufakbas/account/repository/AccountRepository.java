package com.yusufakbas.account.repository;

import com.yusufakbas.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
