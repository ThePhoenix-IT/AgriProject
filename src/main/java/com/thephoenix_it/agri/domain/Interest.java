package com.thephoenix_it.agri.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A interest.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_interest")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "interest")
public class Interest extends AbstractAuditingEntity implements Serializable {


    @Id
    private String id;

    @NotNull
    @Size(max = 50)
    @Field("interest_name")
    private String interestName;

}
