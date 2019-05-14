package io.pivotal.hw.hackertracker;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.expression.Lists;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@RestController
public class HackerAPIController {

    private static String HACKER_URL = "https://hacker-news.firebaseio.com/v0";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ids/{length}")
    public List<Integer> hackerTrackerForm(@PathVariable int length){
        ParameterizedTypeReference<List<Integer>> listOfIntegerTypeRef = new ParameterizedTypeReference<List<Integer>>() {};

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        List<Integer> ids = restTemplate
                .exchange(HACKER_URL + "/topstories.json", GET, entity, listOfIntegerTypeRef)
                .getBody();

        return ids.subList(0,length);
    }

    @GetMapping("/item/{id}")
    public HackerItem hackerItemInfo(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(HACKER_URL + "/item/" + id + ".json", GET, null, String.class);

        HackerItem hackerItem = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            hackerItem = objectMapper.readValue(response.getBody(), HackerItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hackerItem;
    }
}
