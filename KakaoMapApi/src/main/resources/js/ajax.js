/**
 * 
 */
// 바닐라JS AJAX 요청하기
function callAjax(method, url, data, callBack ) {

	console.log('# callAjax : ajax처리중');

	// XMLHttpRequest 객체 생성
	var xhr = new XMLHttpRequest();

	/*
	* onreadystatechange는 요청에 대한 응답을 받는 이벤트 리스너
	* AJAX 요청 시 XHR 객체는 각 상태별로 readyState가 바뀜
	* readyState( 처음:0, open호출시:1, send호출시:2->3->4 )
	*/
	xhr.onreadystatechange = function() {

		// readyState : 4, 요청 완료 및 응답 준비
		if ( this.readyState == 4 ) {
			// 응답데이터를 JSON객체로 변환
			var result = this.response;
			// 콜백호출
			callBack( result );
		}
	};

	xhr.open(method, url);
	xhr.setRequestHeader( 'Authorization', 'KakaoAK 082e421f543507585aff0607cb3095f1' );
	xhr.send(data); // 폼 데이터 객체 전송
}