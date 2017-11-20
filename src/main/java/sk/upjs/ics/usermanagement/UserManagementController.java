package sk.upjs.ics.usermanagement;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sk.upjs.ics.usermanagement.persistent.DaoFactory;
import sk.upjs.ics.usermanagement.persistent.UserDao;

@RestController
public class UserManagementController {
    
    private UserDao userDao = DaoFactory.INSTANCE.getUserDao();
    
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
    
    @RequestMapping("/users/{id}")
    public User getUserById(@PathVariable long id) throws UserNotFoundException {
        User user = userDao.getById(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userDao.save(user);
    }
}
