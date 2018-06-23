package com.thephoenix_it.agri.service;

import com.thephoenix_it.agri.config.Constants;
import com.thephoenix_it.agri.domain.Authority;
import com.thephoenix_it.agri.domain.Post;
import com.thephoenix_it.agri.domain.User;
import com.thephoenix_it.agri.repository.AuthorityRepository;
import com.thephoenix_it.agri.repository.PostRepository;
import com.thephoenix_it.agri.repository.UserRepository;
import com.thephoenix_it.agri.repository.search.PostSearchRepository;
import com.thephoenix_it.agri.repository.search.UserSearchRepository;
import com.thephoenix_it.agri.service.dto.PostDTO;
import com.thephoenix_it.agri.service.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service class for managing posts.
 */
@Service
public class PostService {

    private final Logger log = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;

    private final AuthorityRepository authorityRepository;

    private final PostSearchRepository postSearchRepository;

    private final CacheManager cacheManager;


    public PostService(PostRepository postRepository, AuthorityRepository authorityRepository, PostSearchRepository postSearchRepository, CacheManager cacheManager) {
        this.postRepository = postRepository;
        this.authorityRepository = authorityRepository;
        this.postSearchRepository = postSearchRepository;
        this.cacheManager = cacheManager;
    }

    public Post createPost(PostDTO postDTO) {
        Post post = new Post();
        postRepository.save(post);
        postSearchRepository.save(post);
        log.debug("Created Information for Post: {}", post);
        return post;
    }
}
