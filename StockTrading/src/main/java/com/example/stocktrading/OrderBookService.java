package com.example.stocktrading;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderBookService {

    private final AtomicReference<Queue<Order>> buyOrders = new AtomicReference<>(new LinkedList<>());
    private final AtomicReference<Queue<Order>> sellOrders = new AtomicReference<>(new LinkedList<>());

    public void addOrder(Order order) {
        Queue<Order> orderQueue = (order.getOrderType() == Order.Type.BUY) ? buyOrders.get() : sellOrders.get();
        synchronized (orderQueue) {
            orderQueue.add(order);
        }

        matchOrders();
    }

    private void matchOrders() {
        Queue<Order> buyQueue = buyOrders.get();
        Queue<Order> sellQueue = sellOrders.get();

        synchronized (buyQueue) {
            synchronized (sellQueue) {
                while (!buyQueue.isEmpty() && !sellQueue.isEmpty()) {
                    Order buyOrder = buyQueue.peek();
                    Order sellOrder = sellQueue.peek();

                    if (buyOrder.getTickerSymbol().equals(sellOrder.getTickerSymbol()) &&
                        buyOrder.getPrice() >= sellOrder.getPrice()) {

                        int matchedQty = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());
                        System.out.println("Matched " + matchedQty + " shares of " + buyOrder.getTickerSymbol() +
                                           " at price " + sellOrder.getPrice());

                        buyOrder.quantity -= matchedQty;
                        sellOrder.quantity -= matchedQty;

                        if (buyOrder.getQuantity() == 0) {
                            buyQueue.poll();
                        }
                        if (sellOrder.getQuantity() == 0) {
                            sellQueue.poll();
                        }
                    } else {
                        break; // Orders cannot be matched, exit
                    }
                }
            }
        }
    }
}
