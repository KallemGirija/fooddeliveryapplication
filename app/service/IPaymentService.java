package com.app.service;

import com.app.entity.Payment;
import com.app.exceptions.PaymentException;

public interface IPaymentService {
	  Payment processPayment(Payment payment) throws PaymentException;

}
