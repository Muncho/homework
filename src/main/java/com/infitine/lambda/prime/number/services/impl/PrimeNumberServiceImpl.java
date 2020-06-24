package com.infitine.lambda.prime.number.services.impl;

import com.infitine.lambda.prime.number.services.PrimeNumberService;
import org.apache.tomcat.jni.Error;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class PrimeNumberServiceImpl implements PrimeNumberService {
    @Override
    public boolean isPrime(int num) {
        if(num<=1 ) {
            return false;
        }
        return IntStream.rangeClosed(2, num/2).noneMatch(i -> num%i == 0);
    }

    @Override
    public int getNextPrime(int num) {
        boolean prime = isPrime(num);
        while(!prime) {
            num++;
            prime = isPrime(num);
        }
        return num;
    }
}
