package com.bukulapuk.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.bukulapuk.test.model.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
