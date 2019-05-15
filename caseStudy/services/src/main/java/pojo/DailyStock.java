package pojo;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

//Useless
public class DailyStock {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM/dd/yyyy");
    String date;
    Double price;

    public DailyStock(String date, Double price) {
        this.date = date;
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getDate() {
        return this.date;
    }
}
