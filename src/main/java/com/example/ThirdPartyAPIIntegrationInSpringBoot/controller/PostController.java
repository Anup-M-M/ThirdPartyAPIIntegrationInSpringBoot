package com.example.ThirdPartyAPIIntegrationInSpringBoot.controller;

import com.example.ThirdPartyAPIIntegrationInSpringBoot.service.PostService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/getPosts")
    public List<Map<String, Object>> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/getPostById/{id}")
    public Map<String, Object> getPostById(@PathVariable int id ){
        return postService.getPostById(id);
    }

    @PostMapping("/insertPost")
    public Map<String, Object> insertPost(@RequestBody Map<String, Object> payload){
        return postService.insertPost(payload);
    }

    @PutMapping("/updatePost/{id}")
    public Map<String, Object> updatePost(@RequestBody Map<String, Object> payload,@PathVariable int id){
        return postService.updatePost(payload,id);
    }

    @DeleteMapping("/deletePost/{id}")
    public Map<String, Object> deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }


}
