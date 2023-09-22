package com.service.book.model;

import com.service.book.model.common.Id;

import static org.springframework.util.Assert.notNull;

public record Book(BookId id, String title, long pageCount, Author author) {
    public static final Book UNKNOWN=new Book(null,null,0L,null);

    public static record BookId(Integer id) implements Id<Integer>{
        public BookId{
            notNull(id,"id should not be null");
        }

        public static BookId of(int id){
            return new BookId(id);
        }
    }
}
