package com.aakachurin.products.deposits;

import com.aakachurin.products.actions.WithBalance;
import com.aakachurin.products.actions.WithClose;
import com.aakachurin.products.actions.WithDeposit;

public interface Deposit<T> extends WithBalance<T>, WithDeposit<T>, WithClose {
}