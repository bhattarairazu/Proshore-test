package com.proshore.task.demo;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proshore.task.demo.model.Battery;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public abstract class BatteryTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //initial web application context setup to run the test
    }
    protected String mapToJson(Object obj) throws JsonProcessingException {   // a method to map object to json
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)       // a method for mapping string to json
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    protected List<Battery> getBatteryTestData() throws IOException {
        //initlizing mock 5 datas for carrying out the test
        List<Battery> batteries = new ArrayList<>();
        String[] postcode = {"6107", "6057", "6000", "6525", "6733"};
        String[] names = {"Cannington", "Midland", "Hay Street", "Mount Adams", "Kooland Island"};
        Double[] capacity = {13500.00, 50500.00, 23500.00, 12000.00, 10000.00};
        for (int i = 0; i < 5; i++) {
            Battery battery = new Battery();
            battery.setCapacity(capacity[i]);
            battery.setName(names[i]);
            battery.setPostcode(postcode[i]);
            batteries.add(battery);
        }
        return batteries;
    }


}
