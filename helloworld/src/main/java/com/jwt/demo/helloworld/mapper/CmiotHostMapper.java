package com.jwt.demo.helloworld.mapper;

import com.jwt.demo.helloworld.entity.CmiotHostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CmiotHostMapper extends JpaRepository<CmiotHostEntity,Integer> {


}
