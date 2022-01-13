<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>

	<!-- main -->
	  <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
  
  <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
   <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> 게시글 조회</h3>
        
        
        
        <!-- role는  html5에서 새롭게 추가된 속성 
        	ARIA라는 HTML 상세 규격  해당 태그에 대한 정의 
        	시각장애인이 리더기 사용하여 읽을때  여기가 폼테그라는걸 알려줌  -->
        <form role="form" method="post"> 
         <input type="hidden" name="bid" value="${bbsVo.bid_tb}">
        </form>
        
        <!-- BASIC FORM ELELEMNTS -->
        <div class="row mt">
          <div class="col-lg-12">
            <div class="form-panel">
              <h4 class="mb"><i class="fa fa-angle-right"></i> 글쓰기 입력사항</h4>
              <form class="form-horizontal style-form" method="post">
              
             
              
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">제목</label >
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="subject" value="${bbsVo.subject}" readonly="readonly">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">글내용 </label>
                  <div class="col-sm-10">
                    <textarea rows="10" cols="2" class="form-control" name="content" readonly="readonly" >${bbsVo.content}</textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">작성자</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="writer" value="${bbsVo.writer}" readonly="readonly">
                  </div>
                  
                  
              
        
        	
        
        		
                  
                  
                </div>
                <div class="form-group">
               	 <div class="class= col-sm-12 " align="center">
               		<button type="button" id="btn_modify" class="btn btn-primary">수정하기</button>
          			<button type="button" id="bbs_delete" class="btn btn-danger">삭제하기</button>
           			<button type="button"  id = "bbs_list" class="btn btn-info">목록으로</button>
               	</div>
             	</div>	
              </form>
            </div>
          </div>
          <!-- col-lg-12-->
        </div>
        
        <script type="text/javascript">
        
        //$는 제이쿼리라는 의미
        $(document).ready(function(){
        	
        	var frmObj = $("form[role='form']");
        	//console.log("폼태그 입니다.");
        	
        	
    
        	
         	$("#btn_modify").on("click",function(){
        		frmObj.attr("action","/bbs/modify");
        		frmObj.attr("method","get");
        		frmObj.submit();
        	});
        	
        	
        	$("#bbs_delete").on("click",function(){
        		//alert(" 진입");
        		frmObj.attr("action","/bbs/delete");
        		//frmObj.attr("method","post");
        		frmObj.submit();
        	});
        	
        
        	
        	$("#bbs_list").on("click",function(){
        	
        		
        
        	    self.location ="/bbs/list"
        	  
        	}); 
        	
        	
        	
        });
        
        
        </script>
        
        
     
        <!-- /row -->
        <!-- INLINE FORM ELELEMNTS -->
  
        <!-- INPUT MESSAGES -->
    
     
      </section>
      <!-- /wrapper -->
    </section>
    <!-- /MAIN CONTENT -->

<!--  mainEnd -->
<%@include file="../include/footer.jsp" %>
 