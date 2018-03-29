package persons.springboot;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import persons.springboot.controller.EmployeeApiController;
import persons.springboot.vo.ReturnDTO;


/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmployeeProviderApplication.class)
@WebAppConfiguration
public class EmployyeeApiTest {

    private MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(webApplicationConnect).build();
    }

    @Test
    public void testController() throws Exception {
        String uri = "/emp/queryById/12";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockMvcRequestBuilders.get("");
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        ReturnDTO dto = new ReturnDTO();
        dto.setObj(content);
        System.out.println(dto);
    }

    @Test
    public void test(){
        int a = 3;
        int b = 3;
        b = 4;
        System.out.println(a);
    }
}
