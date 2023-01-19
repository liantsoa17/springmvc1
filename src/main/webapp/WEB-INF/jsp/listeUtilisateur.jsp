<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp" />
<div id="table1">
    <div class="content-page rtl-page">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header d-flex justify-content-between">
                            <div class="header-title">
                                <h4 class="card-title">Liste des candidats</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            <div id="table" class="table-editable">
                            <span class="table-add float-right mb-3 mr-2 rtl-ml-2 rtl-mr-0">
                            </span>
                                <table class="table table-bordered table-responsive-md table-striped text-center">
                                    <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>Discours</th>
                                        <th>Point</th>

                                        <th></th>

                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="utilisateur" items="${liste}">
                                        <tr>
                                            <td>${utilisateur.nom}</td>
                                            <td>${utilisateur.prenom}</td>
                                            <td>${utilisateur.discours}</td>
                                            <td>${utilisateur.point}</td>
                                            <td><a href="http://localhost:8080/getmate/${utilisateur.id}">Voir mate</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp" />