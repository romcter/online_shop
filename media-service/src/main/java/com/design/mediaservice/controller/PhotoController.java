package com.design.mediaservice.controller;

import com.design.mediaservice.entiry.Photo;
import com.design.mediaservice.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id) {
        return photoService.getPhoto(id);
    }

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam(value = "title", required = false) String title,
                           @RequestParam("image") MultipartFile image) {
        return photoService.addPhoto(title, image);
    }
}
