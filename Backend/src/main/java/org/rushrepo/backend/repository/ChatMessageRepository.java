package org.rushrepo.backend.repository;

import org.rushrepo.backend.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<Chat, String> {
    
}
