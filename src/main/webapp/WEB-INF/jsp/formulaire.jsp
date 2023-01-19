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
                    <form method="post" action="http://localhost:8080/getinfo">
                        <div class="form-group">
                            <label>Nom:</label>
                            <input type="text" name="nom" class="form-control" ></p>

                        </div>
                        <div class="form-group">
                            <label>Prenom:</label>
                            <input type="text" name="prenom" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Discours:</label>
                            <input type="text" name="discours" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Note recherchée:</label>
                            <input type="number" name="note" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label>Sexe</label>
                            <select class="form-control mb-3" name="sexe">
                                <option value="0">homme</option>
                                <option value="1">femme</option>
                            </select>
                        </div>
                        <c:forEach var="criterec" items="${criterechiffre}">
                            <div class="form-group">
                                <label>${criterec.nom} </label>
                                <input type="number" name="${criterec.nom}" class="form-control" >
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