package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;
@Data
public class CartListDTO {
	String goodsNum;
	int cartQty;
	String memberNum;
	Date cartDate;
	
	int totalPrice;
	String goodsName; 
	int goodsPrice;
	String goodsImage;
}