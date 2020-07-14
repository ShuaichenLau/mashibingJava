package com.alice.dao;

import com.alice.entity.VisitorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
@Mapper
public interface VisitorDao {

    int add(VisitorEntity entity);

    VisitorEntity update(VisitorEntity entity);

    Collection<VisitorEntity> findByAll();

    Collection<VisitorEntity> findByCondition(Map<String, String> condtion);

    boolean deleteVisitor(int id);



}
