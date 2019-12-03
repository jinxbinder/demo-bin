package com.bin.common.entity;

/**
 * ClassName: Demo1 <br/>
 * Description: <br/>
 * date: 2019/11/29 14:31<br/>
 * 测试demo
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
public class Demo1 {
    private int id;
    private String name;
    private String pw;

    public Demo1(int id, String name, String pw) {
        this.id = id;
        this.name = name;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}
