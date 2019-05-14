package test.pivotal.hw.hackerapi;

import io.pivotal.hw.hackertracker.HackerAPIController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


public class HackerApiTest {
//    @Test
//    public void apiGetListTest() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String[] getListPage = restTemplate.getForObject(url("/10"), String[].class);
//
//        assertThat(Arrays.asList(getListPage),  hasSize(10));
//    }
//
//    @Test
//    public void apiGetItemtest() {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String[] getItemPage = restTemplate.getForObject(url("/item/19899373"), String[].class);
//
//        assertThat(Arrays.asList(getItemPage), hasSize(2));
//    }
//
//    private String url(String path) {
//        String baseUrl = "http://localhost:8080/";
//        String envUrl = System.getenv("HACKER_TRACKER_URL");
//
//        if (envUrl != null && !envUrl.isEmpty()) {
//            baseUrl = envUrl;
//        }
//
//        return baseUrl + path;
//    }
}
