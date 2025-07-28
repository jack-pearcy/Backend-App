package com.example.demo.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PurchaseResponse {

    private final String orderTrackingNumber;
}
