<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<title>
	</title>
	<head>
		<style>
			#frame{
				height:800px;
				width:80%;
				margin:0 auto;
				}
			#top{
				
				height:132px;
				background-image:url(img/logo.jpg);
				text-align:center;
				}
				#photo{
					top:50%;
					}
				 table{
				 	text-align:center;
    			background-color:F2F2F0;
    			}    
    			iframe{
               height:100%;
    			width:100%;
    			display:none;
    				}      
    				.on{
	              display:block;
               }
		</style>
	</head>
	<body>
		<div id="frame">
		
			<div id="top">
				<img style="width:15%; height:50%;"id="photo" src="img/2015-01-05_152647.png" />
				</div>
				<button id="button">回到导航界面</button>
			<table cellspacing="0" cellpadding="0" border=3 width=100%>
				<tr height=100px>
					<td id="queryDisplay" style="cursor:pointer" ><font size="5">二手物品交易</font></td>
					<td style="cursor:pointer" id="queryBuy"><font size="5">二手图书购买</font></td>
				</tr>
				<tr  height=600px>
   			<td colspan="2">
   				<iframe frameborder="1" id="text1" class="on" src="text.html"></iframe>
   				<iframe frameborder="1" id="display"  src="/bookstore/queryAllGoods.action"></iframe>
   				<iframe frameborder="1" id="buy" src="/bookstore/query.action"></iframe>
   				
   			</td>
   		</tr>   		
			</table>
			</div>
		</div>
	</body>
</html>
<script src="/bookstore/script/jquery-1.3.2.min.js"></script>
<script >
$(document).ready(function(){
	$("td#queryDisplay").click(function(){
		$("iframe#text1").attr("class","");
		$("iframe#display").attr("class","on");
		$("iframe#buy").attr("class","");
	});
	$("td#queryBuy").click(function(){
		$("iframe#text1").attr("class","");
		$("iframe#display").attr("class","");
		$("iframe#buy").attr("class","on");
	});
	$("#button").click(function(){
		$("iframe#text1").attr("class","on");
		$("iframe#display").attr("class","");
		$("iframe#buy").attr("class","");
	});
});
	
	
</script>