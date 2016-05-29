package com.rainmakeross.krazyideas.repositories;

import com.rainmakeross.krazyideas.models.Idea;
import org.springframework.data.repository.CrudRepository;


public interface IdeaRepository extends CrudRepository<Idea,Long> {
}
