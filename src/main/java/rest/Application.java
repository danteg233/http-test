package rest;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import rest.model.File;
import rest.model.Gist;
import rest.model.GitHubUser;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class Application {

    private static final String LINK_TO_USERS = "https://api.github.com/users/";
    private static final String AUTH_LINK = "https://api.github.com/authorizations";
    private static final String DELETE_LINK = "https://api.github.com/repos/";
    private static final String USER_LINK = "https://api.github.com/user";
    private static final String GIST_LINK = "https://api.github.com/gists";

    private static HttpHeaders getHeaders(String userName, String pass){
        String username_password = userName + ":" + pass;
        String base64Credentials = new String(Base64.getEncoder().encode(username_password.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

//    @Test
//    @Parameters({"userName", "pass"})
//    public void logIn(String userName, String pass){
//        HttpEntity<String> request = new HttpEntity<>(getHeaders(userName, pass));
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange(USER_LINK, HttpMethod.GET, request, String.class);
//        Assert.assertEquals(response.getStatusCodeValue(), 200);
//    }

//    @Test
//    @Parameters("userName")
//    public void checkIsUserExist(String userName){
//        RestTemplate template = new RestTemplate();
//        ResponseEntity<GitHubUser> response = template.getForEntity(LINK_TO_USERS + userName, GitHubUser.class);
//        int statusCode = response.getStatusCodeValue();
//        Assert.assertEquals(statusCode, 200);
//    }

//    @Test
//    @Parameters({"userName", "pass", "repositoryName"})
//    public void deleteRepository(String userName, String pass, String repositoryName){
//        RestTemplate template = new RestTemplate();
//        HttpEntity<String> request = new HttpEntity<>(getHeaders(userName, pass));
//        template.exchange(DELETE_LINK + userName + '/' + repositoryName, HttpMethod.DELETE, request, String.class);
//        //TODO : ASSERT
//    }

    @Test
    @Parameters({"userName", "pass", "description", "isPublic", "files", "content"})
    public void createGist(String userName, String pass, String description, boolean isPublic, String files, String content){
        List<File> filesForGit = new ArrayList();
        RestTemplate template = new RestTemplate();
        String[] _files = files.split("[\\,]");
        for (int i = 0; i < _files.length; i++){
            filesForGit.add(new File(_files[i], content));
        }
        File[] actualFiles = new File[filesForGit.size()];
        actualFiles = filesForGit.toArray(actualFiles);

        Gist gist = new Gist(description, isPublic, actualFiles);

        HttpEntity<Object> request = new HttpEntity<>(gist, getHeaders(userName, pass));
        ResponseEntity response = template.postForEntity(GIST_LINK, request, Gist.class);
        Assert.assertEquals(response.getStatusCodeValue(), 201);

    }


}
