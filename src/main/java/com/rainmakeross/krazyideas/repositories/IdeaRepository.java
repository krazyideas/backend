package com.rainmakeross.krazyideas.repositories;

import com.rainmakeross.krazyideas.models.Idea;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "idea", path = "idea")
public interface IdeaRepository extends PagingAndSortingRepository<Idea,Long> {
}
