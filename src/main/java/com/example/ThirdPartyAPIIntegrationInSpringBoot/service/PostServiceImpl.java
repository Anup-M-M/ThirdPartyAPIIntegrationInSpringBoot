package com.example.ThirdPartyAPIIntegrationInSpringBoot.service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService{

    // JSONPlaceholder is an Open Source Online Mock REST API Service and can use whenever you need some fake data.
    String baseUrl = "https://jsonplaceholder.typicode.com/";

    StringBuffer stringBuffer = new StringBuffer(baseUrl);

    String post = "/posts";

    String postById = "/posts/";

    // RestTemplate is Synchronous client to perform HTTP requests.
    // Rest Template is used to create applications that consume RESTFul Web Services.
    @Autowired
    private RestTemplate restTemplate;

    public List<Map<String, Object>> getPosts(){

        // Represents an HTTP request or response entity, consisting of headers and body
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());

        String getPostsUrl = stringBuffer.append(post).toString();

        // use the exchange() method to consume the web services for all HTTP methods.
        //val response = restTemplate.exchange(getPostsUrl, HttpMethod.GET, httpEntity, List.class);
        val response = restTemplate.exchange(getPostsUrl, HttpMethod.GET, httpEntity, List.class);

        return response.getBody();
    }

    @Override
    public Map<String, Object> getPostById(int id) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String getPostsUrl = stringBuffer.append(postById).append(id).toString();
        val response = restTemplate.exchange(getPostsUrl, HttpMethod.GET, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> insertPost(Map<String, Object> payload) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
        String getPostsUrl = stringBuffer.append(post).toString();
        val response = restTemplate.exchange(getPostsUrl, HttpMethod.POST, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> updatePost(Map<String, Object> payload, int id) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
        String getPostsUrl = stringBuffer.append(postById).append(id).toString();
        val response = restTemplate.exchange(getPostsUrl, HttpMethod.PUT, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> deletePost(int id) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(getHttpHeaders());
        String getPostsUrl = stringBuffer.append(postById).append(id).toString();
        val response = restTemplate.exchange(getPostsUrl, HttpMethod.DELETE, httpEntity, Map.class);
        return response.getBody();
    }


    //  HTTP headers are used to pass additional information between the clients and the server through the request and response header.
    private HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
