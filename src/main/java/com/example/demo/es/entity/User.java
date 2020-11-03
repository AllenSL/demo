package com.example.demo.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "user", type = "user", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
public class User {
	@Id
	private Long id;
	private String name;
	private Integer age;
	private String remark;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", remark=" + remark + "]";
	}
}
