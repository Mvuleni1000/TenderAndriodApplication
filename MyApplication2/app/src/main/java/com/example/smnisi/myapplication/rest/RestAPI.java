package com.example.smnisi.myapplication.rest;

import java.util.List;

/**
 * Created by smnisi on 2015/09/25.
 */
public interface RestAPI <S, ID>{

    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
