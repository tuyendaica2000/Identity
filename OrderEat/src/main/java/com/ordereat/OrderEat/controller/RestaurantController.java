package com.ordereat.OrderEat.controller;

import com.ordereat.OrderEat.dto.request.ApiResponse;
import com.ordereat.OrderEat.dto.request.RestaurantCreationRequest;
import com.ordereat.OrderEat.dto.request.RestaurantUpdateRequest;
import com.ordereat.OrderEat.dto.response.RestaurantResponse;
import com.ordereat.OrderEat.entity.Restaurant;
import com.ordereat.OrderEat.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    //@Valid để nó yêu cầu xác thực các yếu tố như @Size,... ở trong: RestaurantCreationRequest
    ApiResponse<Restaurant> createRestaurant(@RequestBody @Valid RestaurantCreationRequest request){
        ApiResponse<Restaurant> apiResponse = new ApiResponse<>();
        apiResponse.setResult(restaurantService.createRestaurant(request));
        return apiResponse;
    }

    //Lay ra restaurant theo id
    @GetMapping("/{restaurantId}")
    RestaurantResponse getRestaurant(@PathVariable("restaurantId") String restaurantId){
        return restaurantService.getRestaurant(Long.parseLong(restaurantId));
    }

    // Lay ra danh sach cac Restaurant
    @GetMapping
    List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @PutMapping("/{restaurantId}")
    RestaurantResponse updateRestaurant(@PathVariable Long restaurantId, @RequestBody RestaurantUpdateRequest request){
        return restaurantService.updateRestaurant(restaurantId,request);
    }


    @DeleteMapping("/{restaurantId}")
    String deleteRestaurant(@PathVariable Long restaurantId){
        restaurantService.deleteRestaurant(restaurantId);
        return "Restaurant has been deleted --> Đã xóa thành công Restaurant.";
    }
}
