package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Image;


@Repository
public interface ImageDAO extends CrudRepository<Image, String>, JpaRepository<Image, String>{
	
	@SuppressWarnings("unchecked")
	public Image save(Image image);
}
