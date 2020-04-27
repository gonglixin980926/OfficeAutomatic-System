package com.glx.oa;

import com.glx.oa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public test(){}

//   test(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Test
    @Transactional
    public void aa() {
        this.userRepository.deleteUserEntityByUserId(2);
    }
}
