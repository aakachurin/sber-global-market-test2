package com.aakachurin.products;

import com.aakachurin.products.actions.WithBalance;
import com.aakachurin.products.currency.Currency;

public class AbstractWithBalance<T> implements WithBalance<T> {
  protected final Currency currency;
  protected final String name;
  protected T balance;

  public AbstractWithBalance(Currency currency, T balance, String name) {
    this.currency = currency;
    this.balance = balance;
    this.name = name;
  }

  @Override
  public T balance() {
    return balance;
  }
}
