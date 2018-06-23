package com.thephoenix_it.agri.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A service rating.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_service_rating")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "service_rating")
public class ServiceRating extends AbstractAuditingEntity implements Serializable {


    @Id
    private String id;

    @NotNull
    @Field("service_rating")
    private Double service_rating;

    @Field("service_rating_comment")
    private String serviceRatingComment;

    @Field("user_id")
    private User user;

    @Field("service_id")
    private Service service;

}
