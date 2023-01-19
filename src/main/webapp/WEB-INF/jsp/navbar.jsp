

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="">
  
<head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>Insta Dash | Responsive Bootstrap 4 Admin Dashboard Template</title>
      
      <!-- Favicon -->
      <link rel="shortcut icon" href="https://templates.iqonic.design/instadash/html/assets/images/favicon.ico" />
      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/backend-plugin.min28b5.css?v=2.0.0">
      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/backend28b5.css?v=2.0.0">
      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/vendor/%40fortawesome/fontawesome-free/css/all.min.css">
      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/vendor/remixicon/fonts/remixicon.css">
      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/vendor/%40icon/dripicons/dripicons.css">
      
      <link rel='stylesheet' href='<%= request.getContextPath() %>/assets/vendor/fullcalendar/core/main.css' />
      <link rel='stylesheet' href='<%= request.getContextPath() %>/assets/vendor/fullcalendar/daygrid/main.css' />
      <link rel='stylesheet' href='<%= request.getContextPath() %>/assets/vendor/fullcalendar/timegrid/main.css' />
      <link rel='stylesheet' href='<%= request.getContextPath() %>/assets/vendor/fullcalendar/list/main.css' />
      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/vendor/mapbox/mapbox-gl.css">  </head>
  <body class=" color-light ">
  
   
      <div class="iq-sidebar  rtl-iq-sidebar sidebar-default ">
          <div class="iq-sidebar-logo d-flex align-items-center justify-content-between">
              <a href="index.html" class="header-logo">
                  <img src="<%= request.getContextPath() %>/assets/images/logo.png" class="img-fluid rounded-normal light-logo" alt="logo">
                  <img src="<%= request.getContextPath() %>/assets/images/logo-white.png" class="img-fluid rounded-normal darkmode-logo" alt="logo">
              </a>
              <div class="iq-menu-bt-sidebar">
                  <i class="las la-bars wrapper-menu"></i>
              </div>
          </div>
          <div class="data-scrollbar" data-scroll="1">
            <nav class="iq-sidebar-menu">
                <ul id="iq-sidebar-toggle" class="iq-menu">
                    <li class=" ">
                          <a href="#app" class="collapsed" data-toggle="collapse" aria-expanded="false">
                              <i class="las la-mobile iq-arrow-left"></i><span>Candidat</span>
                              <i class="las la-angle-right iq-arrow-right arrow-active"></i>
                              <i class="las la-angle-down iq-arrow-right arrow-hover"></i>
                          </a>
                          <ul id="app" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                                  <li class=" ">
                                      <a href="http://localhost:8080/listeutilisateur" class="collapsed">
                                          <i class="las la-user-cog"></i><span>Liste des utilisateur</span>
                                          <i class="las la-angle-right iq-arrow-right arrow-active"></i>
                                          <i class="las la-angle-down iq-arrow-right arrow-hover"></i>
                                      </a>
                                  </li>
                                  <li class=" ">
                                      <a href="http://localhost:8080/getquestion">
                                          <i class="las la-at"></i><span>Insertion utilisateur</span>
                                          <i class="las la-angle-right iq-arrow-right arrow-active"></i>
                                          <i class="las la-angle-down iq-arrow-right arrow-hover"></i>
                                      </a>
                                      
                                  </li>
                                
                          </ul>
                    </li>

                </ul>
            </nav>
          </div>
      </div>
















    </body>
</html>
