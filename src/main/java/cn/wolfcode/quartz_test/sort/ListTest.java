package cn.wolfcode.quartz_test.sort;


import com.alibaba.fastjson.JSON;


import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) throws Exception {
        List<Car> list = new ArrayList<>();
        Car car1 = new Car("卡车", "产品1", new ArrayList<Bus>());
        Car car2 = new Car("货车", "产品2", new ArrayList<Bus>());
        Car car3 = new Car("汽车", "产品3", new ArrayList<Bus>());
        Bus bus11 = new Bus("bus11", "1995-11-11");
        Bus bus12 = new Bus("bus11", "2017-10-11");
        Bus bus13 = new Bus("bus11", "2016-09-11");

        car1.getBuses().add(bus11);
        car1.getBuses().add(bus12);
        car1.getBuses().add(bus13);
        Bus bus21 = new Bus("bus11", "2019-12-31");
        Bus bus22 = new Bus("bus11", "1966-12-11");
        Bus bus23 = new Bus("bus11", "2099-03-14");
        car2.getBuses().add(bus21);
        car2.getBuses().add(bus22);
        car2.getBuses().add(bus23);
        Bus bus31 = new Bus("bus11", "1997-01-01");
        Bus bus32 = new Bus("bus11", "2008-05-12");
        Bus bus33 = new Bus("bus11", "2008-08-08");
        car3.getBuses().add(bus31);
        car3.getBuses().add(bus32);
        car3.getBuses().add(bus33);
        list.add(car2);
        list.add(car3);
        list.add(car1);
        String s1 = JSON.toJSONString(list);
        String s = "[{\"buses\":[{\"date\":\"2019-12-31\",\"name\":\"bus11\"},{\"date\":\"1966-12-11\",\"name\":\"bus11\"},{\"date\":\"2099-03-14\",\"name\":\"bus11\"}],\"name\":\"货车\",\"productId\":\"产品2\"},{\"buses\":[{\"date\":\"1997-01-01\",\"name\":\"bus11\"},{\"date\":\"2008-05-12\",\"name\":\"bus11\"},{\"date\":\"2008-08-08\",\"name\":\"bus11\"}],\"name\":\"汽车\",\"productId\":\"产品3\"},{\"buses\":[{\"date\":\"1995-11-11\",\"name\":\"bus11\"},{\"date\":\"2017-10-11\",\"name\":\"bus11\"},{\"date\":\"2016-09-11\",\"name\":\"bus11\"}],\"name\":\"卡车\",\"productId\":\"产品1\"}]\n";
        List<Car> cars = JSON.parseArray(s, Car.class);

        //List<Car> newList = cars.stream().sorted(Comparator.comparing(Car::getProductId)).collect(Collectors.toList());
        List<Car> newList = cars.stream().sorted(Car::compareTo).collect(Collectors.toList());
        newList.stream().forEach(car -> car.setBuses(car.getBuses().stream().sorted(Bus::compareTo).collect(Collectors.toList())));
        System.out.println(JSON.toJSONString(newList));


    }
}
