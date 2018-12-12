package cn.wolfcode.quartz_test.sort;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class Bus implements Comparable<Bus> {
    public Bus(String name, String date) {
        this.name = name;
        this.date = date;
    }

    private String name;
    private String date;

    @Override
    public int compareTo(Bus bus) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int result = 0;
        try {
            long l = sdf.parse(this.date).getTime() - sdf.parse(bus.getDate()).getTime();
            if (l > 0) {
                result = 1;
            } else if (l < 0) {
                result = -1;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
