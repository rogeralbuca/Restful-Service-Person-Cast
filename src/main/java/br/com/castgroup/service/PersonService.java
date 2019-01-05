package br.com.castgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.castgroup.model.PersonModel;
import br.com.castgroup.model.ResponseModel;
import br.com.castgroup.repository.PersonRepository;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/rest")
public class PersonService {
 
	@Autowired
	private PersonRepository personRepository; 
 
	/**
	 * Saves a new person
	 * @param person
	 * @return
	 */
	@RequestMapping(value="/person", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody PersonModel person){
		try {
 
			this.personRepository.save(person);
 
			return new ResponseModel("Person saved successfully!");
 
		}catch(Exception e) {
 
			return new ResponseModel(e.getMessage());			
		}
	}
 
	/**
	 * Updates a person
	 * @param person
	 * @return
	 */
	@RequestMapping(value="/person", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody PersonModel person){
		try {
 
			this.personRepository.save(person);		
 
			return new ResponseModel("Person updated successfully!");
 
		}catch(Exception e) {
 
			return new ResponseModel(e.getMessage());
		}
	}
 
	/**
	 * List all persons
	 * @return
	 */
	@RequestMapping(value="/person", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<PersonModel> list(){
 
		return this.personRepository.findAll();
	}
 
	/**
	 * Find a person by the id
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/person/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PersonModel search(@PathVariable("id") Integer id){
 
		return this.personRepository.findById(id);
	}
 
	/***
	 * Deletes one person per id
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/person/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel delete(@PathVariable("id") Integer id){
 
		PersonModel personModel = personRepository.findById(id);
 
		try {
 
			personRepository.delete(personModel);
 
			return new ResponseModel("Successfully deleted person!");
 
		}catch(Exception e) {
			return new ResponseModel(e.getMessage());
		}
	}
 
}
