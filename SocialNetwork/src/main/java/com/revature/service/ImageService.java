package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ImageDAO;

@Service
public class ImageService {
	
	@Autowired
	ImageDAO id;
	


}
