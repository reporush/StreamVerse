package org.rushrepo.backend.model;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "channels")
public class Channel {
    @Id
    private final ObjectId id;
    private ObjectId userId;
    private String name;
    private String description;

    private boolean isLive;
    private long followersCount;
    private Instant createdAt;
}