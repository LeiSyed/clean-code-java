package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    static double calculateRentalAmount(Rental each) {
        double rentalAmount = 0;
        switch (each.getMovie().getCategory()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (each.getDaysRented() > 2)
                    rentalAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (each.getDaysRented() > 3)
                    rentalAmount += (each.getDaysRented() - 3) * 1.5;
                break;
            default:
                break;

        }
        return rentalAmount;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}