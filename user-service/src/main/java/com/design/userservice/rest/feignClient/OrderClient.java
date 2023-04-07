package com.design.userservice.rest.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "http://localhost:8081/orders")
public interface OrderClient {

        @RequestMapping(method = RequestMethod.GET, value = "/")
        List<OrderDto> getOrders();

//        @RequestMapping(method = RequestMethod.GET, value = "/{orderId}/", produces = "application/json")
//        OrderDto getOrderById(@PathVariable("orderId") Long orderId);
}
