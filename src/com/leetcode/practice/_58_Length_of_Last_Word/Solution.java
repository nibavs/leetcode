package com.leetcode.practice._58_Length_of_Last_Word;

import jdk.jfr.DataAmount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        while (end >= 0 && s.charAt(end--) != ' ') res++;
        return res;

    }

    enum OrderStatus {
        PAID,
        UNPAID
    }

    class Order {
        private Long customerId;
        private OrderStatus status;
        private BigDecimal total;
//        private List<OrderLine> lines;


        public Long getCustomerId() {
            return customerId;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public BigDecimal getTotal() {
            return total;
        }
    }

    public void fn() {
        List<Order> orders = List.of(new Order());
        Map<Long, BigDecimal> clientIdPaidOrdersSum = orders.stream()
                .filter(order -> order.status == OrderStatus.PAID)
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Order::getTotal,
                                BigDecimal::add
                        )
                ));
    }

}
