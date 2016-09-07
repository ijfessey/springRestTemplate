package com.fesco.reevoo;

/**
 * Created by ian.fessey on 27/06/2016.
 */
public class ReevooBean {

    // [{"sku":"ZZZ","review_count":2,"average_score":"10.0"}]
    private String sku;
    private int review_count;
    private double average_score;


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(double average_score) {
        this.average_score = average_score;
    }
}
