package com.exalt.sprintboot.service;


import com.exalt.sprintboot.model.Link;
import com.exalt.sprintboot.repository.LinkRepository;
import com.exalt.sprintboot.search.LinkSearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {
private final LinkSearchRepository linkSearchRepository;
private final LinkRepository linkRepository;

    public LinkService(LinkSearchRepository linkSearchRepository, LinkRepository linkRepository) {
        this.linkSearchRepository = linkSearchRepository;
        this.linkRepository = linkRepository;
    }

    public List<Link> findAll(){
       return (List<Link>) linkRepository.findAll();
    }
    public Optional<Link> findById(long id){
        return  linkRepository.findById(id);
    }

    public Link save(Link link){
        return linkRepository.save(link);
    }
    public void delete(Link link){  linkRepository.delete(link);}
    public Page<Link> findByTitleLike(String title, PageRequest pageRequest){return  linkSearchRepository.findByTitleLike(title,pageRequest);}
}
