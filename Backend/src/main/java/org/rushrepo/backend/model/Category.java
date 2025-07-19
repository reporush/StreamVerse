package org.rushrepo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="categories")
public class Category {
    @Id
    private String id;
    private String name;
    private String boxArtUrl;
}
