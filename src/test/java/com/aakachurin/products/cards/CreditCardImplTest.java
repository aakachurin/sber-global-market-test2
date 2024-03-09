package com.aakachurin.products.cards;

import com.aakachurin.products.currency.CountryCurrency;
import com.aakachurin.products.currency.Currency;
import com.aakachurin.products.currency.Rubles;
import com.aakachurin.products.currency.Usd;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class CreditCardImplTest {

  @Test
  void balance() {
    Assertions.assertEquals(
        10D,
        new CreditCardImpl(new Rubles(), 10D, "Зарплатная").balance()
    );
  }

  @Test
  void deposit() {
    CreditCardImpl card = new CreditCardImpl(new Rubles(), 10D, "Зарплатная");
    card.deposit(10D);
    Assertions.assertEquals(
        20D,
        card.balance()
    );
  }

  @Test
  void withdraw() {
    CreditCardImpl card = new CreditCardImpl(new Rubles(), 10D, "Зарплатная");
    card.withdraw(15D);
    Assertions.assertEquals(
        -5D,
        card.balance()
    );
  }

  @Test
  void checkCurrency() {
    new CreditCardImpl(new Rubles(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency2() {
    Supplier<Currency> currencySupplier = () -> new Rubles() {
    };
    new CreditCardImpl((CountryCurrency) currencySupplier.get(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency3() {
    Supplier<Currency> currencySupplier = () -> new Usd() {
    };
    Assertions.assertThrows(
        ClassCastException.class,
        () -> new CreditCardImpl((CountryCurrency) currencySupplier.get(), 10D, "Зарплатная")
    );
  }

}