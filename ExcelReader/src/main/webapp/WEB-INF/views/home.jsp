<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오맵 API 연동하기</title>
<script src="/resources/js/ajax.js"></script>
<script src="/resources/js/kakao.js"></script>
</head>

<body>

<!-- 도로명 Data 가져오기 -->
<div>
	<button type="button" id="btnGetRoadData">도로명 Data 조회하기</button>
</div>
<!-- 도로명으로 위도 경도 구하기 -->
<div>
	<input type="text" id="roadName"
			 placeholder="도로명을 입력하세요"/>
	<button type="button">맵 조회</button>
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
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    }
    
    // 검색결과, 위도, 경도 가져오기
    console.log( result[0] );
    console.log( '위도 : ' + result[0].y );
    console.log( '경도 : ' + result[0].x );
    
});

</script>
</body>

</html>