package org.community.post.repository.entity.post;

import jakarta.persistence.AttributeConverter;
import org.community.post.domain.content.PostPublicationState;

public class PostPublicationStateConverter implements AttributeConverter<PostPublicationState,String> {
    @Override
    public String convertToDatabaseColumn(PostPublicationState state) {
        return state.name();
    }

    @Override
    public PostPublicationState convertToEntityAttribute(String s) {
        return PostPublicationState.valueOf(s);
    }
}
