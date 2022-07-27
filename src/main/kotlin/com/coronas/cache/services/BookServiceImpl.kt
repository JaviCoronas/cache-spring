package com.coronas.cache.services

import com.coronas.cache.models.Book
import com.coronas.cache.repositories.BookRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookServiceImpl(
    val repo: BookRepository
): BookService {

    @Cacheable("books")
    override fun getBooks(): List<Book>? {
        println("Service layer. getBooks")
        Thread.sleep(2000L)
        return repo.findAll()
    }

    @Cacheable("book", key = "#id")
    override fun getBookById(id: Long): Book? {
        println("Service layer. getBookById")
        Thread.sleep(2000L)
        return repo.findById(id).orElseGet(null)
    }

}