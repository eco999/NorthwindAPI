package com.sparta.sleepint.northwindapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sparta.sleepint.northwindapi.entity.Order;
import com.sparta.sleepint.northwindapi.exceptions.ControllerExceptionHandler;
import com.sparta.sleepint.northwindapi.exceptions.ResourceException;
import com.sparta.sleepint.northwindapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getOrdersWithinDateRange(String startDate, String endDate) {
        // Specify the required date format that will be used to parse the date
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date sDate;
        Date eDate;
        try {
            sDate = dateFormatter.parse(startDate); // throws ParseException
            eDate = dateFormatter.parse(endDate); // throws ParseException
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        Date finalSDate = sDate;
        Date finalEDate = eDate;
        List<Order> orders = orderRepository.findAll()
                .stream()
                .filter(order -> order.getOrderDate().isAfter(finalSDate.toInstant()) && order.getOrderDate().isBefore(finalEDate.toInstant()))
                .toList();

        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(orders,status);
    }

    @GetMapping("/all/range")
    public ResponseEntity<List<Order>> getOrdersWithinDateRange(String date, boolean isStartDate) {
        // Specify the required date format that will be used to parse the date
        System.out.println(isStartDate);
        if(isStartDate) System.out.println("true");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date inputDate;
        try {
            inputDate = dateFormatter.parse(date); // throws ParseException
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        Date finalDate = inputDate;


        List<Order> orders;
        if (isStartDate) {
            orders = orderRepository.findAll()
                    .stream()
                    .filter(order -> order.getOrderDate().isAfter(finalDate.toInstant()))
                    .toList();
        } else {
            orders = orderRepository.findAll()
                    .stream()
                    .filter(order -> order.getOrderDate().isBefore(finalDate.toInstant()))
                    .toList();
        }

        HttpStatus status = orders.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(orders, status);
    }
}
