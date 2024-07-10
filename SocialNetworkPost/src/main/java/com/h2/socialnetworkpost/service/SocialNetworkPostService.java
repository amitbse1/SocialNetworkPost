package com.h2.socialnetworkpost.service;

import java.util.List;
import java.util.Map;

import com.h2.socialnetworkpost.model.SocialNetworkPost;

public interface SocialNetworkPostService {
public int createSocialNetworkPost(Map<String,String> sqlScript);
	
	public List<SocialNetworkPost> findAllSocialNetworkPost() ;
	
	public List<SocialNetworkPost> findAllSocialPostByAuthor(String author);
	
	
}
