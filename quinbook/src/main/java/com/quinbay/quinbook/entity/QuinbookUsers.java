package com.quinbay.quinbook.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@SolrDocument(collection = "quinbook-profiles")
public class QuinbookUsers {
	@Id
	@org.springframework.data.annotation.Id
	@GenericGenerator(name="user_id_seq", strategy = "increment")
	@GeneratedValue(generator = "user_id_seq",strategy = GenerationType.AUTO)
	@Indexed(name="userId",type="integer")
	private Integer userId;
	@Indexed(name="userName",type="string")
	private String userName;
	@Indexed(name="email",type="string")
	private String email;
	@Indexed(name="location",type="string")
	private String location;
}
