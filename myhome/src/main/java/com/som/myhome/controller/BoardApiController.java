package com.som.myhome.controller;

import java.util.List;

import com.som.myhome.model.Board1;
import com.som.myhome.repository.BoardRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class BoardApiController {

  private final BoardRepository repository;

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/boards")
  List<Board1> all(@RequestParam(required = false, defaultValue = "") String title,
  @RequestParam(required = false, defaultValue = "") String content) {
      if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)){
          return repository.findAll();
      }else{
          return repository.findByTitleOrContent(title,content);
      }
  }
  // end::get-aggregate-root[]

  @PostMapping("/boards")
  Board1 newBoard1(@RequestBody Board1 newBoard) {
    return repository.save(newBoard);
  }

  // Single item
  
  @GetMapping("/boards/{id}")
  Board1 one(@PathVariable Long id) { 
    return repository.findById(id).orElse(null);
  }

  @PutMapping("/boards/{id}")
  Board1 replaceBoard1(@RequestBody Board1 newBoard, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Board1 -> {
        Board1.setTitle(newBoard.getTitle());
        Board1.setContent(newBoard.getContent());
        return repository.save(Board1);
      })
      .orElseGet(() -> {
        newBoard.setId(id);
        return repository.save(newBoard);
      });
  }

  @DeleteMapping("/boards/{id}")
  void deleteBoard1(@PathVariable Long id) {
    repository.deleteById(id);
  }
}