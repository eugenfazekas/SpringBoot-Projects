package com.firstproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firstproject.domain.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {

	List<Story> findAll();
	
	Story findFirstByOrderByPostedDesc();

	Story findByTitle(String title);;
	
}
