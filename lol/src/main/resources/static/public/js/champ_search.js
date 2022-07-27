$("#search_champ").click(function(){
	let name = $("#search_area").val();
	let url = "/champs/detail/champ_name/"+name;
	
	$.ajax({
		type : "get",
		url : "/champs/detail/champ_name/"+name,
		success:function(){
			location.href = url
		}
	})
	
});
