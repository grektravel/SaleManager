<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Products</title>

<link rel="stylesheet" href='<c:url value="/resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
       href='<c:url value="/resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" 
       href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>
<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
       
        <div id="productDialog" style="display: none;">
            <%@ include file="productForm.jsp"%>
        </div>

        <h1>List Of Products</h1>

        <button class="pure-button pure-button-primary" onclick="addProduct()">
            <i class="fa fa-plus"></i> Add Product
         </button>
         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="4%">N</th>
                  <th width="20%">Name</th>
                  <th width="20%">Price</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${productList}" var="product" varStatus="loopCounter">
               <tr>
                   <td><c:out value="${product.id}" /></td>
                   <td><c:out value="${product.name}" /></td>
                   <td><c:out value="${product.price}" /></td>
                   <td>
                     <nobr>
                        <button onclick="editProduct(${product.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${product.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this product?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>
     </div>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript"
       src='<c:url value="/resources/js/lib/jquery-1.10.2.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/resources/js/lib/jquery.ui.datepicker.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/resources/js/js-for-listProducts.js"/>'></script>
</body>
</html> 