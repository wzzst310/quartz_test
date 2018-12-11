package cn.wolfcode.quartz_test.spring_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by WangZhe on 2018年12月07日.
 */

public class JsonTest {
    public static void main(String[] args) {
        String str = "[{\"RETURN_FLAG\":\"0\",\"RETURN_MESSAGE\":\"成功\",\"CHANGE_ID\":\"\"},{\"MODE_NAME\":\"累积生息\",\"POLICY_CODE\":\"000013335103008\",\"MODE_ID\":1,\"PRODUCT_ID\":22,\"PRODUCT_NAME\":\"太平无忧长期健康保险(分红型)\"},{\"MODE_NAME\":\"累积生息\",\"POLICY_CODE\":\"000003244515008\",\"MODE_ID\":1,\"PRODUCT_ID\":21,\"PRODUCT_NAME\":\"太平一生终身寿险(分红型)\"},{\"MODE_NAME\":\"累积生息\",\"POLICY_CODE\":\"180920172168008\",\"MODE_ID\":1,\"PRODUCT_ID\":22,\"PRODUCT_NAME\":\"太平无忧长期健康保险(分红型)\"}]";
        JSONArray objects = JSON.parseArray(str);
        ArrayList list = new ArrayList<>();
        for (Object object : objects) {
            list.add(JSON.parseObject(object.toString(), Map.class));
        }
    }

}
