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
        
       <!-- Main Row -->
       <div class="row">
          
          <div class="col-md-8">
           
           <div class="col-md-6 ">
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
          
          
          <div class="col-md-6 ">
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
          
          <div class="col-md-6 ">
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
          
          <div class="col-md-6 ">
              <div id="Nutrition_history_from" class="folder_infos">
                 <b>Nutrition History Form:</b> Part of Risk Factor Monitoring and Methods, this questionnaire provides background information and tools and resources for utilizing this program.
              </div>   
              <div id="food_preference_questionnaire" class="folder_infos">
                 <b>Food Preferences Questionnaire:</b> For your convenience, you may download this PDF forms below and bring relevant completed forms to the first appointment.
              </div>  
              <div id="three_day_food_log" class="folder_infos">
                 <b>Three Day Food Log:</b> A detailed Food Log is used to reflect the normal eating habits of the client. This Log provides us with information regarding the client’s food preferences and eating habits and helps your nutritionist to determine areas of strengths as well as areas of weaknesses.
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
          
          
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>