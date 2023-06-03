package org.example.controller;


import org.example.domain.Book;
import org.example.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.javascript.navig.Link;

import java.util.List;

@Controller
public class GetInfo {
    @Autowired
    private BookMapper bookMapper;
    @ResponseBody
    @RequestMapping("/getinfo")
    public List<Book> getBooks(){

        List<Book> books = bookMapper.selectList(null);
        return books;
    }


}
