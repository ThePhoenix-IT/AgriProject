package com.thephoenix_it.agri.repository.search;

import com.thephoenix_it.agri.domain.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Post entity.
 */
public interface PostSearchRepository extends ElasticsearchRepository<Post, String> {
}
