package org.rushrepo.backend.repository;

import org.rushrepo.backend.model.VideoStream;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<VideoStream, String> {
}
