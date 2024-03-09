package com.aakachurin.products.cards;

import com.aakachurin.products.AbstractWithBalance;
import com.aakachurin.products.currency.CountryCurrency;

public class CardImpl extends AbstractWithBalance<Double> implements Card<Double> {

  public CardImpl(CountryCurrency currency, Double balance, String name) {
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