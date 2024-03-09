package com.aakachurin.products.deposits;

import com.aakachurin.products.AbstractWithBalance;
import com.aakachurin.products.currency.CountryCurrency;

public class DepositImpl extends AbstractWithBalance<Double> implements Deposit<Double> {

  public DepositImpl(CountryCurrency currency, Double balance, String name) {
    super(currency, balance, name);
  }

  @Override
  public void deposit(Double amount) {
    if (amount > 0) {
      balance += amount;
    } else {
      throw new IllegalArgumentException("Можно пополнить только положительную сумму");
    }
  }

  @Override
  public void close() {
    balance = 0D; //Логика закрытия вклада для примера
  }
}
