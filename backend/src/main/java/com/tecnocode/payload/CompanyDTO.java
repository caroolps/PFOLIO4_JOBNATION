package com.tecnocode.payload;

import com.tecnocode.model.Address;
import lombok.*;
import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyDTO implements Serializable {
    private Address address;

    private String name;
}
