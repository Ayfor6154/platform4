package com.example.platform.service;

import com.example.platform.entity.Wallet;

public interface WalletService {
    Wallet addService(Wallet wallet);
    Wallet updateService(float money,int ID);
    Wallet selectService(int ID);
}
