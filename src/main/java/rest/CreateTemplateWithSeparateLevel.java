package rest;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.model.GroupWithSeparateLevel;
import rest.model.Template;

public class CreateTemplateWithSeparateLevel extends BaseTest {

    @Test
    public void createTemplateWithSeparateLevel(){
        status = "DRAFT";
        RestTemplate template = new RestTemplate();
        GroupWithSeparateLevel[] groups = {new GroupWithSeparateLevel(groupName, startTime)};
        Template temp = new Template(templateName, capacity, companyBusinessId, locationBusinessId, status, name, groups);
        HttpEntity<Object> request = new HttpEntity<>(temp);
        int resultCode = template.postForEntity(TEMPLATE_URL, request, Template.class).getStatusCodeValue();
        Assert.assertEquals(resultCode, 201);
    }

}
