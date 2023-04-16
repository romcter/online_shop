package com.design.userservice.rest.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "user-service", url = "http://localhost:8081/bucket")
public interface OrderClient {

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    Long createAndAssignBucketToUser(@RequestBody Long userId);
}
