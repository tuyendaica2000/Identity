package com.ordereat.OrderEat.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantCreationRequest {

    @Size(min = 5, message = "NAME_INVALID")
    String name;

    @Size(min = 8, message = "LOCATION_INVALID")
    String location;
    String info;
}
