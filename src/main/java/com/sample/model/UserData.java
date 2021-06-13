package com.sample.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserData {
    @Builder.Default private String name = "";
    @Builder.Default private String email = "";
    @Builder.Default private String phone = "";
}
