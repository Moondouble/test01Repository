package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.Data;
@Data
public class PurchaseDTO {
	String purchaseName;
	String purchaseNum;
	String deliveryName;
	String deliveryAddr;
	String deliveryAddrDetail;
	String deliveryPost;
	String deliveryPhone;
	String message;
	String purchaseStatus;
	String memberNum;
	Date purchaseDate;
	Long purchasePrice;
}
