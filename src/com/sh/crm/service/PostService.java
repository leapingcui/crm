package com.sh.crm.service;

import com.sh.crm.po.Post;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public interface PostService {

    public List<Post> findAllPost() throws Exception;
}
