$(function(){
	$.ajax({
		type : "get",
		url : "/champs/detail/champ_name",
		dataType : "json",
		success : function(data) {
			let champName = [];
			for(let i in data){
				champName.push(data[i].name);
			};
			
			$("#search_championB").click(function(){
				let name = $("#search_champion").val();
				let url = "/champs/detail/champ_name/"+name;
				$.ajax({
					type : "get",
					url : "/champs/detail/champ_name/"+name,
					success : function(){
						if(name == ""){
							alert("챔피언 이름을 알맞게 적어주세요.");
						}else{
							location.href = url
						};
					},
					error : function() {
						alert("챔피언 이름을 알맞게 적어주세요.");
					}
				});
			});
			
			$("input[type=text]").on('keyup', function(key){
				if(key.key == 'Enter' || key.keyCode == 13 ){
					$("#search_championB").trigger('click');
				};
			});
			
		}
	});
})