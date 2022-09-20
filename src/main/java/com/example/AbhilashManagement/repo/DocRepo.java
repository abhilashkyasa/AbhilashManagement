package com.example.AbhilashManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.AbhilashManagement.entity.DocEntity;


public interface DocRepo extends JpaRepository<DocEntity, Integer>{

		public DocEntity findByName(String name);
		
		@Query(value = "select id, name, salary, specialist from doctor order by salary desc, name asc", nativeQuery=true)
		public List<DocEntity> findAllBySalary();

}