package com.design.mediaservice.controller;

import com.design.mediaservice.entiry.Photo;
import com.design.mediaservice.service.PhotoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> getPhoto(@PathVariable String id) {
        Photo photo = photoService.getPhoto(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE))
                .body(new ByteArrayResource(photo.getImage().getData()));
    }

    @PostMapping("/")
    public String addPhoto(@RequestParam(value = "title", required = false) String title,
                           @RequestParam("image") MultipartFile image) {
        return photoService.addPhoto(title, image);
    }
}
