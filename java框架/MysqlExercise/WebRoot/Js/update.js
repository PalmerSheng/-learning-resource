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
	function updateAjax(updateName,updateAge) {
		
		initAJAX();
		var url = "/MysqlExercise/servlet/UpdateSql";
		xmlHttp.open("POST", url, true);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8;");
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				infoDiv.innerHTML = xmlHttp.responseText;
			}
		}
		xmlHttp.send("updateName="+updateName+"&updateAge="+updateAge);

	}