package com.h2.socialnetworkpost.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.socialnetworkpost.model.SocialNetworkPost;
import com.h2.socialnetworkpost.service.SocialNetworkPostService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:8082")
public class SocialNetworkPostController {

	
	@Autowired
	SocialNetworkPostService socialNetworkPostService;

	@PostMapping("/socialNetworkPosts")
	@CrossOrigin
	public ResponseEntity<String> saveSocialNetworkPosts(@RequestBody Map<String,String> sqlScript) {
		try {
			if (!sqlScript.isEmpty()) {
				int socialNetworkPostDetails = socialNetworkPostService.createSocialNetworkPost(sqlScript);
				return new ResponseEntity<String>(socialNetworkPostDetails +" row Created.", HttpStatus.CREATED);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("0 row Created");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("0 row Created");

	}


	@GetMapping("/socialNetworkPosts")
	@CrossOrigin
	public ResponseEntity<List<SocialNetworkPost>> findAllSocialNetworkPost() {
		try {
			List<SocialNetworkPost> socialNetworkPostList = socialNetworkPostService.findAllSocialNetworkPost();
			return new ResponseEntity<List<SocialNetworkPost>>(socialNetworkPostList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
		}

	}

	@GetMapping("/socialNetworkPosts/{auther}")
	@CrossOrigin
	public ResponseEntity<List<SocialNetworkPost>> getSocialNetworkPostByAuther(@PathVariable String auther) {
		try {
			List<SocialNetworkPost> socialNetworkPostDetails =socialNetworkPostService.findAllSocialPostByAuthor(auther);
			
			if (!socialNetworkPostDetails.isEmpty()) {
			return new ResponseEntity<List<SocialNetworkPost>>(socialNetworkPostDetails, HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
		}

	}

}