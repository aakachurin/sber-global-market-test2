package com.aakachurin.products.cards;

import com.aakachurin.products.actions.WithDebt;

public interface CreditCard<T> extends Card<T>, WithDebt<T> {
}
