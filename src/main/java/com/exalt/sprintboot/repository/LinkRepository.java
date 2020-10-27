package com.exalt.sprintboot.repository;

import com.exalt.sprintboot.model.Link;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface LinkRepository extends JpaRepository<Link,Long> {

    Link findByTitle(String title);
    List<Link> findAll();
    List<Link> findByTitleLike(String title);
}
