package com.dogapi.utils;

public final class Endpoints {

    private Endpoints() {
    }

    public static final String LIST_ALL_BREEDS = "/breeds/list/all";
    public static final String BREED_IMAGES = "/breed/{breed}/images";
    public static final String RANDOM_IMAGE = "/breeds/image/random";
}