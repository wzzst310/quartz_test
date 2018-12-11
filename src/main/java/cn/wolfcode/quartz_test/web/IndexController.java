package cn.wolfcode.quartz_test.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangZhe on 2018年12月01日.
 */
@RestController
public class IndexController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
