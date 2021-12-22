package com.som.myhome.repository;

import com.som.myhome.model.Board1;
import com.som.myhome.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Board1, Long> {

    User save(User user);

}
