package org.ywb.study.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.ywb.study.entity.City;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/17
 * Time: 14:05
 */
@Service
public class CustomerCityService{

    @Reference(version = "1.0.0")
    private CityService cityService;

    public City getCityById(long id) {
        return this.cityService.getCityById(id);
    }
}
