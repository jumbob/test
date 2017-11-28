package com.example.demo;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class CustomerSimpleSimple {

	@Test
	public void testMethod() {

		Customer c = new Customer(1L, "first","last");
		BDDAssertions.then(c.getId()).isEqualTo(1L);
		BDDAssertions.then(c.getFirst()).isEqualTo("first");
		BDDAssertions.then(c.getLast()).isEqualTo("last");
		
	}
}
