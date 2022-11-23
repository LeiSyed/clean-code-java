package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;


public class Customer {
    private final String customerName;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Rental movieRented) {
        rentals.add(movieRented);
    }

    public String getCustomerName() {
        return customerName;
    }

    public String statement() {
        StringBuilder outputStatement = new StringBuilder("Rental Record for ");
        outputStatement.append(getCustomerName());
        outputStatement.append('\n');
        for (Rental eachRental : rentals) {
            double amountOfRental = 0;
            amountOfRental = Rental.calculateRentalAmount(eachRental);
            //show figures for this rental
            outputStatement
                    .append("\t")
                    .append(eachRental.getMovie().getMovieTitle())
                    .append("\t")
                    .append(amountOfRental)
                    .append("\n");
        }

        //add footer lines result
        outputStatement
                .append("Amount owed is ")
                .append(calcTotal())
                .append("\n");

        outputStatement.append("You earned ")
                .append(calcFrequentRenterPoints())
                .append(" frequent renter points");

        return outputStatement.toString();
    }

    private int calcFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals){
            frequentRenterPoints++;
            if ((rental.getMovie().getPriceCategory() == Movie.NEW_RELEASE)
                    &&
                    rental.getDaysRented() > 1) frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double calcTotal(){
        double amount = 0;

        for (Rental rental : rentals){
            amount += Rental.calculateRentalAmount(rental);
        }
        return amount;
    }

}

