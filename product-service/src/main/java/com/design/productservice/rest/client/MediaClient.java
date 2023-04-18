package com.design.productservice.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "media-service", url = "http://localhost:8084/image")
public interface MediaClient {

    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String saveImage(@RequestPart("image") MultipartFile image);
}
