
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="./css/newcss.css" rel="stylesheet"/>
        <link href="./css/login.css" rel="stylesheet"/>
        <title>Blog</title>

    </head>
     <body>

        <!-- Navigation-->
        <%@include file="header.jsp" %>

        <!-- Page Header-->
        <main id="main">

            <!-- ======= Breadcrumbs ======= -->
            
            <section class="inner-page">
                <div class="container">
                            <h2 class="card-title text-center mb-4">Register</h2>
                    <div class="card">
                        <div class="card-body">
                            <form action="RegisterController" method="post">
                                <c:if test="${not empty errorMessage}">
                                    <div class="alert alert-danger" role="alert">
                                        ${errorMessage}
                                    </div>
                                </c:if>
                                <div>${error}</div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" required>
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div>
                               
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary w-100 my-3">Register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

        </main><!-- End #main -->


        <!-- Main Content-->

        <%@include file="footer.jsp" %>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>

    </body>
</html>
