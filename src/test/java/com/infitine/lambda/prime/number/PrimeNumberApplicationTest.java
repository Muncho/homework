package com.infitine.lambda.prime.number;

import com.infitine.lambda.prime.number.services.PrimeNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimeNumberApplicationTest {

	@Autowired
	PrimeNumberService primeNumberService;

	@Test
	public void wrongInput() {
		assertThrows(NumberFormatException.class, () -> {
			primeNumberService.isPrime(Integer.parseInt("1f"));
		});

		assertThrows(NumberFormatException.class, () -> {
			primeNumberService.isPrime(Integer.parseInt(""));
		});

		assertThrows(NumberFormatException.class, () -> {
			primeNumberService.isPrime(Integer.parseInt(null));
		});

		assertThrows(NumberFormatException.class, () -> {
			primeNumberService.isPrime(Integer.parseInt("-2147483649"));
		});

		assertThrows(NumberFormatException.class, () -> {
			primeNumberService.isPrime(Integer.parseInt("2147483649"));
		});
	}

	@Test
	public void isPrime() {
		assertTrue(primeNumberService.isPrime(Integer.parseInt("2")));
		List<Integer> nums = Arrays.asList(-3, 0, 1);
		nums.forEach(i -> assertFalse(primeNumberService.isPrime(i)));
		assertEquals(2, primeNumberService.getNextPrime(1));
		assertEquals(3, primeNumberService.getNextPrime(3));
	}

}
