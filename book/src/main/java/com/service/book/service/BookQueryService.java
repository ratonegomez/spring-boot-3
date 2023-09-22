package com.service.book.service;

import com.service.book.model.Book;

import java.util.List;

public interface BookQueryService {

    Book getBookDetails(Integer bookId);
}
