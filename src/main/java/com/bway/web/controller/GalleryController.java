package com.bway.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class GalleryController {

	@GetMapping("/gallery")
 public String getGallery(Model model) {
		String[] imgNames = new File("src/main/resources/static/image").list();
		model.addAttribute("imgNameList", imgNames);
	 return "Gallery";
 }
	
	@GetMapping("/upload")
	public String uploadGallery() {
		return "addGallery";
	}
	
	@PostMapping("/upload")
	public String postUpload(@RequestParam MultipartFile image, Model model) {
	    if (!image.isEmpty()) {
	        try {
	            Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/" + image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
	            model.addAttribute("message", "Upload successful");
	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addAttribute("message", "Something went wrong during upload. Please try again.");
	        }
	    } else {
	        model.addAttribute("message", "No image selected for upload.");
	    }
	    return "addGallery";
	}

}


