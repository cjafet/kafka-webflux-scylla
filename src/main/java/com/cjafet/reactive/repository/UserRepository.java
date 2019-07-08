package com.cjafet.reactive.repository;

import com.cjafet.reactive.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier("user")
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
