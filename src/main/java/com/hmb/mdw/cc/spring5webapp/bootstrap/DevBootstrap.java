/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmb.mdw.cc.spring5webapp.bootstrap;

import com.hmb.mdw.cc.spring5webapp.model.Author;
import com.hmb.mdw.cc.spring5webapp.model.Book;
import com.hmb.mdw.cc.spring5webapp.model.Publisher;
import com.hmb.mdw.cc.spring5webapp.repositories.AuthorRepository;
import com.hmb.mdw.cc.spring5webapp.repositories.BookRepository;
import com.hmb.mdw.cc.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author syed.hussain
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        initData();
    }    
    
    private void initData(){
        Publisher printer = new Publisher("WROX");
        publisherRepository.save(printer);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","1234","Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPrinter(printer);
        
        authorRepository.save(eric);
        bookRepository.save(ddd);
        
        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development without EJB", "233333", "Wrox");
        noEJB.setPrinter(printer);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        
    }
}
