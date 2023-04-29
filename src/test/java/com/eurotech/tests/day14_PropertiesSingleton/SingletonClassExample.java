package com.eurotech.tests.day14_PropertiesSingleton;

public class SingletonClassExample {

    private static SingletonClassExample instanceOfSigletonClassExample;

    private SingletonClassExample(){
        System.out.println("creating the SingletonClassExample object");
    }


    public static SingletonClassExample getInstanceOfSigletonClassExample(){

        if(instanceOfSigletonClassExample == null){
            instanceOfSigletonClassExample = new SingletonClassExample();
        }else {
            System.out.println("It has alraedy been initialize returning existing instance of " +
                    "SingletonClassExample ");
        }
        return instanceOfSigletonClassExample;
    }
}
