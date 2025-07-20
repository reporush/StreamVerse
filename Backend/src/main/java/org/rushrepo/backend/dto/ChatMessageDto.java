package org.rushrepo.backend.dto;

import java.time.Instant;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ChatMessageDto {
    private final ObjectId id;
    private ObjectId streamId;
    private ObjectId userId;
    private String message;
    private Instant timestamp;
}
