package com.devmanoj.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devmanoj.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>
{
	
}