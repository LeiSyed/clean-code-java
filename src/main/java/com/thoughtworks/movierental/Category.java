package com.thoughtworks.movierental;

public enum Category {
    REGULAR{
        @Override
        double amountFor(int daysRented){
            double rentalPrice = 0.0;
            rentalPrice+= 2;
            if (daysRented > 2)
                rentalPrice += (daysRented - 2) * 1.5;
            return rentalPrice;
        }
    },
    NEW_RELEASE{
        @Override
        double amountFor(int daysRented){
            return daysRented * 3;
        }
    },
    CHILDRENS{
        @Override
        double amountFor(int daysRented){
            double rentalPrice = 0.0;
            rentalPrice += 1.5;
            if (daysRented > 3)
                rentalPrice += (daysRented - 3) * 1.5;
            return rentalPrice;
        }
            },
    BLU_RAY{
        @Override
        double amountFor(int daysRented){
            return daysRented * 4.0;
        }
    };


    double amountFor(int daysRented){
        return daysRented * 1.0;
    }

}