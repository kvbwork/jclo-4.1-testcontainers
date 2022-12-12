package ru.netology.springbootdemo.service.impl;

import ru.netology.springbootdemo.service.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}