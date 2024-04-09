package com.rest.api.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rest.api.restapi.Entities.Books;

@Component
public class BookServices {

    private static List<Books> list= new ArrayList<>();

    static{
        list.add(new Books(102,"python","lmn"));
        list.add(new Books(103, "java developer", "james gosline"));
        list.add(new Books(104, "node js", "vision"));
    }
    

    //get all book
    public List<Books> getAllBooks(){
        return list;
    }

    //get single book
    public Books getBookById(int id)
    {
         Books book = null;
         try{
        book = list.stream().filter(e->e.getId() == id).findFirst().get();
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
          return book;
    }


    //Adding book
    public Books addBook(Books b)
    {
        list.add(b);
        return b;
    }

    //Deleting book

    public void deleteBook(int bid)
    {
        // list.stream().filter(book->
        // {
        //     if(book.getId()!=bid)
        //     {
        //         return true;
        //     }
        //     else{
        //         return false;
        //     }
        // }).collect(Collectors.toList());

        //or
        list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }

    //update book

    public void updateBook(Books book, int bookId)
    {
       list = list.stream().map(b->
        {
            if(b.getId()==bookId)
            {
                b.setName(book.getName());
                b.setAuther(book.getAuther());
            }
            return book;
        }).collect(Collectors.toList());
    }
}
