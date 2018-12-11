package cn.wolfcode.quartz_test.spring_test;

import com.alibaba.fastjson.JSON;
import groovy.json.StringEscapeUtils;
import org.quartz.ee.jmx.jboss.JBoss4RMIRemoteMBeanScheduler;

import java.io.PrintStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by WangZhe on 2018年12月01日.
 */

public class Main {
    public static void main(String[] args) {
        Job job = new Job(1, "你好");
        String string = JSON.toJSONString(job);
        System.out.println(string);
        String job1 = "{\"id\":1,\"name\":\"\\\'你好\"}";
        System.out.println(job1);
        job1 = StringEscapeUtils.unescapeJava(job1);
        System.out.println(job1);
        Job job2 = JSON.parseObject(job1, Job.class);
        String str ="123";
        System.out.println(str);
        System.out.println(job);
        changeStr(str,job);
        System.out.println(str);
        System.out.println(job);
    }
    private static void changeStr(String str, Job job){
        str = "小小";
        job.setName("dd");
    }
}
