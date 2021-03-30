package org.geektimes.rest.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class RestClientDemo {

    public static void main(String[] args) throws JsonProcessingException {
//        Client client = ClientBuilder.newClient();
//        Response response = client
//                .target("http://127.0.0.1:8080/hello/world")      // WebTarget
//                .request() // Invocation.Builder
//                .get();                                     //  Response
//
//        String content = response.readEntity(String.class);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("userName", "zige");

        Entity<Object> json = Entity.json(requestBody);

        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8089/api/user/virtualLogin")      // WebTarget
                .request() // Invocation.Builder
                .header("Content-Type", "application/json;charset=UTF-8")
                .post(json);                                   //  Response

        Map map = response.readEntity(Map.class);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(map));

    }
}
