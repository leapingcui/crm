package com.sh.crm.refer.service.impl;

import com.sh.crm.refer.mapper.ReferMapper;
import com.sh.crm.refer.po.Refer;
import com.sh.crm.refer.po.ReferCondition;
import com.sh.crm.refer.service.ReferService;
import com.sh.crm.student.po.Student;
import com.sh.crm.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/1/11.
 */
@Service("referService")
public class ReferServiceImpl implements ReferService{


    @Autowired
    private ReferMapper referMapper;

    @Override
    public List<Refer> findReferByCondition(Refer refer) throws Exception {
        return referMapper.findReferByCondition(refer);
    }

    @Override
    public void addRefer(Refer refer) throws Exception {
        refer.setReferId(UUID.randomUUID().toString());
        refer.setCreateDate(new Date());
        refer.setStatus("咨询中");

        referMapper.addRefer(refer);

    }

    @Override
    public void updateRefer(Refer refer) throws Exception {
        referMapper.updateRefer(refer);
    }

    @Override
    public List<Refer> findReferByConditions(ReferCondition referCondition) throws Exception {
        String condition = referCondition.getCondition();
        Refer refer = new Refer();
        refer.setName(condition);
        refer.setQQ(condition);
        refer.setTelephone(condition);
        return referMapper.findReferByCondition(refer);

    }

    @Override
    public void deleteRefer(String referId) throws Exception {
        referMapper.deleteRefer(referId);
    }


}
