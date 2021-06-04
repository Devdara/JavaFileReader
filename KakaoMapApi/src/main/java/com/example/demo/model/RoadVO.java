package com.example.demo.model;

public class RoadVO {

	private String lawDongCode; // 동코드
	private String sidoNm; // 시도 명
	private String ssgNm; // 시군구 명
	private String lawDongNm; // 동 명 
	private String roadNm; // 도로명
	private String latitude; // 위도
	private String longitude; // 경도
	
	public String getLawDongCode() {
		return lawDongCode;
	}
	public void setLawDongCode(String lawDongCode) {
		this.lawDongCode = lawDongCode;
	}
	public String getSidoNm() {
		return sidoNm;
	}
	public void setSidoNm(String sidoNm) {
		this.sidoNm = sidoNm;
	}
	public String getSsgNm() {
		return ssgNm;
	}
	public void setSsgNm(String ssgNm) {
		this.ssgNm = ssgNm;
	}
	public String getLawDongNm() {
		return lawDongNm;
	}
	public void setLawDongNm(String lawDongNm) {
		this.lawDongNm = lawDongNm;
	}
	public String getRoadNm() {
		return roadNm;
	}
	public void setRoadNm(String roadNm) {
		this.roadNm = roadNm;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "RoadVO [lawDongCode=" + lawDongCode + ", sidoNm=" + sidoNm + ", ssgNm=" + ssgNm + ", lawDongNm="
				+ lawDongNm + ", roadNm=" + roadNm + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}