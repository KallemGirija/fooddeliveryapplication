package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entity.Payment;
import com.app.exceptions.PaymentException;
import com.app.service.IPaymentService;

@RestController
@RequestMapping("/pay")
@CrossOrigin(origins ="http://localhost:4200")
public class PaymentController {
	

	  private IPaymentService paymentService;

	  @Autowired
	  public PaymentController(IPaymentService paymentService) {
	    this.paymentService = paymentService;
	  }

	  @PostMapping("/add")
	  public ResponseEntity<?> processPayment(@RequestBody Payment payment) {
	    try {
	      Payment processedPayment = paymentService.processPayment(payment);
	      return ResponseEntity.ok(processedPayment);
	    } catch (PaymentException e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }
	  }
	  
	  
	


}
