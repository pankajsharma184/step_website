$(function() {
  $("#addMore").click(function(e) {
    e.preventDefault();
	
	var res='';
	$('.GrpChild').each(function () {
		if($(this).attr("placeholder") == "Name"){
			res += $(this).val()+':';
		}
		if($(this).attr("placeholder") == "ID"){
			res += $(this).val()+'|';
		}
		
	});
	$("#result").text(res);
	
	var grpCount = $("div .group").length;
	var groupID = grpCount + 1;
	var d = $("<div/>");
	$(d).addClass("group");
	$(d).attr("id","grp"+groupID);
	var u = $("<ul/>")
    $(u).append("&nbsp;");
    var lastSTEPNodeType = $('[id="stepNodeType_field"]:last');
    var newSTEPNodeType = lastSTEPNodeType.clone(true);
    newSTEPNodeType.attr("id",)
    var lastSTEPNodeIDs = $('[id="stepNodeIDs_field"]:last');
    var newSTEPNodeIDs = lastSTEPNodeIDs.clone(true);
    //var newSTEPNodeType = $("#formExtract").find('[id="stepNodeType_field"]:last').clone()
    //var newSTEPNodeIDs = $("#formExtract").find('[id="stepNodeIDs_field"]:last').clone()
    $(d).append(newSTEPNodeType);
    $(d).append(newSTEPNodeIDs);
	$("#addMore").before(d);
	
	var recent = $("#grp"+groupID).find("input#stepNodeIDs");
	recent.val('');
  });
});

function myFunc() {
  var res='';
	$('.GrpChild').each(function () {
		if($(this).attr("placeholder") == "Name"){
			res += $(this).val()+':';
		}
		if($(this).attr("placeholder") == "ID"){
			res += $(this).val()+'|';
		}
		
	});
	$("#result").text(res);
}