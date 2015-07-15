<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="/public/lib/css/normalize.css">
        <link rel="stylesheet" href="/public/lib/css/bootstrap.min.css">
        <link rel="stylesheet" href="/public/lib/css/mapPage.css">
        <link rel="stylesheet" href="/public/lib/js/jquery-ui-1.11.4/jquery-ui.min.css">
    </head>
    <body>
        <h1>CityLine 1 Floor 9 <span id="pos"></span></h1>
        <div id="mapFrame">
            <div id="imgFrame">
                <img src="/public/lib/img/CL1F9.png" id="map">
            </div>
            <canvas id="path"></canvas>
        </div>
        <p id="a"></p>
        
        <script src="/public/lib/js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
        <script src="/public/lib/js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
        <script src="/public/lib/js/mapPage.js"></script>
        <script>
        	var temp = "${cubicle}";
        	alert(temp);
        </script>
    </body>
</html>