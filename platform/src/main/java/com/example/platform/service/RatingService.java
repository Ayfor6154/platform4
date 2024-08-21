package com.example.platform.service;

import com.example.platform.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating addService(Rating rating);

    List<Rating> showService(int ID);

    Rating addLikedService(int ID);
}
