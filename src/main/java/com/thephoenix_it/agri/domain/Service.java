package com.thephoenix_it.agri.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A service.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_service")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "service")
public class Service extends AbstractAuditingEntity implements Serializable {


    @Id
    private String id;

    @NotNull
    @Size(max = 50)
    @Field("service_title")
    private String serviceTilte;

    @Field("service_desc")
    private String serviceDesc;

    @Field("service_price")
    private Double servicePrice;

    @Field("user_id")
    private User user;
}
