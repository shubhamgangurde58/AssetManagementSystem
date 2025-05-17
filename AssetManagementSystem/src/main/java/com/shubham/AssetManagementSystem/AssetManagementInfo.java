package com.shubham.AssetManagementSystem;
	
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
	
@Entity
@Table(name="assetmanagementinfo")
public class AssetManagementInfo {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer assetId;
		String assetName;
		String assetType;
		String serialNumber;
		String purchaseDate;
		
		
		public Integer getAssetId() {
			return assetId;
		}
		public void setAssetId(Integer assetId) {
			this.assetId = assetId;
		}
		public String getAssetName() {
			return assetName;
		}
		public void setAssetName(String assetName) {
			this.assetName = assetName;
		}
		public String getAssetType() {
			return assetType;
		}
		public void setAssetType(String assetType) {
			this.assetType = assetType;
		}
		public String getSerialNumber() {
			return serialNumber;
		}
		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}
		public String getPurchaseDate() {
			return purchaseDate;
		}
		public void setPurchaseDate(String purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
		
		

}
