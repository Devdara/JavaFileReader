package com.study.excel.model;

public class KaiLawCodeVO {
	
	Long lowNo;                  // 데이터 순번
	String zipNo;				  // 우편번호
	String sidoNm;				  // 시도명
	String engSidoNm;		  // 시도명(영문)
	String ssgNm;               // 시군구명
	String engSsgNm;          // 시군구명(영문)
	String eubNm;               // 읍명
	String engEubNm;          // 읍명(영문)
	String roadNmCode;       // 도로명 코드
	String roadNm;              // 도로명
	String engRoadNm;        // 도로명 코드(영문)
	String udrtYn;               // 지하여부 ( 0:지상, 1:지하 )
	String buildMno;            // 건물번호 본번
	String buildSno;            // 건물번호 부번
	String buildMgNo;          // 건물 관리번호
	String muchDeliveryNm;  // 다량배달처명 
	String buildPulbicNm;     // 시군구용건물명
	String lawDongCode;     // 법정동 코드
	String lawDongNm;       //  법정동 명
	String liNm;                 //  리 명
	String admDongNm;      // 행정동 명
	String moutainYn;         // 산 여부( 0:대지, 1:산 )
	String lnbrMno;            // 지번본번(번지)
	String emdNo;             // 읍면동 일련번호
	String lnbrSno;            // 지번부번(호)
	String beforeZipNo;      // 구 우편번호
	String zipNoSerial;        // 우편번호 일련번호
	
	public Long getLowNo() {
		return lowNo;
	}
	public void setLowNo(Long lowNo) {
		this.lowNo = lowNo;
	}
	public String getZipNo() {
		return zipNo;
	}
	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}
	public String getSidoNm() {
		return sidoNm;
	}
	public void setSidoNm(String sidoNm) {
		this.sidoNm = sidoNm;
	}
	public String getEngSidoNm() {
		return engSidoNm;
	}
	public void setEngSidoNm(String engSidoNm) {
		this.engSidoNm = engSidoNm;
	}
	public String getSsgNm() {
		return ssgNm;
	}
	public void setSsgNm(String ssgNm) {
		this.ssgNm = ssgNm;
	}
	public String getEngSsgNm() {
		return engSsgNm;
	}
	public void setEngSsgNm(String engSsgNm) {
		this.engSsgNm = engSsgNm;
	}
	public String getEubNm() {
		return eubNm;
	}
	public void setEubNm(String eubNm) {
		this.eubNm = eubNm;
	}
	public String getEngEubNm() {
		return engEubNm;
	}
	public void setEngEubNm(String engEubNm) {
		this.engEubNm = engEubNm;
	}
	public String getRoadNmCode() {
		return roadNmCode;
	}
	public void setRoadNmCode(String roadNmCode) {
		this.roadNmCode = roadNmCode;
	}
	public String getRoadNm() {
		return roadNm;
	}
	public void setRoadNm(String roadNm) {
		this.roadNm = roadNm;
	}
	public String getEngRoadNm() {
		return engRoadNm;
	}
	public void setEngRoadNm(String engRoadNm) {
		this.engRoadNm = engRoadNm;
	}
	public String getUdrtYn() {
		return udrtYn;
	}
	public void setUdrtYn(String udrtYn) {
		this.udrtYn = udrtYn;
	}
	public String getBuildMno() {
		return buildMno;
	}
	public void setBuildMno(String buildMno) {
		this.buildMno = buildMno;
	}
	public String getBuildSno() {
		return buildSno;
	}
	public void setBuildSno(String buildSno) {
		this.buildSno = buildSno;
	}
	public String getBuildMgNo() {
		return buildMgNo;
	}
	public void setBuildMgNo(String buildMgNo) {
		this.buildMgNo = buildMgNo;
	}
	public String getMuchDeliveryNm() {
		return muchDeliveryNm;
	}
	public void setMuchDeliveryNm(String muchDeliveryNm) {
		this.muchDeliveryNm = muchDeliveryNm;
	}
	public String getBuildPulbicNm() {
		return buildPulbicNm;
	}
	public void setBuildPulbicNm(String buildPulbicNm) {
		this.buildPulbicNm = buildPulbicNm;
	}
	public String getLawDongCode() {
		return lawDongCode;
	}
	public void setLawDongCode(String lawDongCode) {
		this.lawDongCode = lawDongCode;
	}
	public String getLawDongNm() {
		return lawDongNm;
	}
	public void setLawDongNm(String lawDongNm) {
		this.lawDongNm = lawDongNm;
	}
	public String getLiNm() {
		return liNm;
	}
	public void setLiNm(String liNm) {
		this.liNm = liNm;
	}
	public String getAdmDongNm() {
		return admDongNm;
	}
	public void setAdmDongNm(String admDongNm) {
		this.admDongNm = admDongNm;
	}
	public String getMoutainYn() {
		return moutainYn;
	}
	public void setMoutainYn(String moutainYn) {
		this.moutainYn = moutainYn;
	}
	public String getLnbrMno() {
		return lnbrMno;
	}
	public void setLnbrMno(String lnbrMno) {
		this.lnbrMno = lnbrMno;
	}
	public String getEmdNo() {
		return emdNo;
	}
	public void setEmdNo(String emdNo) {
		this.emdNo = emdNo;
	}
	public String getLnbrSno() {
		return lnbrSno;
	}
	public void setLnbrSno(String lnbrSno) {
		this.lnbrSno = lnbrSno;
	}
	public String getBeforeZipNo() {
		return beforeZipNo;
	}
	public void setBeforeZipNo(String beforeZipNo) {
		this.beforeZipNo = beforeZipNo;
	}
	public String getZipNoSerial() {
		return zipNoSerial;
	}
	public void setZipNoSerial(String zipNoSerial) {
		this.zipNoSerial = zipNoSerial;
	}
	
	@Override
	public String toString() {
		return "KaiLawCodeVO [lowNo=" + lowNo + ", zipNo=" + zipNo + ", sidoNm=" + sidoNm + ", engSidoNm=" + engSidoNm
				+ ", ssgNm=" + ssgNm + ", engSsgNm=" + engSsgNm + ", eubNm=" + eubNm + ", engEubNm=" + engEubNm
				+ ", roadNmCode=" + roadNmCode + ", roadNm=" + roadNm + ", engRoadNm=" + engRoadNm + ", udrtYn="
				+ udrtYn + ", buildMno=" + buildMno + ", buildSno=" + buildSno + ", buildMgNo=" + buildMgNo
				+ ", muchDeliveryNm=" + muchDeliveryNm + ", buildPulbicNm=" + buildPulbicNm + ", lawDongCode="
				+ lawDongCode + ", lawDongNm=" + lawDongNm + ", liNm=" + liNm + ", admDongNm=" + admDongNm
				+ ", moutainYn=" + moutainYn + ", lnbrMno=" + lnbrMno + ", emdNo=" + emdNo + ", lnbrSno=" + lnbrSno
				+ ", beforeZipNo=" + beforeZipNo + ", zipNoSerial=" + zipNoSerial + "]";
	}
	
}
