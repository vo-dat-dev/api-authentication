package service.market.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("refresh_token")
    private String refreshToken;
} 