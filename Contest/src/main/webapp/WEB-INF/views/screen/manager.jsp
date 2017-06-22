<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,500">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/popModal.css">
<script
	src="${pageContext.request.contextPath }/resources/js/popModal.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert titl
e here</title>
<jsp:include page="../screen/top.jsp" flush="false" />
<jsp:include page="../screen/mAside.jsp" flush="false" />
<style>
* {
	padding: 0;
	margin: 0;
}

#pre {
	min-height: 300px;
	text-align: center;
	float: left;
	position: reative;
	height: 50%;
	width: 10%;
	box-shadow:3px 3px 10px gray;
	margin-top:25px;
}

#viewer {
	text-align: center;
	min-height: 350px;
	max-height: 350px;
	float: left;
	position: reative;
	height: 50%;
	width: 50%;

}

#next {
	min-height: 300px;
	text-align: center; 
	float: left;
	position: reative;
	height: 50%;
	width: 10%;
	text-align: center;
	box-shadow:3px 3px 10px gray;
	margin-top:25px;  
}

#grandeBox {
	text-align: center;
	margin: 3% -5%;
	float: left;
	height: 80px;
	width: 79%;
}

#modify {
	text-align: center;
	margin: 0% 10%;
	float: left;
	height: 80px;
	width: 79%;
}

#form {    
	margin: 5% 0% 10% 23%;
	min-height: 300px;
}
</style>
</head>
<body>
	<c:if test="${ClaimantVo == 3}">
		<div id="confirm_content" style="display: none">
			<div class="confirmModal_content">
				현재 단계의 평가가 완료 되었습니다.<br>다음 평가를 진행하시겠습니까?
			</div>
			<div class="confirmModal_footer">
				<button type="button" class="btn btn-primary"
					data-confirmmodal-but="ok">Ok</button>
				<button type="button" class="btn btn-default"
					data-confirmmodal-but="cancel">Cancel</button>
			</div>
		</div>
	</c:if>
	<form>
		<input type='hidden' name='r_id' id='r_id' value='${r_id}'> 
		<input type="hidden" name="t_id" id="t_id" value="${t_id}">
	</form>

	<div id="form">
		<h3>작품명 : ${work.w_name }</h3>
		<div id="contain">
			<button class="btn btn-default" id="pre">
				<span class="glyphicon glyphicon-chevron-left" id="btn_pre"></span>
			</button>
			<div id="viewer">
				<img src="displayFile?fileName=${work.f_name }"
					style="max-height: 320px;margin-top:15px;width:90%;	box-shadow:3px 3px 10px #000;" onclick="onClick(this)" class="w3-hover-opacity">
			</div>
			<button class="btn btn-default" id="next">
				<span class="glyphicon glyphicon-chevron-right" id="btn_next"></span>
			</button>
		</div>

	<c:if test="${m.ep_how == 'Pass or Fail 방법' }">
		<c:if test="${get_id==null}">
			<div id="grandeBox">
				<button class="btn btn-default" id="btn_pass" data-btn="pass">Pass</button>
				<button class="btn btn-default" id="btn_fail" data-btn="fail">Fail</button>

				<div id="modify" style="display: none">
					<button class="btn btn-default" id="btn_Modify">Modify</button>
				</div>
			</div>
		</c:if>
		<c:if test="${get_id!=null}">
			<div id="grandeBox">
				<div id="modify">
					<button class="btn btn-default" id="btn_Modify">Modify</button>
				</div>
			</div>
		</c:if>
	</c:if>
	<c:if test="${m.ep_how == '상세채점 방법' }">
		good
	</c:if>
	</div>
	<div id="modal01" class="w3-modal" onclick="this.style.display='none'">
		<span class="w3-button w3-hover-red w3-xlarge w3-display-topright">&times;</span>
		<div class="w3-modal-content w3-animate-zoom">
			<img id="img01" style="width: 100%; max-height: 600px;">
		</div>
	</div>

	<script>
		function onClick(element) {
 		 document.getElementById("img01").src = element.src;
		  document.getElementById("modal01").style.display = "block";
			}
</script>

	<script>
	var check = ${b};
	if(check==true){  
	$(document).ready(function(){ 
		$('#confirm_content').confirmModal({
		topOffset : 0,
		onOkBut : function() {
			$.ajax({
				url: 'stageModify?t_id='+${t_id},
				type: 'GET',
			    dataType: "text", 
			    success: function(data) {
			       location.reload();
			    },
			    error: function(data) {
			        alert("error");
			    }
			      
				});
		},
		onCancelBut : function() {},
		onLoad : function() {},
		onClose : function() {}
		}); 
	});
	}
		$("#next").on("click", function() {
			$("form").attr("action", "next");
			$("form").attr("method", "get");
			$("form").submit();
		});
		$("#pre").on("click", function() {
			$("form").attr("action", "pre");
			$("form").attr("method", "get");
			$("form").submit();
		});
		$("#btn_pass").on("click",function(){
			var button = $("#btn_pass").attr("data-btn");
			var data = {"w_id":${work.w_id},"grande":button,"u_id":${sessionScope.u_id},"t_id":${t_id}};
			 
			$.ajax({
			url: 'grande',
			type: 'POST',
		      dataType: "text", 
		      data:JSON.stringify(data),
		      headers:{
		            "Content-Type":"application/json",
		            "X-HTTP-Method-Override":"POST"
		         },
		      success: function(data) {
		        alert("평가입력되었습니다");
		        $("form").attr("action", "next");
				$("form").attr("method", "get");
				$("form").submit();
		      },
		      error: function(data) {
		        alert("error");
		      }
		      
			});
		});
		$("#btn_fail").on("click",function(){
			var button = $("#btn_fail").attr("data-btn");
			var data = {"w_id":${work.w_id},"grande":button,"u_id":${sessionScope.u_id}};
			 
			$.ajax({
			url: 'grande',
		      type: 'POST',
		      dataType: "text", 
		      data:JSON.stringify(data),
		      headers:{
		            "Content-Type":"application/json",
		            "X-HTTP-Method-Override":"POST"
		         },
		      success: function(data) {
		        alert("평가입력되었습니다");
		        $("form").attr("action", "next");
				$("form").attr("method", "get");
				$("form").submit();
		      },
		      error: function(data) {
		        alert("error");
		      }
		      
			});
		});
		$("#btn_Modify").on("click",function(){
			var data = {"w_id":${work.w_id}};
			$.ajax({
				url: 'del_grande',
			      type: 'POST',
			      dataType: "text", 
			      data:JSON.stringify(data),
			      headers:{
			            "Content-Type":"application/json",
			            "X-HTTP-Method-Override":"POST"
			         },
			      success: function(data) {
			        alert("다시 재평가바랍니다.");
			        $("#modify").hide();
			        $("#grandeBox").show();
			        location.reload();
			      },
			      error: function(data) {
			        alert("error");
			      }
			      
				});
		});
		
	</script>
</body>
</html>