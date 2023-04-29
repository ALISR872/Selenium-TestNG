package com.eurotech.tests.day14_PropertiesSingleton;

import org.testng.annotations.Test;

public class InstantiateSingletonClassEx {

    @Test
    public void test1() {
        // SingletonClassExample singleton = new SingletonClassExample();
        SingletonClassExample singleton1 = SingletonClassExample.getInstanceOfSigletonClassExample();

        SingletonClassExample singleton2 = SingletonClassExample.getInstanceOfSigletonClassExample();

    }


}
