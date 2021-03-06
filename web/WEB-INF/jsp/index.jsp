<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="description" content="Web Demo">
<meta name="author" content="Web Corporation">
<title>Web Demo</title>
</head>
<body>
<div id="main">

</div>

<script id="mainTemplate" type="text/x-jsrender">
	<h3>{{:msg}}</h3> 
	<p>Custom Date:{{date:datetime parse="YYYYMMDD" format="YYYY年MM月DD日"}}</p>
	<p>Tomorrow:{{:~addDays(1)}} </p>
</script>
<script src="/components/jquery/jquery.min.js"></script>
<script src="/components/jqueryui/jquery-ui.min.js"></script>
<script src="/components/class.support/class.support.min.js"></script>
<script src="/components/jsviews/jsviews.min.js"></script>
<script src="/components/moment/moment.min.js"></script>
<script src="/scripts/tags/webtag.js"></script>
<script src="/scripts/converters/date.js"></script>
<script src="/scripts/helpers/date.js"></script>
<script src="/scripts/web/main.js"></script>
<script src="/scripts/web/g.js"></script>

</body>
</html>