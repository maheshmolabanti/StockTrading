package com.example.stocktrading;

public class Order {
    public enum Type { BUY, SELL }

    private Type orderType;
    private String tickerSymbol;
    int quantity;
    private double price;

    public Order(Type orderType, String tickerSymbol, int quantity, double price) {
        this.orderType = orderType;
        this.tickerSymbol = tickerSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    public Type getOrderType() {
        return orderType;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters, toString, hashCode, and equals can be added as needed
}
