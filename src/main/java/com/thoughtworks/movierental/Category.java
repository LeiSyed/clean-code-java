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
        @Override
        int getFrequentPoints(int daysRented){
            return 1;
        }
    },
    NEW_RELEASE{
        @Override
        double amountFor(int daysRented){
            return daysRented * 3;
        }
        @Override
        int getFrequentPoints(int daysRented){
            int renterPoints = 1;
            if (daysRented > 1){
                return renterPoints + 1;
            }
            return renterPoints;
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
        @Override
        int getFrequentPoints(int daysRented){
            return 1;
        }
            },
    BLU_RAY{
        @Override
        double amountFor(int daysRented){
            return daysRented * 4.0;
        }
        @Override
        int getFrequentPoints(int daysRented){
            return daysRented * 3;
        }
    };


    double amountFor(int daysRented){
        return daysRented * 1.0;
    }
    int getFrequentPoints(){
        return 1;
    }

    abstract int getFrequentPoints(int daysRented);
}