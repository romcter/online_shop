package com.design.mediaservice.entiry;

import jakarta.persistence.Id;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Photo {

    @Id
    private String id;

    private String title;

    private String originalFileName;

    private String contentType;

    private Binary image;

    public Photo() {
    }

    public Photo(String title) {
        this.title = title;
    }

    public Photo(String id, String title, Binary image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }
}
