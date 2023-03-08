<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>API 샘플 화면</title>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rprgy9mgul
	&submodules=geocoder"></script>
</head>
<body>
	<h1>api 샘플</h1>
	<h2>네이버 지도</h2>
	<!-- 1. HTML 코드 있어야함 -->
	<div id="map" style="width: 100%; height: 400px;"></div>

	<script type="text/javascript">
		/* 2. HTML 코드 위에 그려주는 JS라이브러리 코드 필요 */
		var mapOptions = { /* 위도 , 경도 */
			center : new naver.maps.LatLng(37.505654, 126.907013),
			zoom : 15
		/* 줌 level */
		};

		var map = new naver.maps.Map('map', mapOptions);

		var marker = new naver.maps.Marker({
			position : new naver.maps.LatLng(37.505654, 126.907013),
			map : map
		});

		var contentString = "<div style='color:red'>인포윈도우</div>";
		var infowindow = new naver.maps.InfoWindow({
			content : contentString
		});
		infowindow.open(map, marker); // 열기

		naver.maps.Event.addListener(map, "click", function(e) {
			// 지도 클릭의 경우 닫기
			// 클릭한 지점으로 마커 옮기기
			marker.setPosition(e.coord);
			if (infowindow != null) {
				if (infowindow.getMap()) {
					infowindow.close();
				}
			}
			naver.maps.Service.reverseGeocode({
				// 바꾸고싶은 위도 경도
				location : new naver.maps.LatLng(e.coord.lat(), e.coord.lng())
			},function(status, response){
				/* console.log(response); */
				var result = response.result;
				/* console.log(response); */
				var items = result.items;
				var address = items[1].address;
				contentString = address;
			});
			
		});

		naver.maps.Event.addListener(marker, "click", function(e) {
			// 마커 클릭의 경우 닫기
			if (infowindow != null) {
				if (infowindow.getMap()) {
					infowindow.close();
				} else {
					// 닫혀있으면 다시 열도록
					infowindow = new naver.maps.InfoWindow({
						content : contentString
					});
					infowindow.open(map, marker);
				}
			}
		});
	</script>
</body>
</html>