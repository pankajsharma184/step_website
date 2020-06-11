

$("#addExtractionTypes").click(function () {	
    $("#extractorTable").each(function () {
    	var currentRow=this.tBodies[0].rows.length;    	
        var tds = '<tr '+$('tr:last').attr('id')+'>';
        jQuery.each($('tr:last td', this), function () { 
        	var res = $(this).html();        	
        	if(res.indexOf("stepNodeType_"+currentRow) !== -1){        		
        		res = res.split("stepNodeType_"+currentRow).join("stepNodeType_"+(currentRow+1));
        	}
        	if(res.indexOf("stepNodeIDs_"+currentRow) !== -1){        		
        		res = res.split("stepNodeIDs_"+currentRow).join("stepNodeIDs_"+(currentRow+1));
        	}
            tds += '<td>' +res+ '</td>';
        });
        tds += '</tr>';
        if ($('tbody', this).length > 0) {
            $('tbody', this).append(tds);
        } else {
            $(this).append(tds);
        }
    });
});