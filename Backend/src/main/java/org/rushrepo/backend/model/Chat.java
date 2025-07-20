package org.rushrepo.backend.model;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
@Document(collection = "chat_messages")
public class Chat {
    @Id
    private final ObjectId id;
    private ObjectId streamId;
    private ObjectId userId;
    private String username;
    private String message;
    private Instant timestamp;
}
