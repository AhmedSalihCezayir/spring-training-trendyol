package com.trendyol.bootcamp.spring.solution.ch03.repository;

import com.trendyol.bootcamp.spring.ch03.domain.Percentage;
import com.trendyol.bootcamp.spring.ch03.domain.Restaurant;
import com.trendyol.bootcamp.spring.ch03.repository.restaurant.RestaurantRepository;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.HashMap;
import java.util.Map;

/**
 * A dummy restaurant repository implementation. Has a single restaurant "Apple Bees" with a 8% benefit availability
 * percentage that's always available.
 * 
 * Stubs facilitate unit testing. An object needing a RestaurantRepository can work with this stub and not have to bring
 * in expensive and/or complex dependencies such as a Database. Simple unit tests can then verify object behavior by
 * considering the state of this stub.
 */
public class StubRestaurantRepository implements RestaurantRepository {

	private Map<String, Restaurant> restaurantsByMerchantNumber = new HashMap<String, Restaurant>();

	public StubRestaurantRepository() {
		Restaurant restaurant = new Restaurant("1234567890", "Apple Bees");
		restaurant.setBenefitPercentage(Percentage.valueOf("8%"));
		restaurantsByMerchantNumber.put(restaurant.getNumber(), restaurant);
	}

	public Restaurant findByMerchantNumber(String merchantNumber) {
		Restaurant restaurant = (Restaurant) restaurantsByMerchantNumber.get(merchantNumber);
		if (restaurant == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return restaurant;
	}
}