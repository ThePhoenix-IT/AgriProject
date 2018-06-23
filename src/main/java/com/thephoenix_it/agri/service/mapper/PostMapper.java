package com.thephoenix_it.agri.service.mapper;

import com.thephoenix_it.agri.domain.Authority;
import com.thephoenix_it.agri.domain.Post;
import com.thephoenix_it.agri.domain.User;
import com.thephoenix_it.agri.service.dto.PostDTO;
import com.thephoenix_it.agri.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity User and its DTO called UserDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class PostMapper {

    public PostDTO postToPostDTO(Post post) {
        return new PostDTO(post);
    }

    public List<PostDTO> usersToUserDTOs(List<Post> posts) {
        return posts.stream()
            .filter(Objects::nonNull)
            .map(this::postToPostDTO)
            .collect(Collectors.toList());
    }

    public Post postDTOToPost(PostDTO postDTO) {
        if (postDTO == null) {
            return null;
        } else {
            Post post = new Post();
            return post;
        }
    }
}
