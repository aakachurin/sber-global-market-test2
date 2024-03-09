package com.aakachurin.products.deposits;

import com.aakachurin.products.currency.CountryCurrency;
import com.aakachurin.products.currency.Currency;
import com.aakachurin.products.currency.Rubles;
import com.aakachurin.products.currency.Usd;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class DepositImplTest {

  @Test
  void balance() {
    Assertions.assertEquals(
        10D,
        new DepositImpl(new Rubles(), 10D, "Зарплатная").balance()
    );
  }

  @Test
  void deposit() {
    DepositImpl deposit = new DepositImpl(new Rubles(), 10D, "Зарплатная");
    deposit.deposit(10D);
    Assertions.assertEquals(
        20D,
        deposit.balance()
    );
  }

  @Test
  void close() {
    DepositImpl deposit = new DepositImpl(new Rubles(), 10D, "Зарплатная");
    deposit.close();
    Assertions.assertEquals(
        0,
        deposit.balance()
    );
  }

  @Test
  void checkCurrency() {
    new DepositImpl(new Rubles(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency2() {
    Supplier<Currency> currencySupplier = () -> new Rubles() {
    };
    new DepositImpl((CountryCurrency) currencySupplier.get(), 10D, "Зарплатная");
  }

  @Test
  void checkCurrency3() {
    Supplier<Currency> currencySupplier = () -> new Usd() {
    };
    Assertions.assertThrows(
        ClassCastException.class,
        () -> new DepositImpl((CountryCurrency) currencySupplier.get(), 10D, "Зарплатная")
    );
  }

}