package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CustomerTest {

    @Test
    public void test(){
        Customer customer = new Customer("Harry Davidson");
        Movie firstMovie = new Movie("Drink Hard 2", Movie.REGULAR);
        Movie secondMovie = new Movie("Adventures of Pooja", Movie.CHILDRENS);
        Rental firstRental = new Rental(firstMovie, 15);
        Rental secondRental = new Rental(secondMovie, 10);

        customer.addRental(firstRental);
        customer.addRental(secondRental);
        String statement = customer.statement();
        Assert.assertNotNull(statement);
        System.out.println(statement);
    }


}