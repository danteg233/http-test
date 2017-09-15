package rest;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Base64;

public class Application {

    private static final String LINK_TO_USERS = "https://api.github.com/users/";
    private static final String USERNAME = "danteg233";
    private static final String AUTH_LINK = "https://api.github.com/authorizations";
    private static final String DELETE_LINK = "https://api.github.com/repos/danteg233/";
    private static final String REPOSITORY_NAME = "test";
    private static final String USER_LINK = "https://api.github.com/user";
    private static final String GIST_LINK = "https://api.github.com/gists";

    private static HttpHeaders getHeaders(){
        String username_password = "danteg233@hotmail.com:";
        String base64Credentials = new String(Base64.getEncoder().encode(username_password.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    @Test
    public void logIn(){
        HttpEntity<String> request = new HttpEntity<>(getHeaders());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(USER_LINK, HttpMethod.GET, request, String.class);
        Assert.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    public void checkIsUserExist(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<GitHubUser> response = template.getForEntity(LINK_TO_USERS + USERNAME, GitHubUser.class);
        int statusCode = response.getStatusCodeValue();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void deleteRepository(){
        RestTemplate template = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(getHeaders());
        template.exchange(DELETE_LINK + REPOSITORY_NAME, HttpMethod.DELETE, request, String.class);
    }

    @Test
    public void createGist(){

    }


}
