package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.StudentEntity;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Long> {

}
