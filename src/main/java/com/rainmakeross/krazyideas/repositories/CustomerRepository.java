package com.rainmakeross.krazyideas.repositories;

import com.rainmakeross.krazyideas.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
}
