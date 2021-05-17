package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorsTest {

	@Test
	public void testIsZeroOrNull() {
		Integer testing = 0;
		Integer nulled = null;
		assertTrue(Validators.isZeroOrNull(testing));
		assertTrue(Validators.isZeroOrNull(nulled));
	}

	@Test
	public void testIsNullObject() {
		Object nulled = null;
		assertTrue(Validators.isNullObject(nulled));
	}

	@Test
	public void testOnlyValidChars() {
		String validChars = "vali do";
		String invalidChars = "1nv4l!d0";
		assertTrue(Validators.onlyValidChars(validChars));
		assertFalse(Validators.onlyValidChars(invalidChars));
	}

	@Test
	public void testIsCBO2002Valid() {
		Integer CBOFake = 123456789;
		Integer CBO = 123456;
		assertTrue(Validators.isCBO2002Valid(CBO));
		assertFalse(Validators.isCBO2002Valid(CBOFake));
	}
	
	@Test
	public void testIsCBO1994Valid() {
		Integer CBOFake = 123456789;
		Integer CBO = 12345;
		assertTrue(Validators.isCBO1994Valid(CBO));
		assertFalse(Validators.isCBO1994Valid(CBOFake));
	}

	@Test
	public void testOnlyValidNumber() {
		String validNumbers = "20.42";
		String validNumbers2 = "2042";
		String invalidNumbers = "2O.A2";
		String invalidNumbers2 = "2@.A%";
		assertTrue(Validators.onlyValidNumber(validNumbers));
		assertTrue(Validators.onlyValidNumber(validNumbers2));
		assertFalse(Validators.onlyValidNumber(invalidNumbers));
		assertFalse(Validators.onlyValidNumber(invalidNumbers2));
	}

}
