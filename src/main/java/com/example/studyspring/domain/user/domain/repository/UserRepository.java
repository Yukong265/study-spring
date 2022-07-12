package com.example.studyspring.domain.user.domain.repository;

import com.example.studyspring.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAccounId(String accountId);
}
