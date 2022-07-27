package com.coronas.cache.repositories

import com.coronas.cache.models.Book
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BookRepository: JpaRepository<Book, Long> {

    override fun findAll(): List<Book>
}