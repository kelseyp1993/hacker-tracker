package io.pivotal.hw.hackertracker;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HackerTrackerController {

    private static final int LIST_COUNT = 10;

    @GetMapping("/{length}")
    public String hackerTrackerForm(Model model, @PathVariable int length){
        final String uri = "http://localhost:8080";

        RestTemplate restTemplate = new RestTemplate();
        List<Integer> idList = restTemplate.getForObject(uri + "/ids/" + length, List.class);

        List<HackerItem> itemList = new ArrayList<>();

        for (Integer currentId : idList){
            itemList.add(restTemplate.getForObject(uri + "/item/" + currentId, HackerItem.class));
        }

        model.addAttribute("itemList", itemList);

        return "index";
    }


}
