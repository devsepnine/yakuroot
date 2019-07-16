<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>    
<script>
	$(function(){
		
		setTimeout(function() {
			  location.href= "<%=request.getContextPath()%>/index.do?home=1";
			}, 2000);
	});
</script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .baseball-bat, .baseball-ball{
            position:fixed;
        }
        .baseball-bat{
            top:50%;
            left:50%;
            margin-top:-150px;
            width:200px;
            height:200px;
            animation-name:bat2;
            animation-duration: 0.1s
        }
        .baseball-ball{
            top:50%;
            left:50%;
            margin-left:-40px;
            margin-top: -60px;
            width:50px;
            height:36px;
            animation-name: hit;
            animation-duration: 3s;
        }
        @keyframes bat2{
            from{
                transform:rotate(0deg);
            }
            to{
                transform:rotate(-45deg);
            }
        }
        @keyframes hit{
            0%{
                transform:scale(2);
            }
            100%{
                transform:scale(300);
            }
        }
    </style>
</head>
<body>
    <img class="baseball-bat" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkns5sWyRU8ipFrgcg6tdVnp-td1SkYwoYUJi6ABGkb9BmNKgDDQ">
    <img class="baseball-ball" src="<%=request.getContextPath() %>/img/baseball.png">
</body>
</html>