package com.hanshin.seven;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TodoListApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() {
        // Assert that the context is not null
        assertNotNull(context);
    }

}
