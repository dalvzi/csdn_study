package com.ldl.controller;


import com.ldl.annotation.Log;
import com.ldl.bean.OperType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Async
    @GetMapping("test")
//    @Log(title = "测试", type = OperType.GET)
    public String test() throws InterruptedException {
        Thread.sleep(20 * 1000);
        System.out.println("正文");
        return "hello";
    }

    @Async("asyncPoolTaskExecutor")
    @GetMapping("test1")
    public String test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(20 * 1000);
        System.out.println("正文");
        return "hello";
    }


}
