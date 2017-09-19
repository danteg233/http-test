package rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.model.Group;
import rest.model.Template;

public class CreateDraftTemplateTest extends BaseTest {

    @Test
    public void createDraftTemplate(){
        status = "DRAFT";
        RestTemplate template = new RestTemplate();
        Group[] groups = {new Group(groupName + 1), new Group(groupName + 2)};
        Template temp = new Template(templateName, capacity, companyBusinessId, locationBusinessId, status, name, groups);
        HttpEntity<Object> request = new HttpEntity<>(temp);
        ResponseEntity<Template> response = template.postForEntity(TEMPLATE_URL, request, Template.class);
        Assert.assertEquals(response.getStatusCodeValue(), 201);
    }

}
