package jspMVCMisoShopping.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthInfoDTO {
	String userId;
	String userPw;
	String userName;
	String userEmail;
	String grade;
}
