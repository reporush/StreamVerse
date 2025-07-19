package org.rushrepo.backend.repository;

import org.rushrepo.backend.model.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelRepository extends MongoRepository<Channel, String> {
    
}
