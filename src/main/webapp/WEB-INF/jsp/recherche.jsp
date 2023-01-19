<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp" />


<div class="content-page rtl-page">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12 col-lg-6">
                <div class="card">
                    <div class="card-header d-flex justify-content-between">
                        <div class="header-title">
                            <h4 class="card-title">Insertion Information</h4>
                        </div>
                    </div>
                    <div class="card-body">
                        <form method="post" action="http://localhost:8080/getrechercher">

                            <p><input  type="hidden" value="${user.id}" name="user"></p>

                            <c:forEach var="criterec" items="${criterechiffre}">
                                <div class="form-group">
                                    <label>${criterec.nom} min</label>
                                    <input type="number" name="${criterec.nom}min" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>${criterec.nom} max </label>
                                    <input type="number" name="${criterec.nom}max" class="form-control" >
                                </div>
                                <div class="form-group">
                                    <label>${criterec.nom} coefficient </label>
                                    <input type="number" name="${criterec.nom}coeff" class="form-control" >
                                </div>
                            </c:forEach>
                            <c:forEach var="criterel" items="${criterelettre}">
                                <div class="form-group">
                                    <label>${criterel.nom}</label>
                                    <select class="form-control mb-3" name="${criterel.nom}">
                                        <c:forEach var="criterev" items="${criterel.valeurCriteres}">
                                            <option value="${criterev.id}">${criterev.valeur}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>${criterel.nom} coefficient</label>
                                    <input type="number" name="${criterel.nom}coeff" class="form-control" >
                                </div>
                            </c:forEach>
                            <input type="submit" class="btn btn-primary" value="enregistrer">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />