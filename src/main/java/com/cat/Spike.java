package com.cat;

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
    private static int POOL_NUM = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < POOL_NUM; i++) {
            RunnableThread thread = new RunnableThread();
            executorService.execute(thread);
        }
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
            String cookies = "wt=8d92b06905296f32e7e7315a0622a761; qr=m14829983000001;" +
                    " acw_tc=0bcb2f1916372038952897393e7e84e98ff461c88290aee020632848e55a18";
            String referer="https://mall.acewill.net/mall/spike/list/1?qrcode=m14829983000001&code=" +
                    "073inKkl22Ua884DM9nl2jRa5X0inKku&state=code&appid=wxb143bc2027f18732";
            String body = "{\n" +
                    "    \"orderId\": null,\n" +
                    "    \"products\": [\n" +
                    "        {\n" +
                    "            \"id\": 146626,\n" +
                    "            \"standard\": [\n" +
                    "                {\n" +
                    "                    \"standardID\": 5706254337228800,\n" +
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
                    "    \"code\": \"073inKkl22Ua884DM9nl2jRa5X0inKku\",\n" +
                    "    \"state\": \"code\",\n" +
                    "    \"appid\": \"wxb143bc2027f18732\"\n" +
                    "}";
            String url = "https://mall.acewill.net/mall/frontend/mall/product/list";
            String response = HttpRequest
                    .post(url)
                    .body(body)
                    .header(Header.HOST, "mall.acewill.net")
                    .header(Header.COOKIE,cookies )
                    .header(Header.CONTENT_TYPE, "application/json")
                    .header(Header.ACCEPT_LANGUAGE, "zh-cn")
                    .header(Header.USER_AGENT, "Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X)" +
                            " AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.13(0x18000d38)" +
                            " NetType/4G Language/zh_CN")
                    .header(Header.REFERER,referer )
                    .execute()
                    .body();
            System.out.println("调用结果："+response);
    }
}
