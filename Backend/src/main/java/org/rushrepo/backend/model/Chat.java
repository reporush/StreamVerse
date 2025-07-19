package org.rushrepo.backend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "chats")
public class Chat {
    @Id
    private String id;
    private ObjectId streamId;
    private ObjectId userId;
    private String username;
    private String message;
    private Instant timestamp;
}
