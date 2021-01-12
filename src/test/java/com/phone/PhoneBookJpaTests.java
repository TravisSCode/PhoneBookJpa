package com.phone;

import com.phone.entity.Phone;
import com.phone.entity.User;
import com.phone.repos.PhoneRepository;
import com.phone.repos.UserRepository;
import java.util.List;
import static junit.framework.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/*
 тесты
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PhoneBookJpaTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PhoneRepository phoneRepository;

    public PhoneBookJpaTests() {
          System.setProperty("java.awt.headless", "false");
    

    }
    @Before
    public void init(){
        // наполним тестовыми даннымим
          User user1 = userRepository.save(new User(1,"Иван","Иванов"));
          Phone phone1 = new Phone(1,"12345","",user1);
          phoneRepository.save(phone1);
          User user2 = userRepository.save(new User(2,"Петр","Петров"));
          Phone phone2 = new Phone(2,"12345","",user2);
          phoneRepository.save(phone2);
          User user3 = userRepository.save(new User(3,"Иван","Николаев"));
          Phone phone3 = new Phone(3,"22245","",user3);
          phoneRepository.save(phone3);
          User user33 = userRepository.save(new User(4,"Федор","Степанюк"));
    }
    
    

    @Test
    public void testSaveNewUser() {
        User user = userRepository.save(new User("Степан","Степанов"));
        assertNotNull(user);
    }
    
    @Test
    public void testSaveNewPhone() {
        User user = userRepository.findById(1).orElse(null);
        Phone phone = new Phone();
        phone.setPhone("44444");
        phone = phoneRepository.save(phone);
        assertNotNull(phone);
    }
    
    @Test
    public void testFindUserById() {
        User user = userRepository.findById(1).orElse(null);
        assertNotNull(user);
        assertEquals((long)1,(long)user.getId());
    }
    @Test
    public void testFindUserByPhone() {
        List<User> users = userRepository.findByPhones_Phone("12345", Sort.unsorted());
        assertEquals((long)2,(long)users.size());
    }
    
    @Test
    public void testFindByPhone() {
        List<Phone> phones = phoneRepository.findByPhone("12345");
        assertEquals((long)2,(long)phones.size());
    }
    
    
    @Test
    public void testFindByUser() {
        User user = userRepository.findById(1).orElse(null);
        List<Phone> phones = phoneRepository.findByUser(user);
        assertEquals((long)1,(long)phones.size());
    }
    
    @Test
    public void testUpdatePhone() {
        Phone phone = phoneRepository.findById(3).orElse(null);
        phone.setPhone("33333");
        phone = phoneRepository.save(phone);
        assertEquals("33333",phone.getPhone());
    }
    
    @Test
    public void testFindUserByLastName() {
        List<User> users = userRepository.findAllByLastName("Петров", Sort.unsorted());
        assertEquals((long)1,(long)users.size());
    }
    @Test
    public void testFindUserByFirstName() {
        List<User> users = userRepository.findAllByFirstName("Иван", Sort.unsorted());
        assertEquals((long)2,(long)users.size());
    }
    @Test
    public void testFindUserByLastAndFirstName() {
        List<User> users = userRepository.findAllByFirstNameAndLastName("Иван", "Николаев",Sort.unsorted());
        assertEquals((long)1,(long)users.size());
    }
    
    @Test
    public void testUpdateUser() {
        User user = userRepository.findById(2).orElse(null);
        user.setFirstName("Олег");
        user = userRepository.save(user);
        assertEquals("Олег",user.getFirstName());
    }
    
     @Test
    public void testDelUser() {
        userRepository.deleteById(4);
        assertThat(userRepository.count()).isEqualTo(3);
    }

}
