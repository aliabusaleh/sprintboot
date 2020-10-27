package com.exalt.sprintboot.search;

import com.exalt.sprintboot.model.Link;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LinkSearchRepository extends ElasticsearchRepository<Link,Long> {

    Page<Link> findByTitleLike(String title, PageRequest pageRequest);
    Page<Link> findAll();

}
