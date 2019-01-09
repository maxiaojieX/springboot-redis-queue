package com.test.action;

import com.test.async.SendMailService;
import com.test.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiaojie.Ma on 2018/12/27.
 */
@Controller
public class RedisTest {



    private static String aaa;

    @Value("${mail.hostName}")
    public void setAaa(String aaa) {
        RedisTest.aaa = aaa;
    }

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/add")
    @ResponseBody
    public String add(String v) {
        redisUtil.lPush(v);
        return "ok";
    }

    @GetMapping("/get")
    @ResponseBody
    public String get() {
        System.out.println(redisUtil.lPop());
        return  "ok";
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/push")
    @ResponseBody
    public String p() {

        stringRedisTemplate.convertAndSend("email_topic", "1103173210@qq.com");

        return "ok";
    }

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/thead")
    @ResponseBody
    public String thead() {
        sendMailService.sendAsync();
        return "ok";
    }

    @GetMapping("/host")
    @ResponseBody
    public String host(@RequestParam(required = true) String a2) {
        return "ok";
    }

}
