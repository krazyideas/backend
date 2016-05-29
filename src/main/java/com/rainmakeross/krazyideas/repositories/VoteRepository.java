package com.rainmakeross.krazyideas.repositories;


import com.rainmakeross.krazyideas.models.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {
}
