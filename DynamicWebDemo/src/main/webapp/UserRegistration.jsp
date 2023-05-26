
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
            input {
                width: 30%;
                padding: 6px 6px;
                margin: 8px 0;
                box-sizing: border-box;
            }

            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            .col-25 {
                float: left;
                width: 25%;
                margin-top: 6px;
            }

            .col-75 {
                float: left;
                width: 75%;
                margin-top: 6px;
            }

            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
            }
        </style>
</head>
<body>
<h1>User Entry Form</h1>
        <form action="UserRegServlet" method="post">
            <div class="row">
                <div class="col-25">
                    <label for="">User Name</label>
                </div>
                <div class="col-75">
                    <input type="text" name="userName">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="">Password</label>
                </div>
                <div class="col-75">
                    <input type="password" name="password">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="">Confirm Password</label>
                </div>
                <div class="col-75">
                    <input type="password" name="confirmPassword">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="">Created_Date</label>
                </div>
                <div class="col-75">
                    <input type="date" name="createdDate">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="">Modified_Date</label>
                </div>
                <div class="col-75">
                    <input type="date" name="modifiedDate">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="">Type</label>
                </div>
                <div class="col-75">
                    <input type="text" name="type">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="">Lock Tag</label>
                </div>
                <div class="col-75">
                    <input type="text" name="lockTag">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="">status</label>
                </div>
                <div class="col-75">
                    <input type="text" name="status">
                </div>
            </div>
            <div class="row">
                <div class="col-25">

                </div>
                <div class="col-75">
                    <input type="submit" name="Add">
                </div>
            </div>
        </form>
</body>
</html>