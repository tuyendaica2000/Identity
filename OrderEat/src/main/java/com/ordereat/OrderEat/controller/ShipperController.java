package com.ordereat.OrderEat.controller;

import com.ordereat.OrderEat.dto.request.ApiResponse;
import com.ordereat.OrderEat.dto.request.ShipperCreationRequest;
import com.ordereat.OrderEat.dto.request.ShipperUpdateRequest;
import com.ordereat.OrderEat.dto.response.ShipperResponse;
import com.ordereat.OrderEat.entity.Shipper;
import com.ordereat.OrderEat.mapper.ShipperMapper;
import com.ordereat.OrderEat.service.ShipperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipper")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @Autowired
    private ShipperMapper shipperMapper;

    @PostMapping
    ApiResponse<Shipper> createShipper(@RequestBody @Valid ShipperCreationRequest request){
        ApiResponse<Shipper> apiResponse = new ApiResponse<>();
        apiResponse.setResult(shipperService.createShipper(request));

        return apiResponse;
    }

    //Lay ra shipper theo id
    @GetMapping("/{shipperId}")
    ShipperResponse getShipper(@PathVariable("shipperId") String shipperId){
        return shipperMapper.toShipperResponse( shipperService.getShipper(Long.parseLong(shipperId)));
    }

    // Lay ra danh sach cac Shipper
    @GetMapping
    List<Shipper> getShippers() {
        return shipperService.getShippers();
    }

    // Update thong tin shipper
    @PutMapping("/{shipperId}")
    ShipperResponse updateShipper(@PathVariable Long shipperId, @RequestBody ShipperUpdateRequest request) {
        return shipperService.updateShipper(shipperId, request);
    }

    @DeleteMapping("/{shipperId}")
    String deleteShipper(@PathVariable Long shipperId) {
        shipperService.deleteShipper(shipperId);
        return "Shipper has been deleted --> Đã xóa thành công Shipper." ;
    }

}
