package com.thephoenix_it.agri.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A post.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_post")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "post")
public class Post extends AbstractAuditingEntity implements Serializable {


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
}
