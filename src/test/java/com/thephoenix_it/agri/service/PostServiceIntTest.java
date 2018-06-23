package com.thephoenix_it.agri.service;

import com.thephoenix_it.agri.AgriProjectApp;
import com.thephoenix_it.agri.domain.Post;
import com.thephoenix_it.agri.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test class for the PostResource REST controller.
 *
 * @see PostService
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AgriProjectApp.class)
public class PostServiceIntTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    private Post post;

    @Before
    public void init() {
        postRepository.deleteAll();
    }

    @Test
    public void assertThatUserMustExistToResetPassword() {
        postRepository.save(post);
    }
}
