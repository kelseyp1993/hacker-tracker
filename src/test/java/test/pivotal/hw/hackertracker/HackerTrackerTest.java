package test.pivotal.hw.hackertracker;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class HackerTrackerTest {
//    @Test
//    public void smokeTest() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String homePage = restTemplate.getForObject(url("/"), String.class);
//
//        assertThat(homePage, containsString("Top Hacker News Stories"));
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
