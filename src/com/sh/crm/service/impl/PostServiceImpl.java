package com.sh.crm.service.impl;

import com.sh.crm.mapper.PostMapper;
import com.sh.crm.po.Post;
import com.sh.crm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Override
    public List<Post> findAllPost() {

        try {
            return postMapper.findAllPost();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
