package com.design.mediaservice.service;

import org.bson.types.Binary;
import org.bson.BsonBinarySubType;
import com.design.mediaservice.entiry.Photo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.design.mediaservice.repository.PhotoRepository;

import java.io.IOException;

@Service
public class PhotoService {

    private final PhotoRepository photoRepo;

    public PhotoService(PhotoRepository photoRepo) {
        this.photoRepo = photoRepo;
    }

    public String addPhoto(String title, MultipartFile file) {
        Photo photo = new Photo(title);
        try {
            photo.setImage(
                    new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            photo.setTitle(title);
            photo.setOriginalFileName(file.getOriginalFilename());
            photo.setContentType(file.getContentType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        photo = photoRepo.insert(photo);
        return photo.getId();
    }

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }
}
