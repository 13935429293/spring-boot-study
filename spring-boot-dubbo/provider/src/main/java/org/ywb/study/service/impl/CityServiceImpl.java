package org.ywb.study.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.ywb.study.entity.City;
import org.ywb.study.service.CityService;

/**
 * User: yangwenbiao
 * Date: 2017/3/17
 * Time: 13:43
 */
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {

    @Override
    public City getCityById(long id) {
        return new City(id, "测试城市", "这个是一个测试城市");
    }
}
