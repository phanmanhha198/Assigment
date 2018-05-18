package com.example.demo.model;

import com.example.demo.entity.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodModel extends
        PagingAndSortingRepository<Food, Integer> {
}
