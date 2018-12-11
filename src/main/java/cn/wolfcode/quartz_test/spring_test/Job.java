package cn.wolfcode.quartz_test.spring_test;

import lombok.Data;

/**
 * Created by WangZhe on 2018年12月01日.
 */
@Data
public class Job {
    public Job(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;
}
