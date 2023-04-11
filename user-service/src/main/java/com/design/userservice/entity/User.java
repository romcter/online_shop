package com.design.userservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractBaseEntity {


    @Schema(name= "name" , description = "User name", example ="Kostia")
    private String name;


    @ElementCollection
    @Schema(name= "productIds", description = "Array of user products", example = "\"productIds\": [ 1 ,2 ,3 ]")
    private List<Long> productIds;
}
