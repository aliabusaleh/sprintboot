package com.exalt.sprintboot.controller;


import com.exalt.sprintboot.model.Link;
import com.exalt.sprintboot.search.LinkSearchRepository;
import com.exalt.sprintboot.service.LinkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ElasticController {
    LinkService linkService;
    LinkSearchRepository linkSearch;

    public ElasticController(LinkService linkService, LinkSearchRepository linkSearch) {
        this.linkService = linkService;
        this.linkSearch = linkSearch;
    }
/*
    *//* private LinkRepository linkElasticsearchRepositry;

            public ElasticController(LinkRepository linkElasticsearchRepositry) {
                this.linkElasticsearchRepositry = linkElasticsearchRepositry;
            }
        */
          @GetMapping("/elastic/find/{title}")
      Page<Link> findElastic(@PathVariable String title){
          return linkSearch.findByTitleLike(title, PageRequest.of(0,10));
      }
    @GetMapping("/elastic/findall")
    Page<Link> findElasticAll(){
        System.out.println("------------------ Outout ------------");
        Page<Link> links = linkSearch.findAll();
        return linkSearch.findAll();
    }
}
