package com.h2.socialnetworkpost.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.socialnetworkpost.model.SocialNetworkPost;

public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

	List<SocialNetworkPost> findByAuthor(String auther);

}
