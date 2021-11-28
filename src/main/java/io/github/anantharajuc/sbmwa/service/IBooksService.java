package io.github.anantharajuc.sbmwa.service;

import io.github.anantharajuc.sbmwa.model.BooksEntity;

public interface IBooksService {
	
	BooksEntity saveBookDetails(BooksEntity booksEntity);

	BooksEntity updateBookData(Long id, BooksEntity booksEntity);
}

