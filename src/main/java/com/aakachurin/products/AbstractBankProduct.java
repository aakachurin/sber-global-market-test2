package com.aakachurin.products;

import com.aakachurin.products.currency.Currency;

public class AbstractBankProduct<T> implements BankProduct<T> {
  protected final Currency currency;
  protected final String name;
  protected T balance;

  public AbstractBankProduct(Currency currency, T balance, String name) {
    this.currency = currency;
    this.balance = balance;
    this.name = name;
  }

  @Override
  public T balance() {
    return balance;
  }
}
