package br.com.castgroup;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.castgroup.model.PersonModel;
import br.com.castgroup.repository.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createShouldPersistData() {
		PersonModel person = new PersonModel("Roger Albuquerque Silva", "Rua Manoel Aquino, 249 - Janga Paulista - PE", "81986070805","albuquerque.roger@gmail.com");
		this.personRepository.save(person);
		
		Assertions.assertThat(person.getId()).isNotNull();
		Assertions.assertThat(person.getName()).isEqualTo("Roger Albuquerque Silva");
		Assertions.assertThat(person.getAddress()).isEqualTo("Rua Manoel Aquino, 249 - Janga Paulista - PE");
		Assertions.assertThat(person.getCellphone()).isEqualTo("81986070805");
		Assertions.assertThat(person.getEmail()).isEqualTo("albuquerque.roger@gmail.com");
	}
	
	@Test
	public void deleteShouldRemoveData() {
		PersonModel person = new PersonModel("Roger Albuquerque Silva", "Rua Manoel Aquino, 249 - Janga Paulista - PE", "81986070805","albuquerque.roger@gmail.com");
		this.personRepository.save(person);
		this.personRepository.delete(person);
		
		Assertions.assertThat(personRepository.findById(person.getId())).isNull();
	}
	
	@Test
	public void updateShouldChangeAndPersistData() {
		PersonModel person = new PersonModel("Roger Albuquerque Silva", "Rua Manoel Aquino, 249 - Janga Paulista - PE", "81986070805","albuquerque.roger@gmail.com");
		this.personRepository.save(person);
		
		person.setName("José Calazans da Rocha");
		person.setAddress("SEPN 504 – Bloco A, 100 – 2º andar – Edifício Ana Carolina - Brasília - DF");
		person.setCellphone("6134297300");
		person.setEmail("calazans@castgroup.com.br");
		
		this.personRepository.save(person);
		
		person = this.personRepository.findById(person.getId());
		
		Assertions.assertThat(person.getId()).isNotNull();
		Assertions.assertThat(person.getName()).isEqualTo("José Calazans da Rocha");
		Assertions.assertThat(person.getAddress()).isEqualTo("SEPN 504 – Bloco A, 100 – 2º andar – Edifício Ana Carolina - Brasília - DF");
		Assertions.assertThat(person.getCellphone()).isEqualTo("6134297300");
		Assertions.assertThat(person.getEmail()).isEqualTo("calazans@castgroup.com.br");
	}
	
	@Test
	public void createWhenNameIsNullShouldThrownConstraintViolationException() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("Name can not be empty");
		this.personRepository.save(new PersonModel());
	}
	
	@Test
	public void createWhenAddressIsNullShouldThrownConstraintViolationException() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("Address can not be empty");
		PersonModel person = new PersonModel();
		person.setName("Roger Albuquerque Silva");
		this.personRepository.save(person);
	}
	
	@Test
	public void createWhenCellphoneIsNullShouldThrownConstraintViolationException() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("Cellphone can not be empty");
		PersonModel person = new PersonModel();
		person.setName("Roger Albuquerque Silva");
		person.setAddress("SEPN 504 – Bloco A, 100 – 2º andar – Edifício Ana Carolina - Brasília - DF");
		this.personRepository.save(person);
	}
	
	@Test
	public void createWhenEmailIsNullShouldThrownConstraintViolationException() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("Email can not be empty");
		PersonModel person = new PersonModel();
		person.setName("Roger Albuquerque Silva");
		person.setAddress("SEPN 504 – Bloco A, 100 – 2º andar – Edifício Ana Carolina - Brasília - DF");
		person.setCellphone("81986070805");
		this.personRepository.save(person);
	}
	
	@Test
	public void createWhenEmailNotValidShouldThrownConstraintViolationException() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("Enter a valid email address");
		PersonModel person = new PersonModel();
		person.setName("Roger Albuquerque Silva");
		person.setAddress("SEPN 504 – Bloco A, 100 – 2º andar – Edifício Ana Carolina - Brasília - DF");
		person.setCellphone("81986070805");
		person.setEmail("albuquerque.roger");
		this.personRepository.save(person);
	}

}
