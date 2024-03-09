package com.aakachurin.products.cards;

import com.aakachurin.products.AbstractBankProduct;
import com.aakachurin.products.currency.ForeignCurrency;

public class ForeignCardImpl extends AbstractBankProduct<Double> implements Card<Double> {
  public ForeignCardImpl(ForeignCurrency currency, Double balance, String name) {
    super(currency, balance, name);
  }

  @Override
  public void deposit(Double amount) {
    if (amount > 0) {
      balance += amount;
    }
  }

  @Override
  public void withdraw(Double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Можно снять только положительную сумму");
    }
    if (balance - amount > 0) {
      balance -= amount;
    } else {
      throw new IllegalArgumentException("Недостаточно средств для снятия");
    }
  }
}
