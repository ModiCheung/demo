package com.jwt.demo.helloworld.mapper;

import com.jwt.demo.helloworld.entity.ResourceNodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResNodeMapper extends JpaRepository<ResourceNodeEntity, Integer> {
}
