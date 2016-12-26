package com.sh.crm.hr.controller;

import com.sh.crm.hr.po.Department;
import com.sh.crm.hr.po.Post;
import com.sh.crm.hr.service.DepartmentService;
import com.sh.crm.hr.service.PostService;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;


/**
 * Created by Administrator on 2016/12/19.
 */
@Controller
public class PostController {
    private static Logger logger = Logger.getLogger(PostController.class);

    @Autowired
    private PostService postService;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/findAllPost.action")
    public ModelAndView findAllPost() {
        ModelAndView modelAndView = new ModelAndView();
        List<Post> posts = null;
        try {
            posts = postService.findAllPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(posts);
        modelAndView.addObject("posts", posts);
        modelAndView.setViewName("/post/listPost");
        return modelAndView;
    }

    /**
     * 添加职务之前，需要查找所有的部门信息
     * @return
     */
    @RequestMapping("/editPostBeforeAdd.action")
    public ModelAndView editPostBeforeAdd() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Department> departmentList = departmentService.findAllDepartment();
            modelAndView.addObject("departmentList", departmentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/post/addPost");
        return modelAndView;
    }
    @RequestMapping("/addPost.action")
    public ModelAndView addPost(Post post) {

        post.setPostId(UUID.randomUUID().toString());
        logger.debug("添加职务" + post.toString());
        try {
            postService.addPost(post);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findAllPost();
    }
    @RequestMapping("/editPostBeforeUpdate.action")
    public ModelAndView editPostBeforeUpdate(String postId) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Post post = postService.findPostById(postId);
            modelAndView.addObject("post", post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/post/editPost");

        return modelAndView;
    }
    @RequestMapping("/updatePost.action")
    public ModelAndView updatePost(Post post) {

        try {
            postService.updatePost(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findAllPost();
    }
}
