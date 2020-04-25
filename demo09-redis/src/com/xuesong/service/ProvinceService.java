package com.xuesong.service;

import com.xuesong.domain.Province;

import java.util.List;

/**
 * @author : Snow
 * @date : 2020/4/23
 */
public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
