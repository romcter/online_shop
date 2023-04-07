package com.design.mediaservice.service;

import com.design.mediaservice.entiry.Photo;
import com.design.mediaservice.repository.PhotoRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import jakarta.persistence.Id;
import org.bson.BsonBinarySubType;
import org.bson.BsonValue;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {

    private final PhotoRepository photoRepo;

    public PhotoService(PhotoRepository photoRepo) {
        this.photoRepo = photoRepo;
    }

    public String addPhoto(String title, MultipartFile file) {
        Photo photo = new Photo("id" ,title);
        try {
            photo.setImage(
                    new Binary(BsonBinarySubType.BINARY, file.getBytes()));
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
