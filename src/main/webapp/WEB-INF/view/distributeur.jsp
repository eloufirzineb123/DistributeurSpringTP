<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>hello </h1>
        <h2> Liste des produits</h2>
        <table>
                <tr>
                    <th> Id produit</th>
                     <th> Nom</th>
                      <th> Quantité</th>
                  <th> prix</th>
                </tr>
                
                <c:forEach var="p" items="${produits}">
                <tr>
                    <td><c:out value="${p.getId()}"/></td>   
                    <td><c:out value="${p.getNom()}"/></td>
                    <td><c:out value="${p.getQuantite()}"/></td>
                    <td><c:out value="${p.getPrix()}"/></td>
                </tr>
            </c:forEach>
            </table>
        
        <p>Crédit disponible <c:out value="${balance}"/></p>
        
        
        <h3>  Commander un produit </h3>
        
        
        <h3>  ajouter un crédit</h3>
        
         <form:form method="POST" action="/addcredi" modelAttribute= "userForm"> 
             
              <p>
                    <form:label path="balance">Montant : </form:label>
                    <form:input path="balance" type="number" />
                    <form:errors path="balance" />
                </p>
                <input type="submit" value="Ajouter" />
                
            
        </form:form>
        <h4>  Achat Produit </h4>
        <form:form method="POST" action="/achat" modelAttribute= "buyForm"> 
          <p>
                    <form:label path="id">Numéro de produit : </form:label>
                    <form:input path="id" type="number" />
                    <form:errors path="id" />
                </p>
                <input type="submit" value="Acheter" />
        </form:form>
    </body>
    

</html>
