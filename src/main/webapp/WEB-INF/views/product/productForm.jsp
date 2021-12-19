<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="productForm" commandName="product" method="post"
       action="${actionUrl}" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="name" placeholder="Product Name" />
          </div>
          <div class="pure-control-group">
               <label for="price">Price</label>
               <form:input path="price" placeholder="Price" maxlength="15" />
          </div>

          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>