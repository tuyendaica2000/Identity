package com.ordereat.OrderEat.service;

import com.ordereat.OrderEat.dto.request.RestaurantCreationRequest;
import com.ordereat.OrderEat.dto.request.RestaurantUpdateRequest;
import com.ordereat.OrderEat.dto.response.RestaurantResponse;
import com.ordereat.OrderEat.entity.Restaurant;
import com.ordereat.OrderEat.exception.AppException;
import com.ordereat.OrderEat.exception.ErrorCode;
import com.ordereat.OrderEat.mapper.RestaurantMapper;
import com.ordereat.OrderEat.repository.RestaurantRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantMapper restaurantMapper;

    public Restaurant createRestaurant(RestaurantCreationRequest request) {

        if (restaurantRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.RESTAURANT_EXISTED);
        }
        Restaurant restaurant = restaurantMapper.toRestaurant(request);

        return restaurantRepository.save(restaurant);
    }

    public RestaurantResponse getRestaurant(Long id){
        return restaurantMapper.toRestaurantResponse( restaurantRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Restaurant not found. --> Không tìm thấy Restaurant || Restaurant không tồn tại.")));
    }

    //method để giúp lấy ra danh sách Restaurant đã tạo
    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

    public RestaurantResponse updateRestaurant(Long restaurantId, RestaurantUpdateRequest request){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new RuntimeException("Restaurant not found. --> Không tìm thấy Restaurant || Restaurant không tồn tại."));

        restaurantMapper.updateRestaurant(restaurant, request);
        return restaurantMapper.toRestaurantResponse(restaurantRepository.save(restaurant));
    }

    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}
