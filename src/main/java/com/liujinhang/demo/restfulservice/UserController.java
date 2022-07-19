package com.liujinhang.demo.restfulservice;

import com.liujinhang.demo.entity.Department;
import com.liujinhang.demo.entity.User;
import com.liujinhang.demo.logic.GreetingLogicInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    // @Qualifier("englishGreeting")
    public GreetingLogicInterface GreetingLogic = null;

    @Autowired
    public JpaRepository<User, Integer> userRepository = null;

    @Autowired
    public JpaRepository<Department, Integer> departmentRepository = null;

    @GetMapping(value = "/users/name/{name}")
    public ResponseEntity<User> findUserByName(@PathVariable("name") String name){

        User user = new User();
        user.setName(name);
        Example<User> example = Example.of(user);
        var userOptional = userRepository.findOne(example);

        if(userOptional.isPresent()){
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/users/name/prefix/{prefix}")
    public List<User> findUserByNamePrefix(@PathVariable("prefix") String prefix){

        Query query =
                entityManager.createQuery("select case when (locate(user.name, :prefix) = 0) then ('true') else ('false') end from User user");
        query.setParameter("prefix", prefix);
        List result = query.getResultList();

        return result;
    }

}
