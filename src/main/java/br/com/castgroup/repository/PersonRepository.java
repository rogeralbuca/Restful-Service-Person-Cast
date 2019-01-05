package br.com.castgroup.repository;

import java.util.List;


import org.springframework.data.repository.Repository;

import br.com.castgroup.model.PersonModel;


public interface PersonRepository extends Repository<PersonModel, Integer> {
 
	void save(PersonModel person);
 
	void delete(PersonModel person);
	
	List<PersonModel> findAll();
 
	PersonModel findById(int id);
}