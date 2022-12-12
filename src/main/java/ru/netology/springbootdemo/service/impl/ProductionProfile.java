package ru.netology.springbootdemo.service.impl;

import ru.netology.springbootdemo.service.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}