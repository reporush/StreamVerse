package org.rushrepo.backend.repository;

import java.util.Optional;

import org.rushrepo.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findByUsername(String username);
    public Optional<User> findByEmail(String email);
}
