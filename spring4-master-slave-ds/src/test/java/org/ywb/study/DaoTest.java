package org.ywb.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ywb.study.dao.TestMapper;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/24
 * Time: 15:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DaoTest {

    @Autowired
    private TestMapper mapper;

    @Test
    public void test(){
        User user = new User();
        user.setName("llll");
        user.setPassword("111111111");
        mapper.insert(user);

        for (int i = 0; i < 100; i++){
            System.out.println(mapper.getUser(2));
        }
    }
}
