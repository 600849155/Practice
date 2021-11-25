package com.cat;

import cn.hutool.core.date.DateTime;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/11/18 11:05
 */
public class Spike {
    private static int POOL_NUM = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < POOL_NUM; i++) {
            RunnableThread thread = new RunnableThread();
            executorService.execute(thread);
        }
    }
}

/**
 * 替换 header 里的 cookies 【list接口能拿到】
 * 替换 header 里的	referer 【list接口能拿到】
 * 替换 body 里的 standardID 【list接口能拿到】
 * 替换 body 里的 code 【referer中有】
 */
class RunnableThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            DateTime now = DateTime.now();
            if (now.getHours() == 11) {
                System.out.println("===== 11点了 ！开抢！=====");
                this.sendPostToCat();
            } else {
                System.out.println("===== 还没到 11 点呢=====");
            }
        }
    }

    private void sendPostToCat() {
        String cookies = "wt=f0b74162df6dc79e3745cebeda975738; qr=m14829983000001; " +
                "uid=334776203848466432; uid=334776203848466432; code=041CrgGa16rnaC0iSnHa1bZsrx1CrgGf; " +
                "isInMiniprogram=1; whereFrom=1; acw_tc=0bccaf1d16378080464364917ed77a714bb7b077070e2b4b5086a5d7df5fa0";
        String referer = "https://mall.acewill.net/mall/spike/list/1?qrcode=m14829983000001&code=001onIFa1PuV" +
                "aC0ObmIa1RTTVp2onIFl&state=code&appid=wxb143bc2027f18732";
        String body = "{\n" +
                "    \"orderId\": null,\n" +
                "    \"products\": [\n" +
                "        {\n" +
                "            \"id\": 146626,\n" +
                "            \"standard\": [\n" +
                "                {\n" +
                "                    \"standardID\": 5716456285765632,\n" +
                "                    \"count\": 1\n" +
                "                }\n" +
                "            ],\n" +
                "            \"isVirtual\": true\n" +
                "        }\n" +
                "    ],\n" +
                "    \"person\": \"胡谦\",\n" +
                "    \"tel\": \"15016823064\",\n" +
                "    \"shippingaddress\": \"\",\n" +
                "    \"address\": \"\",\n" +
                "    \"message\": null,\n" +
                "    \"provinceId\": \"\",\n" +
                "    \"cityId\": \"\",\n" +
                "    \"countyId\": \"\",\n" +
                "    \"townId\": \"\",\n" +
                "    \"qrcode\": \"m14829983000001\",\n" +
                "    \"code\": \"001onIFa1PuVaC0ObmIa1RTTVp2onIFl\",\n" +
                "    \"state\": \"code\",\n" +
                "    \"appid\": \"wxb143bc2027f18732\"\n" +
                "}";
        String url = "https://mall.acewill.net/mall/frontend/mall/product/list";
        String response = HttpRequest
                .post(url)
                .body(body)
                .header(Header.HOST, "mall.acewill.net")
                .header(Header.COOKIE, cookies)
                .header(Header.CONTENT_TYPE, "application/json")
                .header(Header.ACCEPT_LANGUAGE, "zh-cn")
                .header(Header.USER_AGENT, "Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X)" +
                        " AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.13(0x18000d38)" +
                        " NetType/4G Language/zh_CN")
                .header(Header.REFERER, referer)
                .execute()
                .body();
        System.out.println("调用结果：" + response);
    }
}
