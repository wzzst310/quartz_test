package cn.wolfcode.quartz_test.sort;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Car implements Serializable, Comparable<Car> {


    public Car(String name, String productId, List<Bus> buses) {
        this.name = name;
        this.productId = productId;
        this.buses = buses;
    }

    private String name;
    private String productId;
    private List<Bus> buses;

    @Override
    public int compareTo(Car car) {
        int result = 0;
        long l = Long.parseLong(this.productId.substring(2)) - Long.parseLong(car.getProductId().substring(2));
        if (l > 0) {
            result = 1;
        } else if (l < 0) {
            result = -1;
        }
        return result;
    }


}
