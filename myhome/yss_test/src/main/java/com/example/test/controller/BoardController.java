
package com.example.test.controller;
import com.example.test.model.Board;
import com.example.test.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @RequestMapping("/boardPage")
    public String boardPage(Model model){
        model.addAttribute("boardList", this.boardRepository.findAll());
        return "contents/board/boardList";
    }

    @PostMapping("/boardWrite")
    public String boardWrite(@ModelAttribute Board board){
        boardRepository.save(board);
        return "redirect:/register/boardPage";        
    }
}
