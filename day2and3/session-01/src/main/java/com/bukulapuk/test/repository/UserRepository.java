package com.bukulapuk.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bukulapuk.test.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByEmail(String email);
	
	@Query(value="SELECT * FROM `user` limit ?1 OFFSET ?2",nativeQuery = true)
	List<User> getUserByLimit(int limit,int offset);
}
