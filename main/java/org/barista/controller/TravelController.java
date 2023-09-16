package org.barista.controller;

import org.barista.domain.BoardVO;
import org.barista.domain.Criteria;
import org.barista.domain.PageDTO;
import org.barista.domain.TravelVO;
import org.barista.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	private TravelService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri,
			Model model) {
		
		// TravelService 인터페이스를 통해 getTotal() 호출
		int total = service.getTotal(cri);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("no") Long no,
			@ModelAttribute("cri") Criteria cri,
			Model model) {

		model.addAttribute("travel", service.get(no));
	}
	
	// 실제 DB에 업데이트
	@PostMapping("/modify")
	public String modify(TravelVO travel,
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {

		service.modify(travel);

		// primary key인 no로 get == javascript식 코드
		return "redirect:" + cri.getLink("/travel/get")
						+ "&no=" + travel.getNo();
	}
	
	@GetMapping("/register")
	public void register() {

	}
	
	@PostMapping("/register")
	public String Register(TravelVO travel, RedirectAttributes rttr) {

		service.register(travel);
		rttr.addFlashAttribute("result", travel.getNo());

		return "redirect:/travel/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("no") Long no,
			@ModelAttribute("cri") Criteria cri,
		RedirectAttributes rttr) {
			
		service.remove(no);
		
		return "redirect:" +cri.getLink();
	}

}
