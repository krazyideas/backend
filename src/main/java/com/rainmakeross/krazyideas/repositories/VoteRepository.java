package com.rainmakeross.krazyideas.repositories;


import com.rainmakeross.krazyideas.models.Vote;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vote", path = "vote")
public interface VoteRepository extends PagingAndSortingRepository<Vote, Long> {
}
