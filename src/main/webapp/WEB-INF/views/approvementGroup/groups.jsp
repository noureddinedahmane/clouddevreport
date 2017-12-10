<%@include file="../header.jsp" %>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  <!-- Content header-->
    <section class="content-header">
        
          <!-- list save actions -->
          <%@include file="../saveActions.jsp" %>
          
          <h1>
               <spring:message code="label.groups"/>
              <small></small>
           </h1>
    </section>
    
    <!--  Main Content -->
    <section class="content">
        
     <!-- List of domains -->
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
	                  <th> <spring:message code="label.groupName"/></th>
                      <th> <spring:message code="label.role"/></th>
                      <th> <spring:message code="label.domainName"/></th>
                      <th> <spring:message code="label.groupMail"/></th>
                      <th> <spring:message code="label.dateCreation"/></th>
                      <th> <spring:message code="label.actions"/></th>
	                </tr>
	                </thead>
	                <tbody>
	                   <c:choose >
	                       <c:when test="${listApprovementGroups != null}">
	                           <c:forEach items="${listApprovementGroups}" var="approvementGroup">
	                             <tr>
	                               <td> ${ approvementGroup.label } </td>
	                               <td> ${ approvementGroup.role } </td>
	                               <td> <a href="editDomain?idDomain=${approvementGroup.domain.idDomain}"> ${ approvementGroup.domain.domainName} </a> </td>
	                               <td> ${ approvementGroup.listEmail } </td>
	                               <td> ${ approvementGroup.dateCreation } </td>
	                               <td style="width:180px;">
	                                <a href="addUsersToGroup?idApprovementGroup=${approvementGroup.idApprovementGroup}">
	                                       <button type="button" class="btn btn-success">
	                                       <spring:message code="label.addUsers"/></button>
	                                    </a>
	                                    <a href="editApprovementGroup?idDomain=${approvementGroup.domain.idDomain}&idApprovementGroup=${approvementGroup.idApprovementGroup}">
	                                     <button type="button" class="btn btn-primary" >
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