package nhn.rookieHAMATF.ryungjinkim_movie.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nhn.rookieHAMATF.ryungjinkim_movie.dto.MovieDTO;
import nhn.rookieHAMATF.ryungjinkim_movie.dto.PageRequestDTO;
import nhn.rookieHAMATF.ryungjinkim_movie.entity.Movie;
import nhn.rookieHAMATF.ryungjinkim_movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes){
        log.info("movieDTO: " + movieDTO);

        Long mno = movieService.register(movieDTO);
        redirectAttributes.addFlashAttribute("msg", mno);
        return "redirect:/movie/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("pageRequestDTO: " + pageRequestDTO);
        model.addAttribute("result", movieService.getList(pageRequestDTO));
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long mno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("mno: " + mno);
        MovieDTO movieDTO = movieService.getMovie(mno);
        model.addAttribute("dto", movieDTO);
    }

    @PostMapping("/modify")
    public String modify(Long mno, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO , RedirectAttributes redirectAttributes, Model model){
        movieService.modify(mno);

        redirectAttributes.addAttribute("mno", mno);
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());

        return "redirect:/movie/read";
    }

    @PostMapping("/remove")
    public String remove(Long mno, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDT, RedirectAttributes redirectAttributes, Model model){
        movieService.remove(mno);
        redirectAttributes.addFlashAttribute("msg", "success");
        return "redirect:/movie/list";
    }
}
