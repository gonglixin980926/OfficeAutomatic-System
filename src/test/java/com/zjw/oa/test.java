package com.zjw.oa;

import com.zjw.oa.repository.UserRepository;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    test(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void aa() {
        logger.info("{}",this.userRepository.findUserEntityByUserId(3));
    }
}
