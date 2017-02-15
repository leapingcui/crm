package com.sh.crm.refer.service;

import com.sh.crm.refer.po.Refer;
import com.sh.crm.refer.po.ReferCondition;


import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */
public interface ReferService {

    public List<Refer> findReferByCondition(Refer refer) throws Exception;

    public List<Refer> findReferByConditions(ReferCondition referCondition) throws Exception;

    public void addRefer(Refer refer) throws Exception;

    public void updateRefer(Refer refer) throws Exception;

    public void deleteRefer(String referId) throws Exception;


}
