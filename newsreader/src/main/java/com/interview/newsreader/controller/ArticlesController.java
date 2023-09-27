package com.interview.newsreader.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.interview.newsreader.dto.ArticleBundleDTO;
import com.interview.newsreader.dto.ParametersNewsAPI;
import com.interview.newsreader.service.NewsApiService;

@RestController
@RequestMapping("article")
public class ArticlesController {

    @PostMapping("/")
    public ArticleBundleDTO getArticles(@RequestBody ParametersNewsAPI parameters) {
        try {
            return NewsApiService.getArticles(parameters);
        } catch (Exception e) {
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
