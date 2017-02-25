package com.pseudo.tdd;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by prayagupd
 * on 1/18/17.
 */

public class GenericsTests {

    @Test
    public void testGenerics() {
        Moveable carMoveable = new CarMoveable();
        Vehicle car = carMoveable.supplyParams("car-001");

        Assert.assertEquals(car.getName(), "car-001");
    }

    @Test
    public void testIfSomethingIsAssignable() {
        Vehicle v = new Vehicle() {
            @Override
            public String getName() {
                return "kufc";
            }

            @Override
            public Vehicle setName(String name) {
                return this;
            }

            @Override
            public Vehicle fromPayload(String payload) {
                return null;
            }
        };
        Vehicle c = v;

        Assert.assertEquals(v instanceof Car, false);
        Assert.assertEquals(v instanceof Vehicle, true);
        Assert.assertEquals(Car.class.isAssignableFrom(Vehicle.class.getClass()), false);
        Assert.assertEquals(Vehicle.class.isAssignableFrom(Car.class.getClass()), false);
    }
}

interface ToVehicle {
    public Vehicle toVehicle(Class<Car> car, String payload);
    //public Bus toVehicle(Class<Bus> bus);
}

class ConcretToVehicle implements ToVehicle {

    @Override
    public Vehicle toVehicle(Class<Car> car, String payload) {
        Vehicle v = new Car();
        return v;
    }
}

interface Vehicle {
    public String getName();
    public Vehicle setName(String name);
    public Vehicle fromPayload(String payload);
}

class Car implements Vehicle {

    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Vehicle setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Vehicle fromPayload(String payload) {
        Vehicle v = new Car();
        v.setName(payload);
        return v;
    }
}

class Bus implements Vehicle {

    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Vehicle setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Vehicle fromPayload(String payload) {
        return null;
    }
}

interface Moveable<V extends Vehicle> {
    public V supplyParams(String params);
}

abstract class AbstractMoveable<V extends Vehicle> implements Moveable<V> {

    abstract void process(V v);

    Class<V> vehicleType;

    public AbstractMoveable(Class<V> vehicle){
        this.vehicleType = vehicle;
    }

    @Override
    public V supplyParams(String params) {

        // Can not even use Visitor pattern because Class<Car> is same as Class<Bus>
        // because of type erasure

        if (vehicleType.isAssignableFrom(Car.class)) {
            Car v = new Car();
            v.setName(params);
            return (V) v;
        }

        return null;
    }
}

class CarMoveable extends AbstractMoveable<Car> {

    public CarMoveable() {
        super(Car.class);
    }

    @Override
    void process(Car car) {
        System.out.println(car.getName());
    }
}