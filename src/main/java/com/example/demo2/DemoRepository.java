package com.example.demo2;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DemoRepository extends CrudRepository<DemoEntity, Long> {
    List<DemoEntity> findByName(String name);
}

