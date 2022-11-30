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
            //show figures for this rental
            outputStatement
                    .append("\t")
                    .append(eachRental.getMovie().getMovieTitle())
                    .append("\t")
                    .append(eachRental.movie.calculateRentalAmount(eachRental))
                    .append("\n");
        }
        outputStatement
                .append("Amount owed is ")
                .append(calcTotal())
                .append("\n");

        outputStatement.append("You earned ")
                .append(calcFrequentRenterPoints(rentals))
                .append(" frequent renter points");

        return outputStatement.toString();
    }

    public String htmlStatement() {
        StringBuilder outputHtml = new StringBuilder("<h1>Rental Record for <b>");
        outputHtml.append(getCustomerName())
                .append("</b></h1><p>");
        for (Rental eachRental : rentals) {
            //show figures for this rental
           outputHtml
                    .append(eachRental.getMovie().getMovieTitle())
                    .append(" <b>")
                    .append(eachRental.movie.calculateRentalAmount(eachRental))
                    .append("</b><br>");
        }
        outputHtml
                .append("Amount owed is <b>")
                .append(calcTotal())
                .append("</b><br>");
        outputHtml
                .append("You earned <b>")
                .append(calcFrequentRenterPoints(rentals))
                .append("</b> frequent renter points</p>");

        return outputHtml.toString();

    }

    public int calcFrequentRenterPoints(List<Rental> rentals) {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals){
            frequentRenterPoints += rental.movie.getFrequentRenterPoints(rental.getDaysRented());
        }
        return frequentRenterPoints;
    }

    private double calcTotal(){
        double amount = 0;

        for (Rental rental : rentals){
            amount += rental.movie.calculateRentalAmount(rental);
        }
        return amount;
    }

}

