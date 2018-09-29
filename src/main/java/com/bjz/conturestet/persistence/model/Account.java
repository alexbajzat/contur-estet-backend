package com.bjz.conturestet.persistence.model;

import com.bjz.conturestet.exception.InvalidArgumentException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class Account extends BaseModel {
    private final Integer id;
    private final String email;
    private final String password;
    private final AccountType accountType;

    Account(
            Integer id,
            String email,
            String password,
            AccountType accountType,
            LocalDateTime createdOn,
            LocalDateTime updatedOn) {

        super(createdOn, updatedOn);
        this.id = id;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public enum AccountType {
        ADMIN(1), MODERATOR(2), REGULAR(3);

        Integer value;

        AccountType(Integer value) {
            Objects.requireNonNull(value);
            this.value = value;
        }

        public AccountType getByValue(int value) {
            return Stream.of(AccountType.values())
                    .filter(type -> type.value.equals(value))
                    .findFirst()
                    .orElseThrow(() -> new InvalidArgumentException(String.format("No account type for value: %d", value)));
        }
    }
}
