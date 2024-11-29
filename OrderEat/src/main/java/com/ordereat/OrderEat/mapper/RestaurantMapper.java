package com.ordereat.OrderEat.mapper;

import com.ordereat.OrderEat.dto.request.RestaurantCreationRequest;
import com.ordereat.OrderEat.dto.request.RestaurantUpdateRequest;
import com.ordereat.OrderEat.dto.response.RestaurantResponse;
import com.ordereat.OrderEat.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    Restaurant toRestaurant(RestaurantCreationRequest request);
    RestaurantResponse toRestaurantResponse(Restaurant restaurant);
    void updateRestaurant(@MappingTarget Restaurant restaurant, RestaurantUpdateRequest request);
}

