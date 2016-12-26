package com.sh.crm.hr.service.impl;

import com.sh.crm.hr.po.Post;
import com.sh.crm.hr.mapper.PostMapper;
import com.sh.crm.hr.service.PostService;
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

    @Override
    public List<Post> findPostByDepId(String depId) throws Exception {
        return postMapper.findPostByDepId(depId);
    }

    @Override
    public Post findPostById(String postId) throws Exception {
        return postMapper.findPostById(postId);
    }

    @Override
    public void addPost(Post post) throws Exception {
        postMapper.addPost(post);
    }

    @Override
    public void updatePost(Post post) throws Exception {
        postMapper.updatePost(post);

    }
}
