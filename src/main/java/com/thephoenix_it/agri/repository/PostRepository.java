package com.thephoenix_it.agri.repository;

import com.thephoenix_it.agri.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Post entity.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Page<Post> findAllByUserId(Pageable pageable, String user_id);
}
