package com.thoughtworks.movierental;

public class Rental {

    private final int daysRented;
    private final Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    static double calculateRentalAmount(Rental rental) {
        double rentalAmount = 0;
        switch (rental.getMovie().getPriceCategory()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (rental.getDaysRented() > 2)
                    rentalAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    rentalAmount += (rental.getDaysRented() - 3) * 1.5;
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