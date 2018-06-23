package com.thephoenix_it.agri.service;

import com.thephoenix_it.agri.repository.AuthorityRepository;
import com.thephoenix_it.agri.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**
 * Service class for managing posts.
 */
@Service
public class PostService {

    private final Logger log = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;

    private final AuthorityRepository authorityRepository;

    private final CacheManager cacheManager;


    public PostService(PostRepository postRepository, AuthorityRepository authorityRepository, CacheManager cacheManager) {
        this.postRepository = postRepository;
        this.authorityRepository = authorityRepository;
        this.cacheManager = cacheManager;
    }
}
