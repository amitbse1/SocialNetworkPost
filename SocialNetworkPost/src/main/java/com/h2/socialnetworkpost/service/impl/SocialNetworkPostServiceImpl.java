package com.h2.socialnetworkpost.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.socialnetworkpost.dao.SocialNetworkPostRepository;
import com.h2.socialnetworkpost.model.SocialNetworkPost;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class SocialNetworkPostServiceImpl implements com.h2.socialnetworkpost.service.SocialNetworkPostService {

	private SocialNetworkPostRepository socialNetworkPostRepository;

	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Autowired
	public SocialNetworkPostServiceImpl(SocialNetworkPostRepository socialNetworkPostRepository,
			EntityManager entityManager) {
		super();
		this.socialNetworkPostRepository = socialNetworkPostRepository;
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public int createSocialNetworkPost(Map<String, String> sqlScript) {

		List<Object[]> resultObj = null;

		String dString = sqlScript.get("sql");

		if (dString.equals("execute")) {
			dString = "\r\n"
					+ "INSERT INTO SOCIAL_NETWORK_POST (id,post_date, post_category, author, content, view_count) VALUES\r\n"
					+ "\r\n" + "(1,'2024-01-15', 'Music', 'Alice', 'Check out my new song!', 1570),\r\n" + "\r\n"
					+ "(2,'2024-02-22', 'Gaming', 'Bob', 'Just finished an epic gaming session!', 2215),\r\n" + "\r\n"
					+ "(3,'2024-03-10', 'News', 'Charlie', 'Breaking news: Major event happening now!', 3050),\r\n"
					+ "\r\n"
					+ "(4,'2024-04-18', 'Entertainment', 'Diana', 'Top 10 movies to watch this summer.', 1725),\r\n"
					+ "\r\n" + "(5,'2024-05-05', 'Music', 'Eve', 'My concert was amazing last night!', 2850),\r\n"
					+ "\r\n" + "(6,'2024-06-23', 'Gaming', 'Frank', 'Tips and tricks for the latest game.', 2380),\r\n"
					+ "\r\n" + "(7,'2024-07-01', 'News', 'Grace', 'Election results are in.', 3190),\r\n" + "\r\n"
					+ "(8,'2024-08-14', 'Entertainment', 'Heidi', 'Best TV shows to binge-watch.', 1920),\r\n" + "\r\n"
					+ "(9,'2024-09-09', 'Music', 'Ivan', 'Album release date announced!', 2125),\r\n" + "\r\n"
					+ "(10,'2024-10-25', 'Gaming', 'Judy', 'Game review: The best and the worst.', 2480),\r\n" + "\r\n"
					+ "(11,'2024-11-11', 'News', 'Karl', 'Weather update: Severe storm approaching.', 2730),\r\n"
					+ "\r\n"
					+ "(12,'2024-12-05', 'Entertainment', 'Laura', 'Celebrity gossip: Who wore it best?', 1650),\r\n"
					+ "\r\n" + "(13,'2024-01-20', 'Music', 'Mallory', 'Join me live for a music session.', 2340),\r\n"
					+ "\r\n" + "(14,'2024-02-14', 'Gaming', 'Nina', 'Top 5 games to play this month.', 2650),\r\n"
					+ "\r\n" + "(15,'2024-03-18', 'News', 'Oscar', 'Tech news: Latest gadget reviews.', 3130),\r\n"
					+ "\r\n" + "(16,'2024-04-27', 'Entertainment', 'Paul', 'Must-see theater performances.', 1840),\r\n"
					+ "\r\n" + "(17,'2024-05-30', 'Music', 'Quinn', 'New single dropping soon!', 2910),\r\n" + "\r\n"
					+ "(18,'2024-06-15', 'Gaming', 'Rita', 'Livestreaming my gameplay now!', 2320),\r\n" + "\r\n"
					+ "(19,'2024-07-23', 'News', 'Sam', 'Local news: Community event highlights.', 2690),\r\n" + "\r\n"
					+ "(20,'2024-08-10', 'Entertainment', 'Tina', 'Behind the scenes of my latest video.', 2025);";
		}

		int hString = entityManager.createNativeQuery(dString).executeUpdate();

		return hString;

	}

	public List<SocialNetworkPost> findAllSocialNetworkPost() {
		List<SocialNetworkPost> socialNetworkPostList = (List<SocialNetworkPost>) socialNetworkPostRepository.findAll();
		List<SocialNetworkPost> SocialNetworkPostListResult = null;
		if (socialNetworkPostList != null && !socialNetworkPostList.isEmpty()) {
			SocialNetworkPostListResult = socialNetworkPostList.stream().sorted(Comparator.comparing(obj -> obj.getPostCategory())).limit(10).collect(Collectors.toList());
//					.collect(Collectors.groupingBy(SocialNetworkPost :: obj.getPostCategory()).
//					collectingAndThen(toList(), l -> l.stream().limit(10).collect(toList()))); 
			return SocialNetworkPostListResult;
		}
		return null;
	}

	@Override
	public List<SocialNetworkPost> findAllSocialPostByAuthor(String author) {
		List<SocialNetworkPost> SocialNetworkPostList = (List<SocialNetworkPost>) socialNetworkPostRepository
				.findByAuthor(author);

		if (SocialNetworkPostList != null && !SocialNetworkPostList.isEmpty()) {
			return SocialNetworkPostList;
		}
		return null;
	}

}
