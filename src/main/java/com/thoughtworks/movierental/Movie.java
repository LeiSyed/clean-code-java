package com.thoughtworks.movierental;

public class Movie {

    private final String movieTitle;
    private Category category;


    public Movie(String movieTitle, Category category) {
        this.movieTitle = movieTitle;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public double calculateRentalAmount(Rental rental) {
        double rentalAmount = 0;
        rentalAmount += category.amountFor(rental.getDaysRented());
        return rentalAmount;
    }
}