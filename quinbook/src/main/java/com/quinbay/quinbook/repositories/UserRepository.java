package com.quinbay.quinbook.repositories;

import com.quinbay.quinbook.entity.QuinbookUsers;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<QuinbookUsers,Integer> {
}
