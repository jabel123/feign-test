package com.example.feigntest.feign;

import com.example.feigntest.human.Human;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "teams-feign", url = "localhost:8080/example/human")
public interface FeignClient
{
    @GetMapping(produces = "application/json")
    List<Human> getHumans();
}
