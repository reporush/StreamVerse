package org.rushrepo.backend.repository;

import org.rushrepo.backend.model.Stream;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<Stream, String> {
}
