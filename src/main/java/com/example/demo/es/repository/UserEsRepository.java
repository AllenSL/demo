package com.example.demo.es.repository;

import com.example.demo.es.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserEsRepository extends ElasticsearchRepository<User, Long> {

}
