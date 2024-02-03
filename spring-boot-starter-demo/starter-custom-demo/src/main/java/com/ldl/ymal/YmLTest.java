package com.ldl.ymal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("yaml")
public class YmLTest {

    @Value("${test.value}")
    private String str;
    @Autowired
    private YamlProperties yamlProperties;

    @GetMapping("test")
    public String test()  {
        System.out.println("===" + str);
        System.out.println("===" + yamlProperties);
        return "hello";
    }

}
