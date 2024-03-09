package com.aakachurin.products.cards;

import com.aakachurin.products.currency.CountryCurrency;
import com.aakachurin.products.currency.Currency;
import com.aakachurin.products.currency.Rubles;
import com.aakachurin.products.currency.Usd;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class CardImplTest {

  @Test
  void balance() {
    Assertions.assertEquals(
        10D,
        new CardImpl(new Rubles(), 10D, "Зарплатная").balance()
    );
  }

  @Test
  void deposit() {
    CardImpl card = new CardImpl(new Rubles(), 10D, "Зарплатная");
    card.deposit(10D);
    Assertions.assertEquals(
        20D,
        card.balance()
    );
  }

  @Test
  void withdraw() {
    CardImpl card = new CardImpl(new Rubles(), 10D, "Зарплатная");
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
        () -> new CardImpl(new Rubles(), 10D, "Зарплатная").withdraw(15D)
    );
  }

  @Test
  void withdrawValidation2() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new CardImpl(new Rubles(), 10D, "Зарплатная").withdraw(-15D)
    );
  }

  @Test
  void checkCurrency() {
    new CardImpl(new Rubles(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency2() {
    Supplier<Currency> currencySupplier = () -> new Rubles() {
    };
    new CardImpl((CountryCurrency) currencySupplier.get(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency3() {
    Supplier<Currency> currencySupplier = () -> new Usd() {
    };
    Assertions.assertThrows(
        ClassCastException.class,
        () -> new CardImpl((CountryCurrency) currencySupplier.get(), 10D, "Зарплатная")
    );
  }

}