# Proyecto Uso Cache en Spring

## Introducción
Proyecto básico que implementa la cache en Springboot.


## Implementación
### Capa de Servicio

```
    @Cacheable("books")
    override fun getBooks(): List<Book>? {
         println("Service layer. getBooks")
         Thread.sleep(2000L)
         return repo.findAll()
    }
```

```
    @Cacheable("book", key = "#id")
    override fun getBookById(id: Long): Book? {
        println("Service layer. getBookById")
        Thread.sleep(2000L)
        return repo.findById(id).orElseGet(null)
    }
```

### Configuración en clase principal

```
@SpringBootApplication
@EnableCaching
class CacheServiceApplication : CommandLineRunner {
      ......
}
```