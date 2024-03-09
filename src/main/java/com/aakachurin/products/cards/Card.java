package com.aakachurin.products.cards;

import com.aakachurin.products.actions.WithBalance;
import com.aakachurin.products.actions.WithDeposit;
import com.aakachurin.products.actions.WithWithdraw;

public interface Card<T> extends WithBalance<T>, WithDeposit<T>, WithWithdraw<T> {
}
