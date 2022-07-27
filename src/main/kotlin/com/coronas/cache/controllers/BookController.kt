package com.coronas.cache.controllers

import com.coronas.cache.models.Book
import com.coronas.cache.services.BookService
import org.springframework.data.repository.query.Param
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@Controller
class BookController(
    val service: BookService
) {

    @GetMapping("/books")
    fun getBooks() : ResponseEntity<List<Book>> {
        return ResponseEntity.ok(service.getBooks())
    }

    @GetMapping("/books/{id}")
    fun getBookById(@PathVariable id: Long): ResponseEntity<Book>{
        return  ResponseEntity.ok(service.getBookById(id))
    }
}