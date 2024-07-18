package org.example.test._core.utils;

import lombok.Data;

@Data
public class ApiUtil<T> {

    private T body;

    public ApiUtil(T body) {

        this.body = body;
    }


    public ApiUtil(Integer status, String msg) {

        this.body = null ;
    }
}