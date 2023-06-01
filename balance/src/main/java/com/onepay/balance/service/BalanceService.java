package com.onepay.balance.service;

import java.math.BigDecimal;

public interface BalanceService {

    BigDecimal getUserBalance(Integer userId);
    boolean debitingFundsFromBankAccount(Integer userId, BigDecimal sum);
    void entranceFundsToBankAccount(Integer userId, BigDecimal sum);
    void setNewBalanceForUserClient(Integer id, BigDecimal newBalance);
}
