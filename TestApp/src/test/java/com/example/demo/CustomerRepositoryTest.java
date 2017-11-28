package com.example.demo;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = TestAppApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void jpaTest() {

		
		Customer c = new Customer(null, "first","last");
		
		Customer saved=this.em.persistAndFlush(c);
		BDDAssertions.then(saved.getId()).isNotNull();
		BDDAssertions.then(saved.getFirst()).isEqualTo("first");
		BDDAssertions.then(saved.getLast()).isEqualTo("last");
		
		
	}
	
	@Test
	public void repoTest() {

		
		Customer c = new Customer(null, "first","last");
		
		Customer saved=this.customerRepository.saveAndFlush(c);
		BDDAssertions.then(saved.getId()).isNotNull();
		BDDAssertions.then(saved.getFirst()).isEqualTo("first");
		BDDAssertions.then(saved.getLast()).isEqualTo("last");
		
		
	}

}
