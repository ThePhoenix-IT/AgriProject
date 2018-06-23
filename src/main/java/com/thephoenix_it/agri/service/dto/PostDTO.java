package com.thephoenix_it.agri.service.dto;

import com.thephoenix_it.agri.domain.Post;
import com.thephoenix_it.agri.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO representing a post.
 */
public class PostDTO {


    @Id
    private String id;

    @NotNull
    @Size(max = 50)
    @Field("post_name")
    private String postName;

    @Field("post_desc")
    private String postDesc;

    @Field("user_id")
    private User user;

    public PostDTO(Post post) {
    }

    public String getId() {
        return id;
    }
}
