package PostBody;

import java.util.ArrayList;

import TableObject.Purchase;

public class PurchaseObject {
	ArrayList<Purchase> purchaseList;
	public PurchaseObject(ArrayList<Purchase> purchaseList){
		this.purchaseList = purchaseList;
	}
	public ArrayList<Purchase> getPurchaseList(){
		return purchaseList;
	}
}
