<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">


    <link rel="StyleSheet" href="resources/css/100.css" />
    <link rel="shortcut icon" href="http://i.jobkorea.kr/contest/images/Common/RB2.ico" />

   
    <meta http-equiv="imagetoolbar" content="no">
    <meta name="verify-v1" content="UKWeA341x+qh1YxCFUrfTgQpQ4B/nSfe4Z3ofWT0SYA=">
   

        
        <link type="text/css" rel="stylesheet" href="http://i.jobkorea.kr/contest/css/common.css?201702170930">
        <link type="text/css" rel="stylesheet" href="http://i.jobkorea.kr/contest/css/contest.css?201702170930">
        

       
 







    </head>
    <body id="cm">

       
          







                <br>
                <br>
                <nav id="nav" class="navbar-fixed-top">
               


<ul class="gnb" id="devGnb" >
<li class="lank ">  <a href="./home"><img src="../resources/images/logo.JPG" style="height:50px;border-radius: 50%;" ></a>
                    </li>
    <li id="devGnbMenuContest" class="info on devActive">
        <a id="devGnbMenuAllBtn" href="contestList" class="mn">공모전 현황<span></span></a>
        
    </li>
    <li class="lank ">   <a href="AllTeamList?Conlist=1&permit=1" class="mn">공모전 팀모집</a>
                    </li>
    <li class="pool" style="width:100px;"><a href="registTeam?Conlist=3" class="mn">개최하기</a>
                    </li>
    <li class="my "> <a href="AllTeamList?Conlist=3&permit=1" class="mn">심사위원 모집</a></li>
    <li class="host "><a href="AllTeamList?Conlist=0&permitt=1" class="mn">Team</a>
			</li>
<li class="host ">
                        <a href="AllTeamList?Conlist=0&permit=2" class="mn">Team Work</a>
                    </li>
			<li class="host ">
                        <a href="listPage" class="mn">커뮤니티</a>
                    </li>
                     <li class="pool" style="width:80px;">
                       <a href="PlaceList" class="mn" >장소대여</a>
                    </li>
</ul>
<c:if test="${empty sessionScope.u_id}">
		 <ul class="nav navbar-nav navbar-right" style="margin:-50px 30px;" >
	 
	        <li><a href="join"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	        <li><a data-toggle="modal" data-target="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      </ul>
       
      
</c:if>
<c:if test="${not empty sessionScope.u_id}"> <!-- sessionScopre.id가 있으면 -->
  <script>

  </script>
  <ul class="nav navbar-nav navbar-right ">
<li style="color: black; margin:-25px 90px;"> ${sessionScope.u_id}님 환영합니다</li>
          <li style="color: black; margin:-40px 20px"><a href=""><span class="glyphicon glyphicon-my-info"></span> mypage</a></li>
         <li style="color: black; margin:-40px -40px"><a href="logout"><span class="glyphicon glyphicon-log-in"></span> logout</a></li>

</ul>

</c:if>
                </nav>
               
              <div id="login" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
      <div class="modal-header">
             <legend>로그인</legend>
   
       <div class="login-box well">
        <form accept-charset="UTF-8" role="form" method="post" action="login">
     
            <div class="form-group">
                <label for="id"> 아이디</label>
                <input name="u_id" value='' id="u_id" placeholder="user_id" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="pass">비밀번호</label>
                <input name="u_pass" id="pass" value='' placeholder="Password" type="password" class="form-control" />
                
            </div>
           
              <div class="checkbox">
      <label><input type="checkbox"> Remember me</label><br><br><br>
      </div>
            <div class="form-group" align="center" >
                <input type="submit" class="btn btn-default btn-login-submit btn-block m-t-md" value="Login" id="logins"/>
            </div>
          
        
     <span class='text-center' ><a href="missingPassword" class="text-sm">비밀번호 찾기</a></span>&nbsp;&nbsp;&nbsp;	
            <span class='text-center'>
            <a href="MIssingID" class="text-sm">아이디  찾기</a></span>
           
    
            <hr />
            
            <div class="form-group">
                <a href="join" class="btn btn-default btn-block m-t-md"> 회원가입</a>
            </div>
        </form>
      </div>
     
        </div>
      </div>
    </div>
 
     </div>






  
      

    </body>
</html>
