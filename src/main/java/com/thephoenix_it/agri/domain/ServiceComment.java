package com.thephoenix_it.agri.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A service comment.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_service_comment")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "service_comment")
public class ServiceComment extends AbstractAuditingEntity implements Serializable {


    @Id
    private String id;

    @NotNull
    @Field("service_comment")
    private String serviceComment;

    @Field("user_id")
    private User user;

    @Field("service_id")
    private Service service;
}
