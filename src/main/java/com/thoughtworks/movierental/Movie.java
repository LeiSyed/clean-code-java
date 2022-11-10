package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String movieTitle;
    private int priceCategory;

    public Movie(String movieTitle, int priceCategory) {
        this.movieTitle = movieTitle;
        this.priceCategory = priceCategory;
    }

    public int getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(int priceCode) {
        priceCategory = priceCode;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

}