package com.OOD2022;

public class Inventory {

    private final String product;

    private final int price;

    private int amount;

    private final int size;

    // Notice size defines the capacity of the inventory, not the actual product amount.
    public Inventory(String product, int price, int size) {
        this.product = product;
        this.price = price;
        this.size = size;
    }

    // fill will always fill the inventory to its capacity.
    public void fill() {
        this.amount = size;
    }

    public int getAmount() {
        return amount;
    }

    // return the product name.
    public String getProduct() {
        return this.product;
    }

    // return the product price.
    public int getPrice() {
        return this.price;
    }

    // return if the product can be vended with the given amount of money.
    public boolean canVend(int money) {
        return money >= price;
    }

    // return if the product is actually vended.
    public boolean vend(int money) {
        if (canVend(money) && this.amount > 0) {
            this.amount = this.amount - 1;
            return true;
        }
        return false;
    }
}
