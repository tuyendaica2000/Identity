package com.ordereat.OrderEat.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShipperCreationRequest {
    @Size(min = 5, message = "NAME_INVALID")
    String name;

    @Size(min = 8, message = "PHONE_INVALID")
    String phone;
    String email;
}
