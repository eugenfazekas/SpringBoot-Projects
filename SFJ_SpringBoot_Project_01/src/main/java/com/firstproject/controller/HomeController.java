package com.firstproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstproject.domain.Story;
import com.firstproject.repository.StoryRepository;

@Controller
public class HomeController {
	
	@Autowired
	StoryRepository storyRepo;
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("pageTitle", "Minden napra egy SFJ sztori");
		model.addAttribute("stories", getStories());
		return "stories";
	}
	
	@RequestMapping("/user/{id}")
	public String searchForUser(@PathVariable(value="id") String id) throws Exception {
		if(id == null)
			throw new Exception("Nincs ilyen ID-val felhaszlonk");
		
		return "user";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler (HttpServletRequest rA , Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "exceptionHandler";
	}
	
	private List<Story> getStories () {
	List<Story> stories = storyRepo.findAll();
		
//		Story story1 = new Story();
//		story1.setTitle("Elso Sztorim");
//		story1.setContent("<p>Na ez az adat mar eles adat.</p>");
//		story1.setPosted(new Date());
//		story1.setAuthor("Krisz");
//		
//		Story story2 = new Story();
//		story2.setTitle("Masodik Sztorim");
//		story2.setContent("<p>Gyula tortenete senkit nem rdekel.</p>");
//		story2.setPosted(new Date());
//		story2.setAuthor("Gyula");
//		
//		stories.add(story1);
//		stories.add(story2);
		
		return stories;
	}

}
