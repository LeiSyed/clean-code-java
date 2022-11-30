package com.thoughtworks.movierental;

public class Rental {

    private final int daysRented;
    final Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getFrequentRenterPoints(int frequentRenterPoints) {
        if ((getMovie().getCategory() == Category.NEW_RELEASE)
                &&
                getDaysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount(Movie movie) {
        return movie.calculateRentalAmount(this);
    }
}