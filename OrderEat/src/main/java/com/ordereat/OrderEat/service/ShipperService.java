package com.ordereat.OrderEat.service;

import com.ordereat.OrderEat.dto.request.ShipperCreationRequest;
import com.ordereat.OrderEat.dto.request.ShipperUpdateRequest;
import com.ordereat.OrderEat.dto.response.ShipperResponse;
import com.ordereat.OrderEat.entity.Shipper;
import com.ordereat.OrderEat.exception.AppException;
import com.ordereat.OrderEat.exception.ErrorCode;
import com.ordereat.OrderEat.mapper.ShipperMapper;
import com.ordereat.OrderEat.repository.ShipperRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;

    @Autowired
    ShipperMapper shipperMapper;

    public Shipper createShipper(ShipperCreationRequest request){

        if (shipperRepository.existsByName(request.getName())) {
            throw new AppException(ErrorCode.SHIPPER_EXISTED);
        }
        Shipper shipper = shipperMapper.toShipper(request);

        return shipperRepository.save(shipper);
    }

    public Shipper getShipper(Long id){
        return shipperRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Shipper not found. --> Không tìm thấy Shipper || Shipper không tồn tại.")
        );
    }

    //method để giúp lấy ra danh sách shipper đã tạo
    public List<Shipper> getShippers() {
        return shipperRepository.findAll();
    }

    public ShipperResponse updateShipper(Long shipperId, ShipperUpdateRequest request){
        Shipper shipper = shipperRepository.findById(shipperId).orElseThrow(
                () -> new RuntimeException("Shipper not found. --> Không tìm thấy Shipper || Shipper không tồn tại."));

        shipperMapper.updateShipper(shipper,request);
        return shipperMapper.toShipperResponse( shipperRepository.save(shipper));
    }

    public void deleteShipper(Long shipperId) {
        shipperRepository.deleteById(shipperId);
    }

}
