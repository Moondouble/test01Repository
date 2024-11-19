package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTO {
	String goodsNum;
	int cartQty;
	String memberNum;
	Date cartDate;
}
