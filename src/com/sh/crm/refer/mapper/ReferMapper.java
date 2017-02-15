package com.sh.crm.refer.mapper;

import com.sh.crm.refer.po.Refer;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */
public interface ReferMapper {

    public List<Refer> findReferByCondition(Refer refer) throws Exception;

    public void addRefer(Refer refer) throws Exception;

    public void updateRefer(Refer refer) throws Exception;

    public void deleteRefer(String referId) throws Exception;
}
