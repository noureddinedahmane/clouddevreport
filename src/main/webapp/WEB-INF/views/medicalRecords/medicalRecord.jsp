<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              Medical Record
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        

          
         <div class="row">
        
           <div class="col-md-4 ">
            <div class="info-box medicalFolder Nutrition_history_from">
                 <div class="img_container" ><img src="<c:url value="/resources/dist/img/folder.png"/>" /></div>
                 <div class=""><h3 class="text-center">Nutrition History Form</h3></div> 
                 <ul class="list-group list-group-unbordered">
	                <li class="list-group-item">
	                  <p class="text-center">Last update: 01:02:2016 01:34</p>
	                  <p class="text-center"> </p>
	                </li>
	              </ul>
	              <div class="">
	                <a href="#" class="btn btn-primary btn-block"><b>Go to Folder</b></a>
	              </div>
	              
            </div>    
          </div>
          
          
          <div class="col-md-4 ">
            <div class="info-box medicalFolder three_day_food_log">
                 <div class="img_container" ><img src="<c:url value="/resources/dist/img/folder.png"/>" /></div>
                 <div class=""><h3 class="text-center">Three Day Food Log</h3></div> 
                 <ul class="list-group list-group-unbordered">
	                <li class="list-group-item">
	                  <p class="text-center">Last update: 01:02:2016 01:34</p>
	                  <p class="text-center"> </p>
	                </li>
	              </ul>
	              <div class="">
	                <a href="#" class="btn btn-primary btn-block"><b>Go to Folder</b></a>
	              </div>
            </div>  
              
          </div>
          
          
          <div class="col-md-4">

	         <!-- Profile Image -->
	         <div class="box box-primary">
	            <div class="box-body box-profile">
	              <img class="profile-user-img img-responsive img-circle" src="<c:url value='/resources/dist/img/user4-128x128.jpg'/>">
	
	              <h3 class="profile-username text-center">Nina Mcintire</h3>
	
	              <p class="text-muted text-center">Software Engineer</p>
	
	              <ul class="list-group list-group-unbordered">
	                <li class="list-group-item">
	                  <b>Infos</b> <a class="pull-right"></a>
	                </li>
	              </ul>
	
	              <a href="#" class="btn btn-primary btn-block"><b>Go to Profile</b></a>
	            </div>
	            <!-- /.box-body -->
	          </div>
          
          </div>
          
         </div>
          
          <div class="row">
          
	          <div class="col-md-4">
	            <div class="info-box medicalFolder food_preference_questionnaire">
	                 <div class="img_container" ><img src="<c:url value="/resources/dist/img/folder.png"/>" /></div>
	                 <div class=""><h3 class="text-center">Food Preferences Questionnaire</h3></div> 
	                 <ul class="list-group list-group-unbordered">
		                <li class="list-group-item">
		                  <p class="text-center">Last update: 01:02:2016 01:34</p>
		                  <p class="text-center"> </p>
		                </li>
		              </ul>
		              <div class="">
		                <a href="#" class="btn btn-primary btn-block"><b>Go to Folder</b></a>
		              </div>
		              
	            </div>    
             </div>
             
	         <div class="col-md-8">
	          <div class="box box-primary">
	            <div class="box-header" style="padding-bottom:18px;">
	              <h3 class="box-title">Regime List</h3>
	
	              <div class="box-tools">
	               <a href="newRegime?idPatient=${idPatient}"><button type="button"  class="btn btn-block btn-success"> <i class="fa fa-plus" style="margin-right:2px;"></i>New Regime</button></a> 
	              </div>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body table-responsive no-padding">
	              <table class="table table-hover">
	                <tr>
	                  <th>Title</th>
	                  <th>Last update</th>
	                  <th>Activation</th>
	                  <th style="width:60px;">Actions</th>
	                </tr>
	                
	                 <c:choose>
	                     <c:when test="${listRegimes!=null}">
	                     
	                       <c:forEach items="${listRegimes}" var="regime">
	                          <tr>
	                            <td>${regime.title }</td>
	                            <td>${regime.lastUpdate }</td>
	                            <td>
		                             <c:choose>
		                               <c:when test="${regime.active}">
		                                  <i class="fa fa-fw fa-check regime_active"></i>
		                               </c:when>
		                             </c:choose>
	                             </td>
	                             <td>
	                                <a href="editRegime?idRegime=${regime.idRegime}"><i class="fa fa-edit"></i></a>
	                                <i class="fa fa-trash delete_icon confirm-delete" data-url="deleteRegime?idRegime=${regime.idRegime}"></i>
	                             </td>
	                           </tr>
	                       </c:forEach>
	 
	                     </c:when>
	                     
	                  </c:choose>

	              </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
	          <!-- /.box -->
	        </div>
        
          
          </div>     
        
         
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>
 
 <%@include file="../modal.jsp" %>
 
 <!-- delete MODAL -->
<script  src="<c:url value="/resources/js/deleteModal.js"/>" ></script>