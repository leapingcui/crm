package com.sh.crm.controller;

import com.sh.crm.po.Post;
import com.sh.crm.service.PostService;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by Administrator on 2016/12/19.
 */
@Controller
public class PostController {
    private static Logger logger = Logger.getLogger(PostController.class);

    @Autowired
    private PostService postService;
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
}
