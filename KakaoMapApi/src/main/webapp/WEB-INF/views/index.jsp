<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오맵 API 연동하기</title>
<script src="js/ajax.js"></script>
<script>
// DB에서 조호된 도로명 데이터
var roadJsonObject;
var roadInfo = {};

var inputLawDongCode;

// 카카오맵
var map;
// 카카오맵 검색
var geocoder;

var delaySec = 3000;

window.onload = function() {
	console.log('kakao.js - window onload 호출~!');
	
	// 1. DB에 입력된 전체도로명 리스트 조회
	document.getElementById('btnGetDbData').onclick = function() {
		console.log('# btnGetDbData : DB에서 데이터 조회를 시작합니다');
		getRoadData();
	}
	
	// 해당 도로명의 좌표DB에 추가하기
	document.getElementById('btnUpdateRoadXY').onclick = function() {
		console.log('# btnUpdateRoadXY : 도로명으로 구한 좌표 DB에 입력하기');
		// 조회된DB데이터로 좌표구하기
		
		console.log( roadJsonObject );
		console.log( roadJsonObject.length );
		
		/*
		// for in 문 으로 json Object 출력
		for(var i=0 ; roadJsonObject.length ; i++ ) {
				console.log('sleep idx : ' + i + ', 값 : ' + roadJsonObject[i].roadNm );
				getXY( roadJsonObject[i].roadNm );
		}*/
		
		for( let i in roadJsonObject ){
			setTimeout( ()=>{
				console.log('settimeout idx : ' + i + ', 값 : ' + roadJsonObject[i].roadNm );
				getXY( roadJsonObject[i].roadNm );
			}, i * 2000 );
		}
		
	}
	
	/*
	// 2. 조회된 도로명데이터 확인해보기
	document.getElementById('btnGetRoadData').onclick = function() {	
		console.log('# btnGetRoadData : 조회된 데이터를 확인');
		console.log('데이터 길이 : ' + Object.keys(roadJsonObject).length );
		console.log( roadJsonObject );
	}
	
	// 도로명으로 카카오맵API를 사용해 좌표 구하기
	document.getElementById('btnGetRoadXY').onclick = function() {
		console.log('# btnGetRoadXY : 도로명으로 좌표구하기');
		console.log('입력된 도로명 : ' + document.getElementById('roadName').value );
		var roadName = document.getElementById('roadName').value;
		getXY( roadName );
	}*/
	
	// 주소 시, 동으로 좌표 구하기
	document.getElementById('btnGetDongSinceXY').onclick = function() {
		console.log('# btnGetDongSinceXY : 시,동으로 좌표구하기 버튼클릭');
		
		for( let i in roadJsonObject ){
			setTimeout( ()=>{
				console.log('settimeout idx : ' + i + ', 값 : ' + roadJsonObject[i].roadNm );
				// 좌표 검색어 검색어 = 시도명 + 시군구명 + 동명 
				var keyWord = roadJsonObject[i].sidoNm + ' ' + roadJsonObject[i].ssgNm + ' ' + roadJsonObject[i].lawDongNm;
				inputLawDongCode = roadJsonObject[i].lawDongCode;
				getDongSinceXY( keyWord );
			}, i * 2000 );
		}
		
		//getDongSinceXY( '홍제동' );
		
	}
	
}

// 시,동으로 API 호출
function getDongSinceXY( keyWorkd ){
	
	console.log('# getDongSinceXY / 검색어 : ' + keyWorkd );
	
	var formData = new FormData;
	callAjax('GET', 'https://dapi.kakao.com/v2/local/search/address.json?query='+keyWorkd, formData, getDongSinceXYCallBack);
}


function getDongSinceXYCallBack( result ){
	
	console.log('# getDongSinceXYCallBack');
	var data = JSON.parse(result)['documents'];
	console.log( data );
	console.log( data[0].y );
	console.log( data[0].x );
	
	var formData = new FormData;
	formData.append( 'lawDongCode', inputLawDongCode );
    formData.append( 'latitude', data[0].y );
    formData.append( 'longitude', data[0].x );

    // DB에 입력된 도로명 + API로 조회된 x,y좌표값을 담아서 전달
    updateRoadXY( formData );
}


//DB의 도로명리스트 조회
function getRoadData(){
	console.log('# DB의 도로명리스트 조회 : getRoadData');
	var formData = new FormData;
	callAjax('GET', '/road', formData, getRoadDataCallBack);
}

// DB의 도로명리스트 조회 콜백
function getRoadDataCallBack( result ){
	console.log('# DB의 도로명리스트 조회 완료되었습니다 : getRoadDataCallBack');
	roadJsonObject = JSON.parse(result);
	console.log( roadJsonObject );
}

function updateRoadData(){
	console.log('# updateRoadData');
	if( roadList.length > 0 ){
		callAjax('POST', '/road', roadList, getRoadDataCallBack);	
	}
}

function updateRoadDataCallBack(){
	console.log('# updateRoadDataCallBack');
}
</script>
</head>

<body>

<!-- DB에서 도로명 Data 가져오기 -->
<div>
	<button type="button" id="btnGetDbData">DB에서 도로명 조회</button>
</div>

<!-- 
<div>
	<button type="button" id="btnGetRoadData">도로명 Data 조회하기</button>
</div>

<div>
	<input type="text" id="roadName" placeholder="도로명을 입력하세요"/>
	<button type="button" id="btnGetRoadXY">맵 조회</button>
</div>
 -->

<!-- API로 구한 좌표를 DB에 입력하기 -->
<div>
	<button type="button" id="btnUpdateRoadXY">해당 도로명의 좌표를 DB에 추가하기</button>
</div>

<!-- 시or동으로 좌표 구하기 -->
<div>
	<button type="button" id="btnGetDongSinceXY">시or동으로 좌표 구하기</button>
</div>

<!-- 카카오맵 -->
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bc70e7dbc9befcf2be7cca4ce27503b2&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('제주특별자치도 제주시 첨단로 242', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">검색된 위치</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    }
    
    // 검색결과, 위도, 경도 가져오기
    /*
   	roadInfo = result[0];
   	roadInfo.roadName = result[0].address_name;
    var roadY = result[0].y;
    var roadX = result[0].x;
    /*
    console.log( '도로명 : ' + roadInfo.address_name );
    console.log( '위도 : ' + roadY );
    console.log( '경도 : ' + roadX );
    */
    
    // 좌표구하기
    // getXY( roadName );
    
});

// 도로명으로 좌표구하기
function getXY( roadName ){
	
	console.log('# getXY');
	console.log('좌표를 구할 도로명 : ' + roadName );
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch( roadName, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {

	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    }
	    
	    // 검색결과, 위도, 경도 가져오기
	    var apiData = {};
	    // 도로명(DB에 저장되어있는 도로명을 넣어준다, 이미 입력되어있는 도로명에 해당하는 좌표를 입력해줘야 하기 때문)
	    apiData.roadNm = roadName;
	    // 위도
	    apiData.latitude = result[0].y;
	    // 경도
	    apiData.longitude = result[0].x;
	    
	    var formData = new FormData();
	    formData.append( 'roadNm', roadName );
	    formData.append( 'latitude', result[0].y );
	    formData.append( 'longitude', result[0].x );

	    // DB에 입력된 도로명 + API로 조회된 x,y좌표값을 담아서 전달
	    updateRoadXY( formData );
	    
	});
}

// DB에 좌표업데이트 AJAX 호출
function updateRoadXY( apiData ){
	
	console.log('# updateRoadXY');
	console.log( apiData );
	callAjax( 'POST', '/road', apiData, updateRoadXY_callBack );
	
}

// DB에 좌표업데이트 AJAX 호출_CallBack
function updateRoadXY_callBack( result ){
		
	console.log('# updateRoadXY_callBack');
	console.log( 'result : ' + result );
}

</script>
<script src="js/kakao.js"></script>
</body>

</html>