package com.quinbay.quinbook.repositories;

import com.quinbay.quinbook.entity.QuinbookUsers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface UserSolrRepository extends SolrCrudRepository<QuinbookUsers, Integer> {
	@Query ("userName:*?0*")
	List<QuinbookUsers>findByString(String searchTerm, PageRequest pageable);
}
