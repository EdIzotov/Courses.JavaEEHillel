<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script type="text/javascript">
        function ajaxPost() {
            console.log(" >>> start");
            let user = new Object();
            user.name = $("#nameId").val();
            console.log(" >>> user.name is " + JSON.stringify(user));
            $.ajax({
                url: "/abc/usernames-ajax",
                dataType: "json",
                data: JSON.stringify(user),
                method: "POST",
                success: function(dataFromServer) {
                    console.log("dataFromServer: " + dataFromServer);
                }
            });
        }
    </script>
</head>
<body>
    <input type="text" name="name" id="nameId" />
    <input type="button" value="Add UserName" id="buttonId" onclick="ajaxPost();" />
</body>
</html>
