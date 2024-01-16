package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.config.auth.LoginUser;
import com.practice.jeongin.portfolio.config.auth.dto.SessionUsers;
import com.practice.jeongin.portfolio.service.board.BoardService;
import com.practice.jeongin.portfolio.web.dto.BoardDTO;
import com.practice.jeongin.portfolio.web.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model, @LoginUser SessionUsers user){

//        if(user != null) {
//            model.addAttribute("usersName", user.getName());
//            model.addAttribute("picture", user.getPicture());
//        }

        model.addAttribute("result" , boardService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public String register(Model model,@LoginUser SessionUsers user) {

//        log.info("get Resister");
//
//        if(user != null) {
//            model.addAttribute("usersName", user.getName());
//            model.addAttribute("userEmail", user.getEmail());
//            model.addAttribute("picture", user.getPicture());
//        }

        return "/board/register";
    }

    @PostMapping("/register")
    public String registerBoard(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        log.info("data:" +boardDTO);

        Long bno = boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute("msg", bno);

        return "redirect:/board/list";
    }

    @GetMapping({"/view","/modify"})
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
                     Long bno, Model model,@LoginUser SessionUsers user) {

//        if(user != null) {
//            model.addAttribute("usersName", user.getName());
//            model.addAttribute("userEmail", user.getEmail());
//            model.addAttribute("picture", user.getPicture());
//        }

        BoardDTO boardDTO = boardService.get(bno);

        model.addAttribute("dto", boardDTO);

    }

    @PostMapping("/remove")
    public String remove(long bno, RedirectAttributes redirectAttributes){

        boardService.removeWithReplies(bno);

        redirectAttributes.addFlashAttribute("msg",bno);

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
                         RedirectAttributes redirectAttributes){

        boardService.modify(boardDTO);

        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("bno", boardDTO.getBno());

        return "redirect:/board/view";

    }

}
