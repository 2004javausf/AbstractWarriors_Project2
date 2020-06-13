package com.revature.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.revature.entity.Image;
import com.revature.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	@Autowired
	ImageService imageService;
	
	@PostMapping("/uploadimage")
	public List<String> uplaodImage(@RequestParam("picByte") MultipartFile file) throws IOException {
		 System.out.println("Original Image Byte Size - " + file.getBytes().length);
		 Image img = new Image(file.getOriginalFilename(), file.getContentType(),
				                 compressBytes(file.getBytes()));
		 this.imageService.insertImage(img);
		 List<String> rtrn = new ArrayList<String>();
		 rtrn.add("Successfully updated post img");
		 return rtrn;
	}
	
	@RequestMapping(value = "/getpostimage", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Image getImage(@RequestBody Image image) throws IOException {
	     Image retrievedImage = imageService.findImageById(image.getImageId());
	        Image img = new Image(retrievedImage.getImage(), retrievedImage.getType(),
	                decompressBytes(retrievedImage.getPicByte()));
	        return img;
	    }

	// compress the image bytes before storing it in the database
	 public static byte[] compressBytes(byte[] data) {
	        Deflater deflater = new Deflater();
	        deflater.setInput(data);
	        deflater.finish();
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	        byte[] buffer = new byte[1024];
	        while (!deflater.finished()) {
	            int count = deflater.deflate(buffer);
	            outputStream.write(buffer, 0, count);
	        }
	        try {
	            outputStream.close();
	        } catch (IOException e) {
	        }
	        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
	        return outputStream.toByteArray();
	    }
	 
	// uncompress the image bytes before returning it to the angular application
	  public static byte[] decompressBytes(byte[] data) {
	         Inflater inflater = new Inflater();
	         inflater.setInput(data);
	         ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	         byte[] buffer = new byte[1024];
	         try {
	             while (!inflater.finished()) {
	                 int count = inflater.inflate(buffer);
	                 outputStream.write(buffer, 0, count);
	             }
	             outputStream.close();
	         } catch (IOException ioe) {
	         } catch (DataFormatException e) {
	         }
	         return outputStream.toByteArray();
	     }


}
