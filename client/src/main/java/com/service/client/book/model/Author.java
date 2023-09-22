package com.service.client.book.model;


import com.service.client.book.model.common.Id;

import static org.springframework.util.Assert.notNull;

public record Author(AuthorId id, String firstName, String lastName) {

    public static record AuthorId(String id)implements Id<String> {
        public AuthorId{
            notNull(id,"id should not be null");
        }

        public static AuthorId of(String id){
            return new AuthorId(id);
        }
    }
}
