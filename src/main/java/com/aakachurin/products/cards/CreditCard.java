package com.aakachurin.products.cards;

public interface CreditCard<T> extends Card<T> {
  T getDebt();

}
