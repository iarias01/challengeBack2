package com.festivals.demo.repository;

import com.festivals.demo.model.Festival;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FestivalRepository extends MongoRepository<Festival, String> {
}
