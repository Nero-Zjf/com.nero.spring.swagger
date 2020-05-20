package com.nero.spring.swagger.domain;


import io.swagger.annotations.ApiModel;

@ApiModel(value = "用户对象模型")
public class User {
    private long id;
//    @ApiModelProperty(value = "name",required = true)
    private String name;
//    @ApiModelProperty(value = "age",required = true)
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"age\":" + age +
                '}';
    }
}
