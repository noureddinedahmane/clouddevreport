<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.deviations"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
        
         <form:form action="saveDeviation" modelAttribute="deviation" method="post" id="deviationForm">
              
              <!-- hidden fields -->
              <form:hidden path="idDeviation" id="deviationID"/>

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
				                      <label for="devRef" class="control-label"> <spring:message code="label.deviationRef"/><c:choose ><c:when test="${configuration.deviationRef}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:input  cssClass="form-control ${formValid.deviationRef}" path="deviationRef" id="devRef" disabled="true"/>
				                   </div>
				                 </div>
				                 <div class="col-md-2">
				                   <div class="form-group">
				                      <label for="deviationRiskCategory" class="control-label"> <spring:message code="label.deviationRiskCategory"/><c:choose ><c:when test="${configuration.deviationRiskCategory}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:input  cssClass="form-control ${formValid.deviationRiskCategory}" path="deviationRiskCategory" id="riskMatrix"/>
				                   </div>
				                 </div>		
			                  </div>
			                  
			                  <div class="row">
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="requestedBy" class="control-label"> <spring:message code="label.requestedBy"/><c:choose ><c:when test="${configuration.requestedBy}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:input  cssClass="form-control ${formValid.requestedBy}" path="requestedBy" disabled="true"/>
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="position" class="control-label"> <spring:message code="label.position"/><c:choose ><c:when test="${configuration.position}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:input  cssClass="form-control ${formValid.position}" path="position" disabled="true"/>
				                   </div>
				                 </div>		
			                  </div>
			                  
			                   <div class="row">
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="deviationType" class="control-label"> <spring:message code="label.deviationType"/><c:choose ><c:when test="${configuration.deviationType}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:select cssClass="form-control ${formValid.deviationType}" path="deviationType">
			                       		<form:options items="${listDeviationTypes}" itemLabel="deviationType" itemValue="deviationType" />
			                       		<form:option value="others"><spring:message code="label.deviationTypeOther"/></form:option>
					                  </form:select>
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="deviationTypeOther" class="control-label"> <spring:message code="label.deviationTypeOther"/></label>
					                  <form:input  cssClass="form-control ${formValid.deviationTypeOther}" path="deviationTypeOther" />
				                   </div>
				                 </div>		
			                  </div>
			                  
			                  <div class="row" style="margin-top:20px;">
				                 <div class="col-md-6">              
					                  <div class="form-group">
						                  <label for="startDatePeriod" class="control-label"> <spring:message code="label.startDatePeriod"/><c:choose ><c:when test="${configuration.startDatePeriod}"><span class="pflicht">*</span></c:when></c:choose></label>
						                  <div class="input-group">
						                    <div class="input-group-addon">
						                      <i class="fa fa-calendar"></i>
						                    </div>
						                    <form:input cssClass="form-control ${formValid.startDatePeriod}"  path="startDatePeriod" id="devStartDate"  data-inputmask="'alias': 'dd/mm/yyyy'" data-mask=""/>
						                  </div><!-- /.input group -->
						               </div>					                 
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
						                   <label for="endDatePeriod" class="control-label"> <spring:message code="label.endDatePeriod"/><c:choose ><c:when test="${configuration.endDatePeriod}"><span class="pflicht">*</span></c:when></c:choose></label>
						                  <div class="input-group">
						                    <div class="input-group-addon">
						                      <i class="fa fa-calendar"></i>
						                    </div>
						                    <form:input  cssClass="form-control ${formValid.endDatePeriod}" id="devEndDate" path="endDatePeriod" />
						                  </div><!-- /.input group -->
						            </div>
			                     </div>		
			                  </div>
			                  
			                  <div class="row" style="margin-top:20px;">
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="istZustand" class="control-label"> <spring:message code="label.istZustand"/><c:choose ><c:when test="${configuration.istZustand}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:textarea  cssClass="form-control ${formValid.istZustand}" path="istZustand" rows="8" />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="sollZustand" class="control-label"> <spring:message code="label.sollZustand"/><c:choose ><c:when test="${configuration.sollZustand}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:textarea  cssClass="form-control ${formValid.sollZustand}" path="sollZustand" rows="8" />
				                   </div>
				                 </div>		
			                  </div>
			                  
			                   <div class="row" style="margin-top:20px;">
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="product" class="control-label"> <spring:message code="label.product"/><c:choose ><c:when test="${configuration.product}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:input  cssClass="form-control ${formValid.product}" path="product" />
				                   </div>
				                 </div>
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="sollZustand" class="control-label"> <spring:message code="label.anlage"/><c:choose ><c:when test="${configuration.anlage}"><span class="pflicht">*</span></c:when></c:choose></label>
					                   <form:input  cssClass="form-control ${formValid.anlage}"  path="anlage" />
				                   </div>
				                 </div>		
			                  </div>
			                  
			                  <div class="row">
				                 <div class="col-md-6">
				                   <div class="form-group">
				                      <label for="barcode" class="control-label"> <spring:message code="label.barcode"/><c:choose ><c:when test="${configuration.barcode}"><span class="pflicht">*</span></c:when></c:choose></label>
					                  <form:input  cssClass="form-control ${formValid.barcode}" path="barcode" />
				                   </div>
				                 </div>	
			                  </div>
			                  
			                  <div class="row" style="margin-top:20px;">			               
				                 <div class="col-md-12">
				                   <fieldset>			                    
			                          <legend><spring:message code="label.attachements"/></legend>
			                          <input type="file"  value="<spring:message code="label.chooseFiles"/>">
			                       </fieldset>
				                 </div>	
			                  </div>
			                  
			                  <div class="row" style="margin-top:30px;">			               
				                 <div class="col-md-12">
				                   <fieldset>			                    
			                          <legend><spring:message code="label.reasons"/></legend>

					                   <div class="form-group">
					                      <label for="reason1" class="control-label"> <spring:message code="label.reason"/>1</label>
						                  <form:input  cssClass="form-control" path="reason1" />
					                   </div>
					                   <div class="form-group">
					                      <label for="reason2" class="control-label"> <spring:message code="label.reason"/>2</label>
						                  <form:input  cssClass="form-control" path="reason2" />
					                   </div>
					                   <div class="form-group">
					                      <label for="reason3" class="control-label"> <spring:message code="label.reason"/>3</label>
						                  <form:input  cssClass="form-control" path="reason3" />
					                   </div>
					                   <div class="form-group">
					                      <label for="reason4" class="control-label"> <spring:message code="label.reason"/>4</label>
						                  <form:input  cssClass="form-control" path="reason4" />
					                   </div>
					                   <div class="form-group">
					                      <label for="reason5" class="control-label"> <spring:message code="label.reason"/>5</label>
						                  <form:input  cssClass="form-control" path="reason5" />
					                   </div>
		                      
			                       </fieldset>
				                 </div>	
			                  </div>
			                  
			                  <c:choose >
			                      <c:when test="${approvements != null}">
					                    <div class="row" style="margin-top:30px;">			               
						                 <div class="col-md-12">
						                   <fieldset>			                    
					                          <legend><spring:message code="label.approvements"/></legend>
			
							                   <table class="table table-condensed">
							                      <tr class="tab_header">
							                         <td><spring:message code="label.groupName"/></td>
							                         <td style="width:150px;"><spring:message code="label.date"/></td>
							                         <td style="width:150px;"><spring:message code="label.approved"/></td>
							                         <td style="width:150px;"><spring:message code="label.rejected"/></td>
							                         <td><spring:message code="label.comment"/></td>
							                         <td style="width:80px;"><spring:message code="label.actions"/></td>
							                      </tr>
					
						                          <c:forEach items="${approvements}" var="approvement">
						                            <tr> 
						                               <td>${approvement.approvementGroup.label}<input type="hidden" name="approvemenID" value="${approvement.idApprovement}" class="approvementID"></td>                              
						                               <td class="approvementDate">${approvement.date}</td>
						                               <td><input type="checkbox" name="approved" class="devApproved" <c:if test="${approvement.approved == true}">checked</c:if>  ></td>
	                                                   <td><input type="checkbox" name="rejected" class="devRejected" <c:if test="${approvement.rejected == true}">checked</c:if> ></td>
	                                                   <td><input type="text" name="comment" class="devComment form-control" value="${approvement.comment}"></td>
	                                                   <td><button type="button" class="btn btn-block btn-success sendApprovement"><spring:message code="label.send"/></button></td>
						                            </tr>
						                          </c:forEach>

							                   </table>
				                      
					                       </fieldset>
						                 </div>	
					                  </div>
			                      </c:when>
						       </c:choose>
			                 
			            </div>
			            
			          <div class="box-footer">
			               <button type="button" class="btn" id="generatePDF"><spring:message code="label.pdf"/></button>
                          <button type="button" id="submitButton" class="btn btn-primary" style="margin:5px;"> <spring:message code="label.send"/></button>
                      </div>
			    
		          </div>
		          
		          <!-- /.box -->
		        </div>	        
	 
           </form:form>
   
        
       </div><!-- ./Main Row -->
       
    </section>
    
    <!-- Modal for Risk Matrix -->
   <!-- Modal -->
	<div id="riskMatrixModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title"><spring:message code="label.deviationRiskCategory"/></h4>
	      </div>
	      <div class="modal-body">
	        <%@ include file="/WEB-INF/views/riskMatrix/riskMatrixStandard.html" %>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	  <!-- Modal for messaging -->
	<div id="message" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title"><spring:message code="label.info"/></h4>
	      </div>
	      <div class="modal-body" id="message_body">
              
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	
	  </div>
	</div>
              
    
  </div>
  
 
 <%@include file="../footer.jsp" %>
 
 
  <script>
   

  $(document).on("click","#generatePDF", function(){
	  generatePDF();
  });
  
  $(document).on("input",".input_required", function(){
	  $(this).css({"border-color": "#d2d6de"});	
  });
  
   $(document).on("click","#submitButton", function(){
      if(submitForm()){
         $("#deviationForm").submit();
      }
   });
 
   $(document).on("click","#riskMatrix", function(){
	   $("#riskMatrixModal").modal();
   });
   
   $(document).on("click",".col", function(){
	   var riskMatrixValue = $(this).attr("id");
	   var value = "(x=" + riskMatrixValue[0] + ",y=" + riskMatrixValue[2] + ")";
	   
       $("#riskMatrix").val(value);
       $("#riskMatrix").css("background", $(this).css("background-color"));
	   
	   $(".col").css("border","0");
	   $(this).css({"border-color": "black", 
             "border-width":"2px", 
             "border-style":"solid"});
	    
	   $("#riskMatrixModal").modal("hide");
   });
   
   
   //choose the color of the risk value after the page has loaded
   function checkRiskCategory(){
	   var riskCategory =  $("#riskMatrix").val();
	   if(riskCategory !== ""){
		   var id = riskCategory[3] + "_" + riskCategory[7]
		   $("#riskMatrix").css("background", $("#" + id).css("background-color"));
		   $(".col").css("border","0");
		   $("#" + id).css({"border-color": "black", 
	             "border-width":"2px", 
	             "border-style":"solid"});

	   }
   }
   
   //submit the form
   function submitForm(){
	   var isFormValid = true;
	   $.each($(".input_required"), function( key, value ) {
		     if($(value).val()==""){
		    	 $(value).css({"border-color": "red"});	    	 
		    	 isFormValid = false;
		     }
		      
		 });
      
	   if(!isFormValid){
		   $("html, body").animate({ scrollTop: 0 }, "slow");
	   }
	   
	   return isFormValid;  
   }
   
   
   
   //send approvement Request
   function sendApprovementRequest(approvementID, approved, rejected, comment, elem){
	   
	   $.ajax({
			  url: "makeApprovement",
			  dataType: "json",
			  type: "GET",
			  data: {
				  approvementID:  approvementID,
				  approved: approved,
				  rejected: rejected,
				  comment: comment
			  },
			  success: function(data){
				  if(data[0] == "success"){
					  showMessage(data[1], "success");
					  $(elem).parent().parent().find(".approvementDate").html(data[2]);
					  
				  }
				  if(data[0] == "error"){
					  showMessage(data[1], "danger");
					  
					  //reset the inputs
					  $(elem).parent().parent().find(".devComment").val("");
					  $(elem).parent().parent().find(".devApproved").attr("checked", false);
					  $(elem).parent().parent().find(".devRejected").attr("checked", false);
					  
				  }
			  },
			  error: function(error, status){
				  showMessage(status, "danger");
			  }
			});
   }
   
   //send Approvement
   $(document).on("click", ".sendApprovement", function(){
	   var elem = this;
	   var deviationID = $("#deviationID").val();
	   var approvementID = $(this).parent().parent().find(".approvementID").val();
	   var approved =  $(this).parent().parent().find(".devApproved").is(":checked");
	   var rejected =  $(this).parent().parent().find(".devRejected").is(":checked");
       var comment =  $(this).parent().parent().find(".devComment").val();
       
       
	   if(deviationID != ""){
		   if((approved == rejected) && (approved==false)){
			   showMessage('<spring:message code="label.mustApproveOrReject"/>', 'danger');
	       }
	       else if((approved == rejected) && (approved==true)){
	    	   showMessage('<spring:message code="label.approveOrReject"/>', 'danger');
	       }
	       else{
	    	   
	    	   showProgressSendApprovement();
	    	   
	    	   sendApprovementRequest(approvementID, approved, rejected, comment, elem); 
	       }
	   }
	   else{
		   showMessage('<spring:message code="label.saveDeviationFirst"/>', 'danger');
		   
	   }
	 
   });
   
   $(document).on("click", ".devApproved", function(){
	   $(this).parent().parent().find(".devRejected").prop("checked",false);
   });
   $(document).on("click", ".devRejected", function(){
	   $(this).parent().parent().find(".devApproved").prop("checked",false);
   });
   
   function showProgressSendApprovement(){
      var html = "<img style='margin-left:20%;height:100px;width:100px;' src='<c:url value='/resources/page/images/progress.gif'/>'>";
      $("#message_body").html("");
	  $("#message_body").html(html);
	  $("#message").modal();
   }
   
   function showMessage(message, type){
	   var html = '<div class="alert alert-' + type + ' alert-dismissible">' +  message + '</div>';
	   $("#message_body").html("");
	   $("#message_body").html(html);
	   $("#message").modal();
   }
   
   function generatePDF(){
	   var deviationID = $("#deviationID").val();
	   if(deviationID != ""){
		   window.location.href = "generatePDF?idDeviation=" + deviationID;
	   }else{
		   showMessage('<spring:message code="label.saveDeviatonFirst"/>', 'danger');
	   }
   }
   
   
   
   //functions call
   checkRiskCategory();
   
   
  </script>
  
 <script>

  $(function () {
      $('#devStartDate').datetimepicker({
    	  format: 'YYYY-MM-DD HH:mm:ss'
      });
      $('#devEndDate').datetimepicker({
    	  format: 'YYYY-MM-DD HH:mm:ss'
      });
  });
  
</script>