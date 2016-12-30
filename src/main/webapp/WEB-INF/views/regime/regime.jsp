<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
              Edit Diet
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        

        <form:form action="saveRegime" modelAttribute="regime" method="post">
         <input type="hidden" name="idPatient" value="${idPatient}">
         <form:hidden path="idRegime"/>
         <div class="row">
          
           <div class="col-md-8">

	         <!-- Profile Image -->
	         <div class="box box-primary">
	            <div class="box-body">
	            
	               <div class="form-group">
                      <label for="title" class="control-label">Title</label>
	                  <form:input type="text" cssClass="form-control" path="title"  placeholder="Title..." />
				   </div>
				   
				   <div class="form-group">
                      <label for="title" class="control-label">Description</label>
	                  <form:textarea path="note" cssClass="form-control" rows="5"/>
				   </div>
				   
				   <!-- checkbox -->
                  <div class="form-group">
	                <label>
	                  <form:checkbox path="active" class="flat-red"/>
	                  Activate Diet
	                </label>
                 </div>
				   
	            </div>
	            <!-- /.box-body -->
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
         
	        <div class="col-md-12">
		          <div class="box box-primary table-responsive no-padding">
		            <div class="box-header with-border">
		              <h3 class="box-title">Save Diet</h3>
		            </div>
		            <!-- /.box-header -->
		            <div class="box-body">
		              <table class="table table-bordered">
			                <tr>
			                  <th style="width: 10px"></th>
			                  <th>MATIN</th>
			                  <th>MIDI</th>
			                  <th>SOIR</th>
			                 </tr>
			                 <tr>
			                    <td>MONDAY</td>
			                    <td><form:textarea path="matinLUN" cssClass="form-control regimeTextarea" placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="mediLUN" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="soirLUN" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                 </tr>
			                 <tr>
			                    <td>Tuesday</td>
			                    <td><form:textarea path="matinMAR" cssClass="form-control regimeTextarea" placeholder="Enter Food elements..." /></td>
			                    <td><form:textarea path="mediMAR" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..." /></td>
			                    <td><form:textarea path="soirMAR" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."  /></td>
			                 </tr>
			                 <tr>
			                    <td>WEDNESDAY</td>
			                    <td><form:textarea path="matinMER" cssClass="form-control regimeTextarea" placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="mediMER" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="soirMER" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                 </tr>
			                 <tr>
			                    <td>THURSDAY</td>
			                    <td><form:textarea path="matinJEU" cssClass="form-control regimeTextarea" placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="mediJEU" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="soirJEU" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                 </tr>
			                 <tr>
			                    <td>FRIDAY</td>
			                    <td><form:textarea path="matinVEN" cssClass="form-control regimeTextarea" placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="mediVEN" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="soirVEN" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                 </tr>
			                 <tr>
			                    <td>SATURDAY</td>
			                    <td><form:textarea path="matinSAM" cssClass="form-control regimeTextarea" placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="mediSAM" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="soirSAM" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                 </tr>
			                 <tr>
			                    <td>SUNDAY</td>
			                    <td><form:textarea path="matinDEM" cssClass="form-control regimeTextarea" placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="mediDEM" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                    <td><form:textarea path="soirDEM" cssClass="form-control regimeTextarea"  placeholder="Enter Food elements..."/></td>
			                 </tr> 

		                </table>
		             </div>
		          </div>   
	         </div>
	         
	         <div class="col-md-12">
		              <button type="submit" value="save" class="btn btn-primary pull-right" style="margin-left:3px;">Save</button>
		              <a href="medicalRecord?patient=${idPatient}"><button type="button" class="btn btn-danger pull-right">Cancel</button></a>
		      </div>
	       </div> <!-- end row -->
         
       </form:form>
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>