var xmlHttp = "";
	function initAJAX() {
		try { //Firefox, Opera 8.0+, Safari

			xmlHttp = new XMLHttpRequest();

		} catch (e) {

			try { //Internet Explorer

				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");

			} catch (e) {

				try {

					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");

				} catch (e) {
				}

			}

		}
	}
	function delAjax(delNo) {
		//方式为post时，可以用send方法传递参数
		initAJAX();
		var url = "/MysqlExercise/servlet/DelSql";
		xmlHttp.open("POST", url, true);
		//post要设定Content-Type头信息，模拟HTTP POST方法发送一个表单，这样服务器才会知道如何处理上传的内容
		//当然也能在url后加参
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8;");
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				infoDiv.innerHTML = xmlHttp.responseText;
			}
		}
		xmlHttp.send("delNo="+delNo);

	}