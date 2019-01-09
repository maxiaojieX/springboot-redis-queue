package com.test.queue.listener;

import org.springframework.stereotype.Component;

/**
 * Created by xiaojie.Ma on 2018/12/27.
 */
@Component
public class EmailReceiver {

    public void receiveMessage(String message) {
        System.out.println("收到发送邮件队列消息>>"+message);
    }

}
