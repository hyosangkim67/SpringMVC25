package org.mbc.controller;

import org.mbc.domain.BoardVO;
import org.mbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*") // http://192.168.111.104:80/board/*
@AllArgsConstructor

public class BoardController {

	private BoardService service;

	@GetMapping("/list") // http://192.168.111.104:80/board/list
	public void list(Model model) {
		// model = 스프링에서 사용하는 데이터관리용 객체
		log.info("BoardController.list 메서드 실행======");
		model.addAttribute("list", service.getList());

	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		// RedirectAttributes rttr 성공 후 이동할 경로를 기입한다
		log.info("BoardController.register 메서드 실행");
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}

	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("BoardController.get 메서드 실행");
		model.addAttribute("board", service.get(bno));

	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardController.get 메서드 실행...");
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "sucess");
			// 성공시 프론트에 result라는 이름으로 success 값을 보낸다
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("BoardController.remove 메서드 실행...");
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}
