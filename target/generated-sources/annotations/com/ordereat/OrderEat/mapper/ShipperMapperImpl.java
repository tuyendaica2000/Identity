package com.ordereat.OrderEat.mapper;

import com.ordereat.OrderEat.dto.request.ShipperCreationRequest;
import com.ordereat.OrderEat.dto.request.ShipperUpdateRequest;
import com.ordereat.OrderEat.dto.response.ShipperResponse;
import com.ordereat.OrderEat.entity.Shipper;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ShipperMapperImpl implements ShipperMapper {

    @Override
    public Shipper toShipper(ShipperCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Shipper shipper = new Shipper();

        shipper.setName( request.getName() );
        shipper.setPhone( request.getPhone() );
        shipper.setEmail( request.getEmail() );

        return shipper;
    }

    @Override
    public ShipperResponse toShipperResponse(Shipper shipper) {
        if ( shipper == null ) {
            return null;
        }

        ShipperResponse.ShipperResponseBuilder shipperResponse = ShipperResponse.builder();

        shipperResponse.id( shipper.getId() );
        shipperResponse.name( shipper.getName() );
        shipperResponse.phone( shipper.getPhone() );
        shipperResponse.email( shipper.getEmail() );

        return shipperResponse.build();
    }

    @Override
    public void updateShipper(Shipper shipper, ShipperUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        shipper.setPhone( request.getPhone() );
        shipper.setEmail( request.getEmail() );
    }
}
