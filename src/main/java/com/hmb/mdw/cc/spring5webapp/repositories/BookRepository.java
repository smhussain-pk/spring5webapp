/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmb.mdw.cc.spring5webapp.repositories;

import com.hmb.mdw.cc.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author syed.hussain
 */
public interface BookRepository extends CrudRepository<Book,Long> {
    
}
