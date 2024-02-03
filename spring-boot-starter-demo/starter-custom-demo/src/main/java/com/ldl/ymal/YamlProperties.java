package com.ldl.ymal;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "test.yml")
public class YamlProperties {

    private String name;

    private List<String> list;
    private List<User> users;
    private String[] urls;
    private Map<String, String> maps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "YamlProperties{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", users=" + users +
                ", urls=" + Arrays.toString(urls) +
                ", maps=" + maps +
                '}';
    }
}
