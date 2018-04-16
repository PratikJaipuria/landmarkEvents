package edu.northeastern.cs5200.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/")
public class TestController {

	@GetMapping( value = {"" , "/"})
    public Iterable<TestModel> listTasks(){
        List<TestModel> list = new ArrayList<>();
        
        list.add(new TestModel("hello","efecef","cefce"));
        list.add(new TestModel("sdcsdc","fevfdv","sfcsdfc"));
		return list;
		
//		final String uri = "http://api.eventful.com/json/events/search?app_key=4WfzV49BJWfGstmT&keywords=music&location=San+Diego";
//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(uri, String.class);
//	    System.out.println(result);
    }

}
