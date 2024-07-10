package com.h2.socialnetworkpost.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "social_network_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialNetworkPost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date postDate;
	private String postCategory; // can be Music/Gaming/News/Entertainment
	private String author;
	private String content;
	private Long viewCount;
}