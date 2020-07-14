package com.alice.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.alice.dao.VisitorDao;
import com.alice.entity.VisitorEntity;
import com.alice.service.IVisitorService;
import com.alice.utils.RandomValue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Service
public class VisitorServiceImpl implements IVisitorService {

    public Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public VisitorEntity addVisitorEntity(VisitorEntity inputClientEntity) {
        return null;
    }

    @Override
    public VisitorEntity addVisitorEntity() {
        VisitorEntity visitorEntity = new VisitorEntity();
        Map address = RandomValue.getAddress();
        visitorEntity.setName(address.get("name").toString());
        visitorEntity.setAddress(address.get("road").toString());
        visitorEntity.setPhoneNumber(address.get("tel").toString());
        visitorEntity.setVisitorStartTime(new Date());
        visitorEntity.setVisitorEndTime(new Date());
        visitorEntity.setAge(RandomUtil.randomInt(1, 100));
        visitorDao.add(visitorEntity);
        return visitorEntity;
    }

    @Override
    public boolean deleteVisitor(int id) {
        return visitorDao.deleteVisitor(id);
    }

    @Override
    public Collection<VisitorEntity> findByAllVisitor() {
        return visitorDao.findByAll();
    }

    @Override
    public Collection<VisitorEntity> findByCondition(VisitorEntity condition) {
        return visitorDao.findByCondition(condition);
    }
}
