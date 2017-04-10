package org.ywb.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ywb.study.entity.City;
import org.ywb.study.service.CustomerCityService;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/17
 * Time: 13:59
 */
@RestController
public class CityController {

    @Autowired
    private CustomerCityService cityService;

    @RequestMapping(value = "/getCityById/{id}", method = RequestMethod.GET)
    public City getCityById(@PathVariable("id") long id){
        return cityService.getCityById(id);
    }
}
