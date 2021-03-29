package ru.hh.interviewme;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ru.hh.interviewme.entity.User;
import ru.hh.interviewme.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests extends TestContainerBase {

    @Autowired
    public UserRepository userRepository;

    @Test
    public void testSkillsAreSaved() {
        User user_1 = new User();
        user_1.setName("Bob");
        user_1.setPhone("Bob phone");
        user_1.setEmail("Bob email");
        userRepository.save(user_1);

        User user_2 = new User();
        user_2.setName("John");
        user_2.setPhone("John phone");
        user_2.setEmail("John email");
        userRepository.save(user_2);

        User user_3 = new User();
        user_3.setName("Jane");
        user_3.setPhone("Jane phone");
        user_3.setEmail("Jane email");
        userRepository.save(user_3);

        User user_4 = new User();
        user_4.setName("Mary");
        user_4.setPhone("Mary phone");
        user_4.setEmail("Mary email");
        userRepository.save(user_4);

        List<User> users = userRepository.findAll();
        users.stream().forEach(System.out::println);
        assertEquals(4L, users.size());
    }
    
}
