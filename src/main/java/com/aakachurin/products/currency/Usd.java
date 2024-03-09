package com.aakachurin.products.currency;

public class Usd implements ForeignCurrency{
  @Override
  public String asString() {
    return "USD";
  }
}
