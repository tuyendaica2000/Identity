package com.ordereat.OrderEat.mapper;

import com.ordereat.OrderEat.dto.request.RestaurantCreationRequest;
import com.ordereat.OrderEat.dto.request.RestaurantUpdateRequest;
import com.ordereat.OrderEat.dto.response.RestaurantResponse;
import com.ordereat.OrderEat.entity.Restaurant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant toRestaurant(RestaurantCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setName( request.getName() );
        restaurant.setLocation( request.getLocation() );
        restaurant.setInfo( request.getInfo() );

        return restaurant;
    }

    @Override
    public RestaurantResponse toRestaurantResponse(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantResponse.RestaurantResponseBuilder restaurantResponse = RestaurantResponse.builder();

        restaurantResponse.id( restaurant.getId() );
        restaurantResponse.name( restaurant.getName() );
        restaurantResponse.location( restaurant.getLocation() );
        restaurantResponse.info( restaurant.getInfo() );

        return restaurantResponse.build();
    }

    @Override
    public void updateRestaurant(Restaurant restaurant, RestaurantUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        restaurant.setLocation( request.getLocation() );
        restaurant.setInfo( request.getInfo() );
    }
}
