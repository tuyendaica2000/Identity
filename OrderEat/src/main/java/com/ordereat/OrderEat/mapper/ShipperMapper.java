package com.ordereat.OrderEat.mapper;

import com.ordereat.OrderEat.dto.request.ShipperCreationRequest;
import com.ordereat.OrderEat.dto.request.ShipperUpdateRequest;
import com.ordereat.OrderEat.dto.response.ShipperResponse;
import com.ordereat.OrderEat.entity.Shipper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShipperMapper {
    Shipper toShipper(ShipperCreationRequest request);
    ShipperResponse toShipperResponse(Shipper shipper);
    void updateShipper(@MappingTarget Shipper shipper, ShipperUpdateRequest request);
}

