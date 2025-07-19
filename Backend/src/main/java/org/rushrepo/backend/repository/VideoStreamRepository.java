package org.rushrepo.backend.repository;


import org.rushrepo.backend.model.VideoStream;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoStreamRepository extends MongoRepository<VideoStream, String> {
    
}
