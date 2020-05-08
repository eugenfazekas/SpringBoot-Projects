package com.firstproject.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstproject.domain.Story;

@Controller
public class HomeController {
	
	private ArrayList<Story> getStories () {
		ArrayList<Story> stories = new ArrayList<Story>();
		
		Story story1 = new Story();
		story1.setTitle("Elso Sztorim");
		story1.setContent("<p>Na ez az adat mar eles adat.</p>");
		story1.setPosted(new Date());
		story1.setAuthor("Krisz");
		
		Story story2 = new Story();
		story2.setTitle("Masodik Sztorim");
		story2.setContent("<p>Gyula tortenete senkit nem rdekel.</p>");
		story2.setPosted(new Date());
		story2.setAuthor("Gyula");
		
		stories.add(story1);
		stories.add(story2);
		
		return stories;
	}

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("pageTitle", "Minden napra egy SFJ sztori");
		model.addAttribute("stories", getStories());
		return "stories";
	}
	
	
	
}
