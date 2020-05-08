package com.firstproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.firstproject.domain.Story;

public interface StoryRepository extends CrudRepository<Story, Long> {

	List<Story> findAll();
	
}
