<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.users"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
       <!-- Main Row -->
       <div class="row">
     
          <div class="col-xs-12">
     
	        <div class="box box-info">
	            <div class="box-header">
	              <h3 class="box-title"></h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <table id="patients" class="table table-bordered table-striped">
	                <thead>
	                <tr>
	                  <th> <spring:message code="label.firstName"/></th>
	                  <th> <spring:message code="label.secondName"/></th>
                      <th> <spring:message code="label.domain"/></th>
                      <th> <spring:message code="label.position"/></th>
                      <th> <spring:message code="label.roles"/></th>
                      <th> <spring:message code="label.actions"/></th>
	                </tr>
	                </thead>
	                <tbody>
	                   <c:choose >
	                       <c:when test="${listUsers!=null}">
	                           <c:forEach items="${listUsers}" var="user">
	                             <tr>	                                
	                                <td>${user.name}</td>
	                                <td>${user.prenom}</td>
									<td><a href="editDomain?idDomain=${user.domain.idDomain}"> ${user.domain.domainName} </a></td>
									<td>${user.position}</td>
									<td>ROLE_ADMIN</td>
									<td>
									   <a href="editUser?idUser=${user.idClient}">
	                                     <button type="button" class="btn btn-primary">
	                                     <spring:message code="label.edit"/></button>
	                                    </a>
									</td>
	                             </tr>
	                           </c:forEach>
	                       </c:when>
	                   </c:choose>
	                </tbody>
     
	              </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
        </div>
        <!-- /.box -->
          
        
       </div><!-- ./Main Row -->
       
    </section>
    
  </div>
  
 
 <%@include file="../footer.jsp" %>