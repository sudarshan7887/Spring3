        package com.rest.api.restapi.TestController;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.restapi.Entities.Books;
import com.rest.api.restapi.services.BookServices;

@RestController
public class BookController {

    @Autowired
    private BookServices services;
    // @RequestMapping(value ="/books" , method = RequestMethod.GET)



    //return all books
    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks()
    {
       List<Books> list = this.services.getAllBooks();
       if(list.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.of(Optional.of(list));
    }  



    //return single books
    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBook(@PathVariable("id") int id)
    {
        Books book = this.services.getBookById(id);
        if(book==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
        
    }

    //Post Mapping add book
    @PostMapping("/books")
    public ResponseEntity<Books> addBooks(@RequestBody Books book)
    {
         Books b = null;
        try{
             b =  this.services.addBook(book);
             return ResponseEntity.of(Optional.of(book));
            } 
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }


    //Delete book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deBook(@PathVariable("id") int bid)
    {
        try{
        this.services.deleteBook(bid);
        return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    //update book

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Books> updateBook(@RequestBody Books book, @PathVariable("bookId") int bookId)
    {
        try{
                this.services.updateBook(book ,bookId);
                return ResponseEntity.ok().body(book);
        }
        catch(Exception e){ 
            e.printStackTrace();
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
