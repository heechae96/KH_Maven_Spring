<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script defer src="./js/youtube.js"></script>
<meta charset="UTF-8">
<title>스프링 웹</title>
<style>
	.center {
		position: absolute;
		top: 60%;
		left: 47%;
		margin: -50px 0 0 -50px;
	}
	
	#indexBtn {
		position: fixed;
		text-align: center;
	}
	
	#visual-btn {
		z-index: 50;
		color: #fff;
		font-size: 20px;
		border: 2px solid #fff;
		padding: 12px 24px;
		border-radius: 5px;
		cursor: pointer;
		background-color: rgba(0, 0, 0, 0);
	}
	
	#visual-btn:hover {
		color: #ff6868;
		font-size: 20px;
		border: 2px solid #ff6868;
		padding: 12px 24px;
		border-radius: 5px;
		cursor: pointer;
	}
	
	* {
		box-sizing: board-box;
	}
	
	.video-film {
		box-shadow: rgba(0, 7, 15, 0.7) 0 0 0 9999px;
		z-index: 100;
	}
	
	.video-background {
		background: #000;
		position: fixed;
		top: 0;
		right: 0;
		bottom: 0;
		left: 0;
		z-index: -99;
	}
	
	.video-foreground, .video-background iframe {
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		pointer-events: none;
	}
	
	@media ( min-aspect-ratio : 16/9) {
		.video-foreground {
			height: 300%;
			top: -100%;
		}
	}
	
	@media ( max-aspect-ratio : 16/9) {
		.video-foreground {
			width: 300%;
			left: -100%;
		}
	}
	
	h1 {
		color: white;
	}
</style>
</head>
<body>
	<!-- <h1 style="text-align: center; color: #fff">
		<img alt="image" src="/resources/img/logo.png" style="width: 50%">
	</h1> -->
	<div id="indexBtn" class="center">
		<button id="visual-btn" onclick="location.href='/home.do'">Visit
			My WebSites</button>
	</div>

	<div class="video-film">
		<div class="video-background">
			<div id="muteYouTubeVideoPlayer"></div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script async src="https://www.youtube.com/iframe_api"></script>
	<script type="text/javascript">
		var player;

		function onYouTubePlayerAPIReady() {
			player = new YT.Player('muteYouTubeVideoPlayer', {
				videoId : 'A0fCET-KbDk',
				playerVars : {
					autoplay : 1, // Auto-play the video on load
					controls : 0
				// Show pause/play buttons in player
				// Hide video controls when playing
				},
				events : {
					onReady : function(e) {
						e.target.mute();
					}
				}
			});
		}
	</script>

	<!-- 버튼 없이 자동으로 이동 하도록 -->
	<!-- <script type="text/javascript">
		location.href = "/home.do";
	</script> -->
</body>
</html>