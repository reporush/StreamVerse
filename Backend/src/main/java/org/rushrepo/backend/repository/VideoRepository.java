package org.rushrepo.backend.repository;

import org.rushrepo.backend.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
