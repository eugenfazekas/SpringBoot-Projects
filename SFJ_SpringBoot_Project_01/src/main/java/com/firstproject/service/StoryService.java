package com.firstproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.firstproject.domain.Story;
import com.firstproject.repository.StoryRepository;

@Service
public class StoryService {

	private StoryRepository storyRepo;
 
	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}

	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	public Story getStory() {
		return storyRepo.findFirstByOrderByPostedDesc();
	}
	
	

	public Story getSpecificStory(String title) {
		
		return storyRepo.findByTitle(title);
	}	
	
}
//	private BloggerRepository bloggerRepo;
//	
//	@Autowired
//	public void setBloggerRepo(BloggerRepository bloggerRepo) {
//		this.bloggerRepo = bloggerRepo;
//	}
	
//	@PostConstruct
//	public void init() {
//		Blogger blogger = new Blogger("Belso Gyula", 25);
//		bloggerRepo.save(blogger);
//		Story story = new Story("Belso Cim", "Belso tartalom",new Date(),blogger);
//		storyRepo.save(story);
//	}


