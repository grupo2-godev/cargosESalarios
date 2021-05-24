package br.com.proway.senior.cargosESalarios.utilidades;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidadoresTest {

	@Test
	public void testIsZeroOrNull() {
		Integer testing = 0;
		Integer nulled = null;
		assertTrue(Validadores.ehZeroOuNulo(testing));
		assertTrue(Validadores.ehZeroOuNulo(nulled));
	}

	@Test
	public void testIsNullObject() {
		Object nulled = null;
		assertTrue(Validadores.ehObjetoNulo(nulled));
	}

	@Test
	public void testOnlyValidChars() {
		String validChars = "val1do";
		String invalidChars = "1nv4l!d0";
		assertTrue(Validadores.apenasCaracteresValidos(validChars));
		assertFalse(Validadores.apenasCaracteresValidos(invalidChars));
	}

	@Test
	public void testOnlyNonSpecialChars() {
		String validChars = "vali do";
		String invalidChars = "1nv4l!d0";
		assertTrue(Validadores.apenasCaracteresNaoEspeciais(validChars));
		assertFalse(Validadores.apenasCaracteresNaoEspeciais(invalidChars));
	}

	
	@Test
	public void testIsCBO2002Valid() {
		Integer CBOFake = 123456789;
		Integer CBO = 123456;
		assertTrue(Validadores.ehValidoCBO2002(CBO));
		assertFalse(Validadores.ehValidoCBO2002(CBOFake));
	}
	
	@Test
	public void testIsCBO1994Valid() {
		Integer CBOFake = 123456789;
		Integer CBO = 12345;
		assertTrue(Validadores.ehValidoCBO1994(CBO));
		assertFalse(Validadores.ehValidoCBO1994(CBOFake));
	}

	@Test
	public void testOnlyValidNumber() {
		String validNumbers = "20.42";
		String validNumbers2 = "2042";
		String invalidNumbers = "2O.A2";
		String invalidNumbers2 = "2@.A%";
		assertTrue(Validadores.apenasNumerosValidos(validNumbers));
		assertTrue(Validadores.apenasNumerosValidos(validNumbers2));
		assertFalse(Validadores.apenasNumerosValidos(invalidNumbers));
		assertFalse(Validadores.apenasNumerosValidos(invalidNumbers2));
	}

}
