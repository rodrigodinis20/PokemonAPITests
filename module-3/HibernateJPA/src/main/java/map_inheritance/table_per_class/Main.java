package map_inheritance.table_per_class;

import map_inheritance.single_table.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        TablePerClass table = new TablePerClass();

        Boat boat = new Boat();
        boat.setEngines(4);
        boat.setMaxSpeed(40);
        Boat boat1 = new Boat();
        boat1.setEngines(4);
        boat1.setMaxSpeed(60);
        Boat boat2 = new Boat();
        boat2.setEngines(3);
        boat2.setMaxSpeed(30);
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        car.setGears(5);
        car1.setGears(6);
        car2.setGears(5);
        car.setMaxSpeed(160);
        car1.setMaxSpeed(220);
        car2.setMaxSpeed(140);

        table.save(boat, emf);
        table.save(boat1, emf);
        table.save(boat2, emf);
        table.save(car, emf);
        table.save(car1, emf);
        table.save(car2, emf);

        /*boat.setEngines(4);
        boat.setMaxSpeed(40);
        table.update(boat, emf);
         */

        List<Car> list = em.createNativeQuery("SELECT * FROM car_table_per_class")
                .getResultList();

        for (Car c: list) {
            System.out.println(c);
        }

        emf.close();
    }
}