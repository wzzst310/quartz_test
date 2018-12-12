package cn.wolfcode.quartz_test.webTest;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by WangZhe on 2018年12月11日.
 */

public class WebTest1 {
    public static void main(String[] args) {
        // 获取连接客户端工具
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String entityStr = null;
        CloseableHttpResponse response = null;

        try {

            // 创建POST请求对象
            HttpPost httpPost = new HttpPost("http://58.49.129.4/sit/userms/auth/loginByMobileVerfyCode?traceno=f76236b3-f664-456a-a25e-7b683adec7f7");
            /*
             * 添加请求参数
             */
            //        json方式
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("phone", "18684954312");
            jsonParam.put("verificationcode", "111111");
            StringEntity stringEntity = new StringEntity(jsonParam.toString(), "utf-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            /*
            // 创建请求参数
            List<NameValuePair> list = new LinkedList<>();
            BasicNameValuePair param1 = new BasicNameValuePair("phone", "18684954312");
            BasicNameValuePair param2 = new BasicNameValuePair("verificationcode", "111111");
            list.add(param1);
            list.add(param2);
            // 使用URL实体转换工具
            UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
            httpPost.setEntity(entityParam);
            */
            /*
             * 添加请求头信息
             */
            httpPost.addHeader("x-ac-app-version", "V1.0...");
            httpPost.addHeader("x-ac-channel-id", "KHT");
            httpPost.addHeader("x-ac-device-id", "XXXXXXX");
            httpPost.addHeader("x-ac-ip", "127.0.0.1");
            httpPost.addHeader("x-ac-mc-type", "gateway.user");
            httpPost.addHeader("x-ac-nonce", "1231231231231");
            httpPost.addHeader("x-ac-os-info", "IOS/Xiaomi/Huawei/...");
            httpPost.addHeader("x-ac-ppk-version", "V1...");
            httpPost.addHeader("x-ac-sign", "ds2i32iuhd2374249");
            httpPost.addHeader("x-ac-time", "20180807121212");
            httpPost.addHeader("x-ac-token-ticket", "23nui23rsdjf87938rhefhbdsvjdvhd");

            // 执行请求
            response = httpClient.execute(httpPost);
            // 获得响应的实体对象
            HttpEntity entity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(entity, "UTF-8");
            // System.out.println(Arrays.toString(response.getAllHeaders()));
        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        } finally {
            // 释放连接
            if (null != response) {
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    System.err.println("释放连接出错");
                    e.printStackTrace();
                }
            }
        }
        // 打印响应内容
        // 反序列化泛型
        GeneralResponse<LoginRsp> rsp = JSONObject.parseObject(entityStr, new TypeReference<GeneralResponse<LoginRsp>>() {
        });
        System.out.println(rsp.getData().getAuthToken());
    }
}
