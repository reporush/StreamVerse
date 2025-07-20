package org.rushrepo.backend.dto;

import java.time.Instant;
import java.util.List;

import org.bson.types.ObjectId;
import org.rushrepo.backend.enums.StreamStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class VideoStreamDto {
    private final ObjectId id;
    private ObjectId channelId;

    private String title;
    private String description;
    private String streamKey;
    private StreamStatus streamStatus; 
    private String thumbnailUrl;
    private List<String> tags;
    
    private Instant startTime;
    private Instant endTime;
    private long peakViewersCount;
}
