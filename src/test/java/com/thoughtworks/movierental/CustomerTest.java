package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CustomerTest {

    @Test
    public void shouldGenerateStatementForCustomer() {
        Customer customer = createCustomer();

        String statement = customer.statement();

        Assert.assertEquals("Rental Record for Bruce Wayne\n" +
                "\tSpider-man: No way home\t12.0\n" +
                "\tSpider-man: Homecoming\t5.0\n" +
                "\tSpider-man: Animated\t3.0\n" +
                "Amount owed is 20.0\n" +
                "You earned 4 frequent renter points", statement);
    }

    @Test
    public void shouldGenerateHtmlOutputForCustomer() {
        Customer customer = createCustomer();
        String outputHtml = customer.HtmlStatement();

        Assert.assertEquals("<h1>Rental Record for <b>Bruce Wayne</b></h1>" +
                "<p>Spider-man: No way home <b>12.0</b><br>" +
                "Spider-man: Homecoming <b>5.0</b><br>" +
                "Spider-man: Animated <b>3.0</b><br>" +
                "Amount owed is <b>20.0</b><br>" +
                "You earned <b>4</b> frequent renter points</p>", outputHtml);
    }

    private static Customer createCustomer() {
        Customer customer = new Customer("Bruce Wayne");
        customer.addRental(new Rental(new Movie("Spider-man: No way home", Movie.NEW_RELEASE), 4));
        customer.addRental(new Rental(new Movie("Spider-man: Homecoming", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("Spider-man: Animated", Movie.CHILDRENS), 4));
        return customer;
    }
}