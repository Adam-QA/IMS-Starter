package com.qa.ims.persistence.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Test
	public void test() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}

}
