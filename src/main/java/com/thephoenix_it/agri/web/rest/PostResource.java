package com.thephoenix_it.agri.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.thephoenix_it.agri.domain.Post;
import com.thephoenix_it.agri.domain.User;
import com.thephoenix_it.agri.repository.PostRepository;
import com.thephoenix_it.agri.repository.search.PostSearchRepository;
import com.thephoenix_it.agri.security.AuthoritiesConstants;
import com.thephoenix_it.agri.service.PostService;
import com.thephoenix_it.agri.service.dto.PostDTO;
import com.thephoenix_it.agri.service.dto.UserDTO;
import com.thephoenix_it.agri.web.rest.errors.BadRequestAlertException;
import com.thephoenix_it.agri.web.rest.errors.EmailAlreadyUsedException;
import com.thephoenix_it.agri.web.rest.errors.LoginAlreadyUsedException;
import com.thephoenix_it.agri.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class PostResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final PostRepository postRepository;

    private final PostService postService;


    private final PostSearchRepository postSearchRepository;

    public PostResource(PostRepository postRepository, PostService postService, PostSearchRepository postSearchRepository) {

        this.postRepository = postRepository;
        this.postService = postService;
        this.postSearchRepository = postSearchRepository;
    }
    /**
     * POST  /posts  : Creates a new post.
     * <p>
     *
     * @param postDTO the post to create
     * @return the ResponseEntity with status 201 (Created) and with body the new post, or with status 400 (Bad Request) if bad post body
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/posts")
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<Post> createUser(@Valid @RequestBody PostDTO postDTO) throws URISyntaxException {
        log.debug("REST request to save Post : {}", postDTO);

        if (postDTO.getId() != null) {
            throw new BadRequestAlertException("A new post cannot already have an ID", "post", "idexists");
            // Lowercase the user login before comparing with database
        } else {
            Post newPost = postService.createPost(postDTO);
            return ResponseEntity.created(new URI("/api/posts/" + newPost.getId()))
                .headers(HeaderUtil.createAlert( "post.created", newPost.getId()))
                .body(newPost);
        }
    }

}
