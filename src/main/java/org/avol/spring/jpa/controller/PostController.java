package org.avol.spring.jpa.controller;

import org.avol.spring.jpa.DataUtil;
import org.avol.spring.jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;

/**
 * Created by Durga on 10/26/2015.
 */

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute org.avol.spring.jpa.model.Post post) {
        Serializable id = postService.post(DataUtil.postDomain(post));
        return new ModelAndView("success", "Id", id);
    }
}
