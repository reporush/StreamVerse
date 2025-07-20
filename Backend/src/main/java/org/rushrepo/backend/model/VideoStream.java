package org.rushrepo.backend.model;

import java.time.Instant;
import java.util.List;

import org.bson.types.ObjectId;
import org.rushrepo.backend.enums.*;
import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
@Document(collection = "video_streams")
public class VideoStream {
    @Id
    private final ObjectId id;
    private ObjectId channelId;

    private String title;
    private String description;
    private String streamKey;
    private StreamStatus streamStatus; 
    private String vodUrl;
    private List<String> tags;
    private long peakViewership;
    private Instant startTime;
    private Instant endTime;
}
