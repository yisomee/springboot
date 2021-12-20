package com.som.myhome.repository;

import java.util.List;

import com.som.myhome.model.Board1;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board1, Long> {
    List<Board1> findByTitle(String title);
    List<Board1> findByTitleOrContent(String title, String content);
}
