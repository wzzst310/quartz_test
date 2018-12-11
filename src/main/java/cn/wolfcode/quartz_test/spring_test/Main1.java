package cn.wolfcode.quartz_test.spring_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WangZhe on 2018年12月04日.
 */

public class Main1 {
    public static void main(String[] args) {
        List list1 = new ArrayList<>();
        List list2 = new ArrayList<>();
        list1.add(new Job(1,"小小"));
        list1.add(new Job(2,"大大"));
        list2.add(new Job(1,"小小"));
        list2.add(new Job(2,"cc"));
        boolean b = list1.retainAll(list2);
        System.out.println(b);
        HashMap<Object, Object> map1 = new HashMap<>();
        HashMap<Object, Object> map2 = new HashMap<>();
        HashMap<Object, Object> map3 = new HashMap<>();
        map1.put("customerId","xx");
        map2.put("customerId","11");
        map3.put("customerId","133");
        ArrayList<Object> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
    }
}
