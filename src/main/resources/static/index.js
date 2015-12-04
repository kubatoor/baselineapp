function report(v) {
//To Do
  switch(v) {
    case "0":
		$("#releasemanagement").hide();
      //Do something
      break;
    case "1":
	$("#releasemanagement").show();
      //Do somthing
      break;
    }
  }
function isObject(obj) {
   return (typeof obj === "object") && (obj !== null);
}

function isEarObject(obj) {
   return (typeof obj === "object") && (obj !== null) && "EAR_NAME" in obj;
}

function Edit(idVal) {
   $("#" + idVal + " input[type=text]").prop('disabled', false);
}

function Save(idVal) {
   $("#" + idVal + " input[type=text]").prop('disabled', true);
}

function showReleaseManagement() {
	$("#release").show();
	$("#releasemanagement").hide();
	$("#baselines").hide();
	$("#releasehistory").hide();
	$("#carid").hide();
}

function showReleaseHistory() {
	$("#release").hide();
	$("#releasemanagement").hide();
	$("#baselines").hide();
	$("#releasehistory").show();
	$("#carid").hide();
}

function showBaselines() {
	$("#release").hide();
	$("#releasemanagement").hide();
	$("#baselines").show();
	$("#releasehistory").hide();
	$("#carid").hide();
}

function renderBaseLines() {
      $.ajax({
               url: 'http://localhost:8080/baselines',
               type: 'GET',
               contentType: 'application/json',
               dataType: 'json',
               success: function(data,status)
               {

                  drawTable(data);

               }
            });
}
function drawTable(rowData) {
   for (var i = 0; i < rowData.length; i++) {
         drawRow(rowData[i]);
      }
   }
function drawRow(rowData) {
    var row = $("<tr />")
    $("#baselinestable").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + rowData.APPNAME + "</td>"));
    row.append($("<td>" + rowData.JVM + "</td>"));
    row.append($("<td>" + rowData.BASELINE + "</td>"));
    row.append($("<td>" + rowData.RELEASEDATE + "</td>"));
}

$(document).ready(function () {
	$("#releasemanagement").hide();
	$("#baselines").hide();
	$("#releasehistory").hide();
	$("#carid").show();
   var data = {
		"CSE BACKLOG 15.1": {
			"Epay": {
				"Baseline": "Baseline123",
				"FilePath": "../inet_cardwalletrest/walletrest_music_jwt_rel_2015-10-19_kh_cm/dist/websphere/app",
				"JVM": "InternetCMS2",
				"EAR_NAME": "Epay",
				"WEB_MODULE": "CardWalletRESTWeb.war",
				"REGEN_PLUGIN": "No",
				"WEBSPH_CELL": "InetMC8RWProd,InetMC8NAProd",
				"VHOST_MAPPING": "cms_rest_backend_virtualhost",
				"WEBSERV_MAPPING": "cardsvcs-rest-24000"
			},
			"EWallet": {
				"Baseline": "Baseline123",
				"FilePath": "../inet_cardwalletrest/walletrest_music_jwt_rel_2015-10-19_kh_cm/dist/websphere/app",
				"JVM": "InternetCMS3",
				"EAR_NAME": "EWallet",
				"WEB_MODULE": "EWalletRESTWeb.war",
				"REGEN_PLUGIN": "No",
				"WEBSPH_CELL": "InetRW8NAProd",
				"VHOST_MAPPING": "cms_rest_backend_virtualhost1",
				"WEBSERV_MAPPING": "banksvcs-rest-20000"
			}
		}
	};
	var panelGroupTmpl = $("#panelGroupTemplate").html();
	var panelTmpl = $("#panelTemplate").html();
	var panelEarTmpl = $("#panelEarTemplate").html();
	var earGroupId = 0;
	 function getPanelHtml(data, parentkey) {
      if (isEarObject(data)) {
         var idVal = "group" + earGroupId++;
         var tmpPanelEarTmpl = panelEarTmpl.replace(/{{id}}/g, idVal);
         for (var key in data) {
            var variable = "{{" + key + "}}";
            var value = data[key];
            tmpPanelEarTmpl = tmpPanelEarTmpl.replace(variable, value);
         }
         return tmpPanelEarTmpl;
      } else if (isObject(data)) {
         var tmpPanelGroupTmpl = panelGroupTmpl.replace(/{{groupid}}/g, parentkey ? parentkey : "rootR");
         var tmpPanelBodyTmpl = "";
         for (var key in data) {
            var idVal = key.replace(/[\. ,:-]+/g, "-");
            var tmpPanelTmpl = panelTmpl.replace(/{{title}}/g, key);
            tmpPanelTmpl = tmpPanelTmpl.replace(/{{id}}/g, idVal);
            tmpPanelTmpl = tmpPanelTmpl.replace(/{{parentid}}/g, parentkey ? parentkey : idVal);
            var body = data[key];
            var bodyHtml = getPanelHtml(body, idVal);
            tmpPanelTmpl = tmpPanelTmpl.replace("{{body}}", bodyHtml);
            tmpPanelBodyTmpl = tmpPanelBodyTmpl.concat(tmpPanelTmpl);
         }
         return tmpPanelGroupTmpl.replace(/{{panel}}/g, tmpPanelBodyTmpl);
      }
   }
    $("#container").append(getPanelHtml(data));
	renderBaseLines();
   //showReleaseManagement();
});


