package com.fs30.bookmyshow.repository;

import com.fs30.bookmyshow.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LoginRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    // apply common login functionality using google or facebook account.
    public String signUpUser(UserDetails userDetails) {
        Query query = new Query();
        query.addCriteria(Criteria.where("phoneNumber").is(userDetails.getPhoneNumber()));
        List<UserDetails> userDetailsList = mongoTemplate.find(query, UserDetails.class);
        System.out.println("UserDetailsList :: " + userDetailsList);
        if (null!= userDetailsList) {
            return "User exist already. Please Login . ";
        } else {
            query = new Query();
            UserDetails user = mongoTemplate.save(userDetails);
            return "Registration completed!! Login with new credentials.";
        }
    }
// encode the password
    public String loginUser(UserDetails userDetails) {
        Query query = new Query();
        query.addCriteria(Criteria.where("phoneNumber").is(userDetails.getPhoneNumber())
                .and("userName").is(userDetails.getUserName())
                .and("password").is(userDetails.getPassword()));
        List<UserDetails> userDetailsList = mongoTemplate.find(query, UserDetails.class);
        if (null!= userDetailsList) {
            return "User logged in. ";
        } else {
            return "User does not exist . Please signup ";
        }
    }

}
