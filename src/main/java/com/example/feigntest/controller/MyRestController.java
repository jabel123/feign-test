package com.example.feigntest.controller;

import com.example.feigntest.feign.FeignClient;
import com.example.feigntest.human.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyRestController
{
    private final FeignClient feignClient;

    @Autowired
    public MyRestController(FeignClient feignClient)
    {
        this.feignClient = feignClient;
    }

    @GetMapping("/example/human")
    public List<Human> getHuman()
    {
        return Arrays.asList(
            Human.builder().name("주현태").age(31).sex("남").build(),
            Human.builder().name("주동혁").age(29).sex("남").build(),
            Human.builder().name("고요한").age(32).sex("남").build(),
            Human.builder().name("여자1").age(20).sex("여").build(),
            Human.builder().name("여자2").age(25).sex("여").build(),
            Human.builder().name("여자3").age(30).sex("여").build()
        );
    }

    @GetMapping("/example/feign")
    public List<Human> getFeign()
    {
        List<Human> humans= feignClient.getHumans();

        humans.stream().forEach(m->m.setAge(100));
        return humans;

    }
}
