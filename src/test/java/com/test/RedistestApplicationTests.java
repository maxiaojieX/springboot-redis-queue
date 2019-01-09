package com.test;

import com.test.MAIL.MailUtil;
import com.test.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedistestApplicationTests {

	@Autowired
	private MailUtil mailUtil;
	@Test
	public void contextLoads() {

		try {
			MailUtil.sendHtmlEmail("1103173210@qq.com","aaa","GHW","<!DOCTYPE html>\n" +
					"<html>\n" +
					"  <head></head>\n" +
					"  <style>\n" +
					"    body{\n" +
					"      width: 600px;\n" +
					"    }\n" +
					"    header {\n" +
					"      width: 600px;\n" +
					"      height: 2px;\n" +
					"      background: rgba(23, 135, 221, 1);\n" +
					"    }\n" +
					"    .welcome {\n" +
					"      font-size: 14px;\n" +
					"      font-family: MicrosoftYaHei;\n" +
					"      font-weight: 400;\n" +
					"      color: rgba(51, 51, 51, 1);\n" +
					"      line-height: 36px;\n" +
					"    }\n" +
					"    .content {\n" +
					"      font-size: 24px;\n" +
					"      font-family: MicrosoftYaHei-Bold;\n" +
					"      font-weight: bold;\n" +
					"      color: rgba(51, 51, 51, 1);\n" +
					"      line-height: 36px;\n" +
					"      text-align: center\n" +
					"    }\n" +
					"    .ps {\n" +
					"      width: 600px;\n" +
					"      padding: 20px;\n" +
					"      box-sizing: border-box;\n" +
					"      background: rgba(222, 239, 252, 1);\n" +
					"    }\n" +
					"    .ps ol {\n" +
					"      font-size: 14px;\n" +
					"      font-family: MicrosoftYaHei;\n" +
					"      font-weight: 400;\n" +
					"      color: rgba(128, 128, 128, 1);\n" +
					"      line-height: 28px;\n" +
					"    }\n" +
					"  </style>\n" +
					"  <body>\n" +
					"    <header></header>\n" +
					"    <section>\n" +
					"      <span class=\"welcome\">Dear 110@qq.com,</span>\n" +
					"      <br />\n" +
					"      <span class=\"welcome\">Here's your Verification Code:</span>\n" +
					"      <p class=\"content\">1234</p>\n" +
					"    </section>\n" +
					"    <footer>\n" +
					"      <div class=\"ps\">\n" +
					"        <ol>\n" +
					"          <li>It will be valid for 60 minutes.</li>\n" +
					"          <li>Click \"Get Code\" button again if the Verification Code expires.</li>\n" +
					"          <li>Contact the Customer Service if you have any problems.</li>\n" +
					"          <li>please do not reply this mail.</li>\n" +
					"        </ol>\n" +
					"      </div>\n" +
					"    </footer>\n" +
					"  </body>\n" +
					"</html>\n");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Autowired
	private RedisUtil redisUtil;
	@Test
	public void test() {
		redisUtil.zizeng();
		System.out.println(redisUtil.get("redis_count_num").toString());
	}

}

