package com.initiallyrics.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Id;

@Repository
public interface TodoRepository extends JpaRepository<TODO, Integer>{

	public List<TODO> findByUsername(String username);
	
}
