package org.rushrepo.backend.model;


import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
@Document(collection = "categories")
public class Category {
    @Id
    private final String id;
    private String name;
    private String boxArtUrl;
}
