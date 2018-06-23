package com.thephoenix_it.agri.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A post comment.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_post_comment")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "post_comment")
public class PostComment extends AbstractAuditingEntity implements Serializable {


    @Id
    private String id;

    @NotNull
    @Field("post_comment")
    private String postComment;

    @Field("user_id")
    private User user;

    @Field("post_id")
    private Post post;
}
