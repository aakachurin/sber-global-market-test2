package com.aakachurin.products.deposits;

import com.aakachurin.products.BankProduct;

public interface Deposit<T> extends BankProduct<T> {
  void deposit(T amount);
  void close();
}