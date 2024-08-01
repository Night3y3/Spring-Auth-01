package org.example.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.entities.UserInfo;
import org.springframework.web.bind.annotation.ModelAttribute;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends UserInfo {
    private String userName;
    private String lastName;
    private Long phoneNumber;
    private String email;
}
