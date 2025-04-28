package service.market.authentication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import service.market.authentication.entity.User;

@Setter
@Getter
public class UpdateUserDTO extends User {
}
