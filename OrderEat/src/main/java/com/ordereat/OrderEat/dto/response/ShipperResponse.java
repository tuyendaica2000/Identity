package com.ordereat.OrderEat.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShipperResponse {
    long id;
    String name;
    String phone;
    String email;
}
