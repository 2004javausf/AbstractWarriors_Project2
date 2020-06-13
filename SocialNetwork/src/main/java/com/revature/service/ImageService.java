package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ImageDAO;
import com.revature.entity.Image;

@Service
public class ImageService {
	
	@Autowired
	ImageDAO id;
	
	public Image insertImage (Image image) {
		return this.id.save(image);
	}
	
	public Image findImageById(long imageId) {
		return id.findImageByImageId(imageId);
	}


}
