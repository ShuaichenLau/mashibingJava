package com.alice.service;

import com.alice.entity.VisitorEntity;

import java.util.Collection;
import java.util.Map;

/**
 * 访客登记 记录信息
 * @author liusc
 * 2020-7-14 11:38:50
 */
public interface IVisitorService {
    VisitorEntity addVisitorEntity(VisitorEntity visitorEntity);

    VisitorEntity addVisitorEntity();

    boolean deleteVisitor(int id);

    Collection<VisitorEntity> findByAllVisitor();

    Collection<VisitorEntity> findByCondition(Map<String, String> condition);
}
