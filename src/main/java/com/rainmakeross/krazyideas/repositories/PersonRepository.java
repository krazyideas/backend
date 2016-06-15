package com.rainmakeross.krazyideas.repositories;

import com.rainmakeross.krazyideas.models.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    // Example: GET /people/search/findById?id=1
    List<Person> findById(@Param("id") Long id);

    // Example: GET /people/search/findByAuthId?authId=1234567890@github
    List<Person> findByAuthId(@Param("authId") String authId);

}
