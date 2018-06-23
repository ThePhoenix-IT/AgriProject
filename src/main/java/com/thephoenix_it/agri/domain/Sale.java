package com.thephoenix_it.agri.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A sale.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_sale")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "sale")
public class Sale extends AbstractAuditingEntity implements Serializable {


    @Id
    private String id;

    @NotNull
    @Size(max = 50)
    @Field("sale_title")
    private String saleTitle;

    @Field("sale_desc")
    private String saleDesc;

    @Field("sale_price")
    private Double salePrice;

    @Field("user_id")
    private User user;

    @Field("interest_id")
    private Interest interest;

}
