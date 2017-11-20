package sk.upjs.ics.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.upjs.ics.usermanagement.persistent.DaoFactory;

@SpringBootApplication
public class UserManagementRestApp {
    public static void main(String[] args) {
        SpringApplication.run(UserManagementRestApp.class, args);
    }
}
