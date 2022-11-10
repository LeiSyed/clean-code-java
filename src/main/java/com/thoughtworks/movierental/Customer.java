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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder outputStatement = new StringBuilder("Rental Record for ");
        outputStatement.append(getCustomerName());
        outputStatement.append('\n');
        for (Rental eachRental : rentals) {
            double amountOfRental = 0;
            amountOfRental = Rental.calculateRentalAmount(eachRental);
            frequentRenterPoints = accumulateFrequentRenterPoints(frequentRenterPoints, eachRental);

            //show figures for this rental
            outputStatement
                    .append("\t")
                    .append(eachRental.getMovie().getMovieTitle())
                    .append("\t")
                    .append(amountOfRental)
                    .append("\n");
            totalAmount += amountOfRental;
        }

        //add footer lines result
        outputStatement
                .append("Amount owed is ")
                .append(totalAmount)
                .append("\n");

        outputStatement.append("You earned ")
                .append(frequentRenterPoints)
                .append(" frequent renter points");

        return outputStatement.toString();
    }

    private static int accumulateFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        frequentRenterPoints++;
        if ((each.getMovie().getPriceCategory() == Movie.NEW_RELEASE)
                &&
                each.getDaysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

}

