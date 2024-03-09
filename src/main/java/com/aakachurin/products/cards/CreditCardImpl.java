package com.aakachurin.products.cards;

import com.aakachurin.products.AbstractBankProduct;
import com.aakachurin.products.currency.CountryCurrency;

public class CreditCardImpl extends AbstractBankProduct<Double> implements CreditCard<Double> {

  private final Double interestRate;

  public CreditCardImpl(CountryCurrency currency, Double balance, String name, Double interestRate) {
    super(currency, balance, name);
    this.interestRate = interestRate;
  }

  public CreditCardImpl(CountryCurrency currency, Double balance, String name) {
    this(currency, balance, name, 10D);
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
  public void withdraw(Double amount) {
    balance -= Math.abs(amount);
  }

  @Override
  public Double getDebt() {
    if (balance < 0) {
      return Math.abs(balance);
    }
    return 0D;
  }
}
