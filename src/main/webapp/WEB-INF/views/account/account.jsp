<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.account"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
        
         <form:form action="updateAccount" modelAttribute="account" method="post">
              <form:hidden path="idAccount"/>              
	          <div class="col-md-12">
		          <div class="box box-info">
		            <div class="box-header">
		              <h3 class="box-title">
		                <small></small>
		              </h3>
		              <!-- tools box -->
		              <div class="pull-right box-tools">
		                <button type="button" class="btn btn-info btn-sm" data-widget="collapse" data-toggle="tooltip" title="Collapse">
		                  <i class="fa fa-minus"></i></button>
		              </div>
		              <!-- /. tools -->
		            </div>
		            <!-- /.box-header -->
			            <div class="box-body pad">
	
			                 <div class="row">
			                 
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.firstName"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="nom"  placeholder="First Name..." />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.secondName"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="prenom"  placeholder="Second Name..." />
				                   </div>
				                 </div>
		
			                  </div>
			                  
			                   <div class="row">
			                   
			                    <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.email"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="email"  placeholder="Email..." />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.phone"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="phone"  placeholder="Phone..." />
				                   </div>
				                 </div>
					             
					          </div> 
					          
					           <div class="row">
			                   
			                    <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.company"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="company"  placeholder="Company..." />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label class="control-label"> <spring:message code="label.language"/> <span class="pflicht">*</span></label>
					                  <form:input  cssClass="form-control" path="language"  placeholder="Language..." />
				                   </div>
				                 </div>
					             
					          </div> 
			                 
			                 <button type="submit" class="btn btn-primary" style="margin:5px;"> <spring:message code="label.send"/></button>
			                 
			            </div>
			    
		          </div>
		          
		          <!-- /.box -->
		        </div>	        
	 
           </form:form>
          
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>