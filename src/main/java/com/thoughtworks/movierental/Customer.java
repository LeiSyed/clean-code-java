package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;


public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder outputStatement = new StringBuilder("Rental Record for ");
        outputStatement.append(getName());
        outputStatement.append('\n');
        for (Rental each : rentals) {
            double thisAmount = 0;
            thisAmount = Rental.calculateRentalAmount(each);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getCategory() == Movie.NEW_RELEASE)
                    &&
                    each.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            outputStatement
                    .append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount)
                    .append("\n");
            totalAmount += thisAmount;
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

}

