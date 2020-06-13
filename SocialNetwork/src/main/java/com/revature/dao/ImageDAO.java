package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Image;

@Repository
public interface ImageDAO extends JpaRepository<Image, Long>{
	
	public Image findImageByImageId(long imageId);

}
