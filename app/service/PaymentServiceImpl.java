package com.app.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Payment;
import com.app.exceptions.PaymentException;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

	@Override
	public Payment processPayment(Payment payment) throws PaymentException {
		if (!isValidCardNumber(payment.getCardNumber())) {
			throw new PaymentException("Invalid card number");
		}

		if (!isValidExpiryDate(payment.getExpiryDate())) {
			throw new PaymentException("Invalid expiry date");
		}

		if (!isValidCVV(payment.getCvv())) {
			throw new PaymentException("Invalid CVV");
		}

		payment.setPay_id(generatePaymentId());

		return payment;
	}

	private String generatePaymentId() {
		return "PAY-" + UUID.randomUUID().toString();
	}

	private boolean isValidCardNumber(String cardNumber) {

		return cardNumber != null && cardNumber.matches("\\d{16}");
	}

	private boolean isValidExpiryDate(String expiryDate) {

		return expiryDate != null && expiryDate.matches("\\d{2}/\\d{2}");
	}

	private boolean isValidCVV(String cvv) {

		return cvv != null && cvv.matches("\\d{3}");
	}
	
	
}
