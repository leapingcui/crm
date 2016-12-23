package com.sh.crm.mapper;

import com.sh.crm.po.Post;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public interface PostMapper {

    public List<Post> findAllPost() throws Exception;

    public Post findPostById(String postId) throws Exception;

    public List<Post> findPostByDepId(String depId) throws Exception;

    public void addPost(Post post) throws Exception;

    public void updatePost(Post post) throws Exception;

    public void deletePost(String postId) throws Exception;



}
