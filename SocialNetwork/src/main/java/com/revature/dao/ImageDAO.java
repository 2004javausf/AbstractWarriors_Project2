package com.revature.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entity.Image;

public interface ImageDAO extends JpaRepository<Image, Long>{
	
	Optional<Image> findByImage(String image);

}
