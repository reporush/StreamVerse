package org.rushrepo.backend.dto;

import java.time.Instant;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ChannelDto {
    private final ObjectId id;
    private String userId;
    private String name;
    private String description;

    private boolean isLive;
    private long followersCount;
    private Instant createdAt;
}
