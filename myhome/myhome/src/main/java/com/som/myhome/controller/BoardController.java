package com.som.myhome.controller;

import java.util.List;

import com.som.myhome.model.Board1;
import com.som.myhome.repository.BoardRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

   private final BoardRepository boardRepository;

    @GetMapping("/list")    
    public String list(Model model){
        List<Board1> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);       
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id==null){
            model.addAttribute("board", new Board1());
        }else{
            Board1 board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
        return "board/form";
    }

    //                  model id 키값이 존재하는 경우에는 update가 되고 없을 경우 insert
    @PostMapping("/form")
    public String form(@ModelAttribute Board1 board){
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
