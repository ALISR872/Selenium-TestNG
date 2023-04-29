package org.example;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Faker faker = new Faker();
        System.out.println("animal: " + faker.animal().name());
        System.out.println("book author : " + faker.book().author());
        System.out.println("pokemon: " + faker.pokemon().name());
        System.out.println("food: " + faker.food().vegetable());
        System.out.println("nationality: "+ faker.nation().nationality());

    }


}