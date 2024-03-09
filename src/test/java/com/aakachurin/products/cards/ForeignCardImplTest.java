package com.aakachurin.products.cards;

import com.aakachurin.products.currency.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class ForeignCardImplTest {

  @Test
  void balance() {
    Assertions.assertEquals(
        10D,
        new ForeignCardImpl(new Usd(), 10D, "Зарплатная").balance()
    );
  }

  @Test
  void deposit() {
    ForeignCardImpl card = new ForeignCardImpl(new Usd(), 10D, "Зарплатная");
    card.deposit(10D);
    Assertions.assertEquals(
        20D,
        card.balance()
    );
  }

  @Test
  void withdraw() {
    ForeignCardImpl card = new ForeignCardImpl(new Usd(), 10D, "Зарплатная");
    card.withdraw(5D);
    Assertions.assertEquals(
        5D,
        card.balance()
    );
  }

  @Test
  void withdrawValidation() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new ForeignCardImpl(new Usd(), 10D, "Зарплатная").withdraw(15D)
    );
  }

  @Test
  void withdrawValidation2() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new ForeignCardImpl(new Usd(), 10D, "Зарплатная").withdraw(-15D)
    );
  }

  @Test
  void checkCurrency() {
    new ForeignCardImpl(new Usd(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency2() {
    Supplier<Currency> currencySupplier = () -> new Usd() {
    };
    new ForeignCardImpl((ForeignCurrency) currencySupplier.get(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency3() {
    Supplier<Currency> currencySupplier = () -> new Rubles() {
    };
    Assertions.assertThrows(
        ClassCastException.class,
        () -> new ForeignCardImpl((ForeignCurrency) currencySupplier.get(), 10D, "Зарплатная")
    );
  }

}