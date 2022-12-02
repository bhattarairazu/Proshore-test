package com.proshore.task.demo;


import com.proshore.task.demo.model.Battery;
import com.proshore.task.demo.model.dto.BatteryResponseDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BatteryControllerTest  extends BatteryTest{

    @Override
    @Before
    public void setUp(){
        //initial setup operation to be performed
        super.setUp();
    }

    @Test
    public void postBatteryList() throws Exception{
        String url = "/v1/battery/save";
        //mocking the list of batteries : i.e mock data inorder to perform the operation
        List<Battery> batteries = getBatteryTestData();

        //performing mock operation
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(mapToJson(batteries))).
                andReturn();

        //getting mock status code
        int status = mvcResult.getResponse().getStatus();

        //verifying status code
        assertEquals(201,status);
        String content = mvcResult.getResponse().getContentAsString();
        Battery[] batteryList = super.mapFromJson(content,Battery[].class);
        assertTrue(batteryList.length>0);

    }

    @Test
    public void getBatteryInfoTest() throws Exception {
        String url = "/v1/battery/postcode?start=10&end=20000";
        //mocking the controller operation
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        //getting status code of the mocResult to verify
        int status = mvcResult.getResponse().getStatus();

        //verify the expected and returned status code
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        //converting string context getting as response to object : so that we can verify its response length
        BatteryResponseDto batteryResponseDto = super.mapFromJson(content,BatteryResponseDto.class);

        //response length is verified
       assertTrue(batteryResponseDto.getBatteriesName().size() > 0);
    }

}
