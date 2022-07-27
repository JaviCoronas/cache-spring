package com.coronas.cache.services

import com.coronas.cache.models.Book
import org.springframework.stereotype.Service
import java.util.UUID

@Service
interface BookService {
    fun getBooks(): List<Book>?
    fun getBookById(id: Long): Book?
}