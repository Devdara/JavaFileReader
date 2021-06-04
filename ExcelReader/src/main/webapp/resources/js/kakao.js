/**
 *   카카오맵 API 연동 js
 */
window.onload = function() {
	console.log('kakao.js - window onload 호출~!');
	
	// 도로명 data 조회 버튼 클릭시
	document.getElementById('btnGetRoadData').onclick = function() {
		console.log('btnGetRoadData');
		getRoadData();
	}
}

function getRoadData(){
	console.log('# getRoadData');
	var formData;
	callAjax('POST', '/road', formData, getRoadDataCallBack);
}

function getRoadDataCallBack( result ){
	console.log('# getRoadDataCallBack');
	console.log(result);
}