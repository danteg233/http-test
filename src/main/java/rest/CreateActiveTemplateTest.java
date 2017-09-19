package rest;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.model.Group;
import rest.model.Level;
import rest.model.Template;

public class CreateActiveTemplateTest extends BaseTest {

    @Test
    public void createActiveTemplate(){
        status = "ACTIVE";
        RestTemplate template = new RestTemplate();
        Level[] levels = {new Level(levelName, startTime)};
        Group[] groups = {new Group(groupName, levels)};
        Template temp = new Template(templateName, capacity, companyBusinessId, locationBusinessId, status, name, groups);
        HttpEntity<Object> request = new HttpEntity<>(temp);
        int resultCode = template.postForEntity(TEMPLATE_URL, request, Template.class).getStatusCodeValue();
        Assert.assertEquals(resultCode, 201);
    }

}
