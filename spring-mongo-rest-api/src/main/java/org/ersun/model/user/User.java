package org.ersun.model.user;

import lombok.Getter;
import lombok.Setter;
import org.ersun.model.user.pets.Pets;
import org.ersun.model.user.specs.Specs;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "User")
@Getter
@Setter
public class User {

    @MongoId
    private String id;
    private String userName;
    private String surname;
    private Specs specs;
    private List<Pets> pets;

}
