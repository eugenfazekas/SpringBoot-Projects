package com.firstproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.firstproject.domain.Blogger;
import com.firstproject.domain.Story;

public interface BloggerRepository extends CrudRepository<Blogger, Long> {

	List<Blogger> findAll();
	
}
