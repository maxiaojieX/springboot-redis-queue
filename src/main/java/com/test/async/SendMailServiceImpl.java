package com.test.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by xiaojie.Ma on 2018/12/27.
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Override
    @Async("asyncServiceExecutor")
    public void sendAsync(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("执行发送邮件。。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
