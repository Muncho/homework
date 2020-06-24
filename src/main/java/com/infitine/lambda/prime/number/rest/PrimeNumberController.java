package com.infitine.lambda.prime.number.rest;

import com.infitine.lambda.prime.number.services.PrimeNumberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prime")
public class PrimeNumberController {

    @Autowired
    PrimeNumberService primeNumberService;

    @ApiOperation(value = "Check if number is prime")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad input value")
    }
    )
    @GetMapping(value = "/isPrime/{prime}")
    public boolean isPrime(@PathVariable int prime) throws NumberFormatException {
        return primeNumberService.isPrime(prime);
    }

    @ApiOperation(value = "If the number is prime, returns it, else returns the next prime number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation successful"),
            @ApiResponse(code = 400, message = "Bad input value")
    }
    )
    @GetMapping(value = "/getPrime/{prime}")
    public int getPrime(@PathVariable int prime) throws NumberFormatException {
        return primeNumberService.getNextPrime(prime);
    }
}
