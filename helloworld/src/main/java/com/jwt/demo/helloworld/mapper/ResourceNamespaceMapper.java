package com.jwt.demo.helloworld.mapper;

import com.jwt.demo.helloworld.entity.ResourceNamespaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceNamespaceMapper extends JpaRepository<ResourceNamespaceEntity, Integer> {
}
