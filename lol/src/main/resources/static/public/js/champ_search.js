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
			
			let source = $.map(champName, function(item) {
					chosung = "";
					Hangul.d(item, true).forEach(function(strItem, index) {
						if(strItem[0] != " "){
							chosung += strItem[0];
						};
					});
					return {
						label : chosung + "|" +item,
						value : item, 
						chosung : chosung	
					}
				});
			
			$("#search_area").autocomplete({
				source : source,
				select : function(event, ui) {
					console.log(ui.item.label + "선택 완료");
				},
				focus : function(event, ui) {
					return false;
				},
				delay : 10,
				minLength : 1
			}).autocomplete( "instance" )._renderItem = function( ul, item ) {
			      return $( "<li>" ) 
			        .append( "<div>" + item.value + "</div>" )
			        .appendTo( ul );
			    };
			
			$("#search_champ").click(function(){
				let name = $("#search_area").val();
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
					$("#search_champ").trigger('click');
				};
			});
			
		}
	});
});







