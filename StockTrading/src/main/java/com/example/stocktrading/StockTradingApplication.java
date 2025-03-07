package com.example.stocktrading;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockTradingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockTradingApplication.class, args);
    }
}

