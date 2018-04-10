<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <meta name="generator" content="2015.0.0.309"/>
    <title>博研正通</title>
    <!-- Common scripts -->
    <script src="${resourceServer}/assets/js/jquery-1.10.1.min.js"></script>
    <script src="${resourceServer}/assets/js/bootstrap.min.js"></script>
    <!-- Page specific CSS -->
    <style type="text/css">
        .status_wrap{
            margin: 0 auto;
            background: #eee;
            width: 500px;
            padding: 50px;
            text-align: center;
            border-radius: 50px;
        }
        .status_wrap .glyphicon-ok{
            font-size: 4em;
            color: #5cb85c;
        }
        .status_wrap .glyphicon-remove{
            font-size: 4em;
            color: #ad0101;
        }
        .status_wrap .status_su{
            font-size: 2em;
            color: #5cb85c;
            margin: 10px 0;
        }
        .status_wrap .status_er{
            font-size: 2em;
            color: #ad0101;
            margin: 10px 0;
        }
        .status_wrap .status_dtl{
            font-size: 1em;
            color: #888;
            margin: 10px 0 20px 0;
        }
        .status_wrap .btn{
            padding: 4px 18px;
            background-color: #d8d8d8 !important;
            border-color: #bbb !important;
            border-radius: 18px !important;
            -webkit-transition: all 0.3s;
            -moz-transition: all 0.3s;
            -o-transition: all 0.3s;
            transition: all 0.3s;
        }
        .status_wrap .btn:hover{
            background-color: #c7c7c7 !important;
        }
    </style>
</head>
<body class="dtlpg">
<div class="sortpg">
    <div class="sort">
        <div class="c900 content">
            <div class="status_wrap">
                <span class="glyphicon glyphicon-remove"></span>
                <div class="status_er">操作失败</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
