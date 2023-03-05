package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("BMW", 530);
        Car car2 = new Car("Lexus", 500);
        Car car3 = new Car("Mazda", 3);
        Car car4 = new Car("Tesla", 5);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));
        //userService.listUsers().stream().forEach(System.out::println);

        System.out.println(userService.getUserByCar(car1.getModel(), car1.getSeries()));
        System.out.println(userService.getUserByCar("Lexus", 500));

        context.close();
    }
}
