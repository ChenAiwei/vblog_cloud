package com.cloud.vblog.auth.feign;

import com.cloud.vblog.auth.AuthApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author：chenaiwei
 * @Description：AuthFeignClients
 * @CreateDate：2020/4/2 15:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AuthApp.class })
@Slf4j
public class BaseAuthFeign {
}
