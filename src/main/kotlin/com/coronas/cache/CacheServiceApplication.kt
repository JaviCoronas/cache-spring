package com.coronas.cache

import com.coronas.cache.models.Book
import com.coronas.cache.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import java.util.UUID

@SpringBootApplication
@EnableCaching
class CacheServiceApplication : CommandLineRunner {
	@Autowired
	lateinit var bookRepository: BookRepository

	override fun run(vararg args: String?) {
		if(bookRepository.findAll().isEmpty()) {
			bookRepository.save(Book(1L, "libro1"))
			bookRepository.save(Book(2L, "libro2"))
		}
	}
}

fun main(args: Array<String>) {
	runApplication<CacheServiceApplication>(*args)
}
