package com.ldl.handler;

import com.ldl.domain.User;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@Component
@CanalTable(value = "user")
public class UserHandler implements EntryHandler<User> {
 
    @Override
    public void insert(User user) {
        System.err.println("添加：" + user);
    }
 
    @Override
    public void update(User before, User after) {
        System.err.println("改前：" + before);
        System.err.println("改后：" + after);

    }
    @Override
    public void delete(User user) {
        System.err.println("删除：" + user);
    }
}
