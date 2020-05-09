package com.firstproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firstproject.domain.Blogger;

@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {

	List<Blogger> findAll();
	
}
