package com.example.stocktrading;

import java.util.Random;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSimulator {

    @Autowired
    private OrderBookService orderBookService;

    private static final String[] TICKERS = {"AAPL", "MSFT", "GOOGL", "AMZN", "TSLA"};
    private static final Random random = new Random();

    @Scheduled(fixedRate = 1000)
    public void simulateOrders() {
        Order.Type orderType = random.nextBoolean() ? Order.Type.BUY : Order.Type.SELL;
        String ticker = TICKERS[random.nextInt(TICKERS.length)];
        int quantity = random.nextInt(100) + 1;
        double price = 100 + random.nextDouble() * 50;

        Order order = new Order(orderType, ticker, quantity, price);
        orderBookService.addOrder(order);
    }
}
