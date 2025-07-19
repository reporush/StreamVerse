package org.rushrepo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "streams")
public class VideoStream {
    @Id
    private String id;
    private String streamKey;
    private String title;
    private boolean isLive;
    private String categoryId;
    private String categoryName;
    private String vodUrl;
    private long peakViewership;
    private Instant startedAt;

    // Harus ada koneksi ke user
}
