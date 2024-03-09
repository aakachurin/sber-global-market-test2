package com.aakachurin.products.cards;

import com.aakachurin.products.BankProduct;

public interface Card<T> extends BankProduct<T> {
  void deposit(T amount);
  void withdraw(T amount);
}
