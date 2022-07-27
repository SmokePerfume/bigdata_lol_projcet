let main_rune_alt = main_alt.split("|");
let main_rune_img = main_img.split("|");
let main_rune_item_box = $('#main_rune_item_box');
let sub_rune_alt = sub_alt.split("|");
let sub_rune_img = sub_img.split("|");
let sub_rune_item_box = $('#sub_rune_item_box')
let stats_rune_alt = stats_alt.split("|");
let stats_rune_img = stats_img.split("|");
let stats_rune_item_box = $('#stats_rune_item_box')
let rune_rate_code = rune_rate_main_code.split("|");
let rune_rate_img = rune_rate_main_img.split("|");
let rune_game_rate = rune_wp_game_rate.split("|");
let side_rune_box1 = $('.side_rune_box1');
let rune_rate_code2 = rune_rate_main_code2.split("|");
let rune_rate_img2 = rune_rate_main_img2.split("|");
let rune_game_rate2 = rune_wp_game_rate2.split("|");
let side_rune_box2 = $('.side_rune_box2');
let rune_main_alt = rune_alt.split("|");
let rune_sub_alt = rune_alt2.split("|");
let rune_stats_alt = rune_alt3.split("|");
let spell_rate0 = summoner_spell_rate0.split("|");
let spell_rate1 = summoner_spell_rate1.split("|");
let skill_build = skill_build_main.split("|");
let skill_build_command = $('.skill_build');
let skill_build_rate = skill_build_main_rate.split("|");
let start_item = start_item_img.split("|");
let start_item_rate = start_item_allrate.split("|");
let start_item2 = start_item_img2.split("|");
let start_item_rate2 = start_item_allrate2.split("|");
let main_item_img1 = main_item_img_list1.split("|"); 
let main_item_rate1 = main_item_rate_list1.split("|");
let main_item_img2 = main_item_img_list2.split("|"); 
let main_item_rate2 = main_item_rate_list2.split("|");
let main_item_img3 = main_item_img_list3.split("|"); 
let main_item_rate3 = main_item_rate_list3.split("|");
let boots_item_rate1 = boots_item_rate_list1.split("|");
let boots_item_rate2 = boots_item_rate_list2.split("|");

// 메인룬 출력
for(let i=0; i<main_rune_alt.length; i++){
	let str;
	if(i == 0){
		str = `<div class="row_item"><div class="rune_item item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div></div>`;
		main_rune_item_box.append(str);
	};
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str);
	};
	
	if(i > 0 && i <= 4 && main_rune_alt[i] < 9999){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[1]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`;
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`;
		};
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item');
		str2.innerHTML=str;
		row_item[1].append(str2);
	};
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str);
	};
	
	if(i > 4 && i <= 7){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[2]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`;
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`;
		};
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item');
		str2.innerHTML=str;
		row_item[2].append(str2);
	};
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str);
	};
	
	if(i > 7 && i <= 10){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[3]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`;
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`;
		};
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item');
		str2.innerHTML=str;
		row_item[3].append(str2);
	};
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str);
	};
	
	if(i > 10 && i <= 13){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[4]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`;
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`;
		};
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item');
		str2.innerHTML=str;
		row_item[4].append(str2);
	};
};

// 서브룬 출력
for(let i=0; i<sub_rune_alt.length; i++){
	let str;
	if(i == 0){
		str = `<div class="row_item"><div class="rune_item item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div></div>`;
		sub_rune_item_box.append(str);
	};
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		sub_rune_item_box.append(str);
	};
	
	if(i > 0 && i <= 3){
		let row_item = $(".row_item");
		if(sub_rune_alt[i] == rune_sub_alt[1]){
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div>`;
		}else{
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`;
		};
		str2 = document.createElement('div');
		str2.classList.add('s_rune_item');
		str2.innerHTML=str;
		row_item[6].append(str2);
	};
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		sub_rune_item_box.append(str);
	};
	
	if(i > 3 && i <= 6){
		let row_item = $(".row_item");
		if(sub_rune_alt[i] == rune_sub_alt[1] || sub_rune_alt[i] == rune_sub_alt[2]){
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div>`;
		}else{
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`;
		};
		str2 = document.createElement('div');
		str2.classList.add('s_rune_item');
		str2.innerHTML=str;
		row_item[7].append(str2);
	};
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		sub_rune_item_box.append(str);
	};
	
	if(i > 6 && i <= 9){
		let row_item = $(".row_item");
		if(sub_rune_alt[i] == rune_sub_alt[2]){
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div>`;
		}else{
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`;
		};
		str2 = document.createElement('div');
		str2.classList.add('s_rune_item');
		str2.innerHTML=str;
		row_item[8].append(str2);
	};
};

// 스탯 룬 출력
for(let i=0; i<stats_rune_alt.length; i++){
	let str;
	if(i == 0){
		str = `<div class="row_item"></div>`;
		stats_rune_item_box.append(str);
	};
	
	if(i >= 0 && i <= 2){
		let row_item = $(".row_item");
		if(stats_rune_alt[i] == rune_stats_alt[0]){
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}">`;
		}else{
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)">`;
		};
		str2 = document.createElement('div');
		str2.classList.add('st_rune_item');
		str2.innerHTML=str;
		row_item[9].append(str2);
	};
	
	if(i == 0){
		str = `<div class="row_item"></div>`;
		stats_rune_item_box.append(str);
	};
	
	if(i > 2 && i <= 5){
		let row_item = $(".row_item");
		if(stats_rune_alt[i] == rune_stats_alt[1]){
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}">`;
		}else{
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)">`;
		};
		str2 = document.createElement('div');
		str2.classList.add('st_rune_item');
		str2.innerHTML=str;
		row_item[10].append(str2);
	};
	
	if(i == 0){
		str = `<div class="row_item"></div>`;
		stats_rune_item_box.append(str);
	};
	
	if(i > 5 && i <= 8){
		let row_item = $(".row_item");
		if(stats_rune_alt[i] == rune_stats_alt[2]){
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}">`;
		}else{
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)">`;
		};
		str2 = document.createElement('div');
		str2.classList.add('st_rune_item');
		str2.innerHTML=str;
		row_item[11].append(str2);
	};
	
};

// 룬 사이드박스 룬,픽률,승률
for(i=0; i<rune_rate_code.length; i++){
	let str;
	if(i == 0){
		str = `<div class="side_box"></div>`;
		side_rune_box1.append(str);
	};
	
	if(i < 3){
		let side_box = $('.side_box');
		str = `<img alt="${rune_rate_code[i]}" src="${rune_rate_img[i]}">`;
		side_box.append(str);
	};
	
	if(i == 0){
		str = `<div><span class="pick_rate">${rune_game_rate[0]}<small>${rune_game_rate[1]}</small></span><span class="win_rate"><em>${rune_game_rate[2]}</em></span></div>`;
		side_rune_box1.append(str);
	};
};

// 룬 사이드박스2 룬,픽률,승률
for(i=0; i<rune_rate_code2.length; i++){
	let str;
	if(i == 0){
		str = `<div class="side_box1"></div>`;
		side_rune_box2.append(str);
	};
	
	if(i < 3){
		let side_box = $('.side_box1');
		str = `<img alt="${rune_rate_code2[i]}" src="${rune_rate_img2[i]}">`;
		side_box.append(str);
	};
	
	if(i == 0){
		str = `<div><span class="pick_rate">${rune_game_rate2[0]}<small>${rune_game_rate2[1]}</small></span><span class="win_rate"><em>${rune_game_rate[2]}</em></span></div>`;
		side_rune_box2.append(str);
	};
};

// 스펠 픽률,승률
let pick_rate = $(".pick-rate");
let win_rate = $(".win-rate");
for(i=0; i<spell_rate0.length; i++){
	let str;
	if(i == 0){
		str = `<strong>${spell_rate0[0]}</strong><br><small>${spell_rate0[1]}</small>`;
		pick_rate.append(str);
	};
	if(i == 0){
		str = `${spell_rate0[2]}`;
		win_rate.append(str);
	};
};
// 스펠 픽률,승률2
let pick_rate2 = $(".pick-rate2");
let win_rate2 = $(".win-rate2");
for(i=0; i<spell_rate1.length; i++){
	let str;
	if(i == 0){
		str = `<strong>${spell_rate1[0]}</strong><br><small>${spell_rate1[1]}</small>`;
		pick_rate2.append(str);
	};
	if(i == 0){
		str = `${spell_rate1[2]}`;
		win_rate2.append(str);
	};
};

// 스킬빌드,커맨드값 색
let skill_all_mini1 = $("#skill_all_mini1").text();
let skill_all_mini2 = $("#skill_all_mini2").text();
let skill_all_mini3 = $("#skill_all_mini3").text();
if(skill_all_mini1 == 'Q'){
	$("#skill_all_mini1").css('color', 'rgb(0, 147, 255)');
};
if(skill_all_mini1 == 'W'){
	$("#skill_all_mini1").css('color', 'rgb(0, 215, 176)');
};
if(skill_all_mini1 == 'E'){
	$("#skill_all_mini1").css('color', 'rgb(255, 130, 0)');
};
if(skill_all_mini2 == 'Q'){
	$("#skill_all_mini2").css('color', 'rgb(0, 147, 255)');
};
if(skill_all_mini2 == 'W'){
	$("#skill_all_mini2").css('color', 'rgb(0, 215, 176)');
};
if(skill_all_mini2 == 'E'){
	$("#skill_all_mini2").css('color', 'rgb(255, 130, 0)');
};
if(skill_all_mini3 == 'Q'){
	$("#skill_all_mini3").css('color', 'rgb(0, 147, 255)');
};
if(skill_all_mini3 == 'W'){
	$("#skill_all_mini3").css('color', 'rgb(0, 215, 176)');
};
if(skill_all_mini3 == 'E'){
	$("#skill_all_mini3").css('color', 'rgb(255, 130, 0)');
};

// 스킬 커맨드 순서
for(let skill of skill_build){
	let str;
	if(skill == "Q"){
		str = `<span class="skill_command_mini_box"><strong class="skill_command_boxQ">${skill}</strong></span>`;
		skill_build_command.append(str);
	};
	if(skill == "W"){
		str = `<span class="skill_command_mini_box"><strong class="skill_command_boxW">${skill}</strong></span>`;
		skill_build_command.append(str);
	};
	if(skill == "E"){
		str = `<span class="skill_command_mini_box"><strong class="skill_command_boxE">${skill}</strong></span>`;
		skill_build_command.append(str);
	};
	if(skill == "R"){
		str = `<span class="skill_command_mini_box"><strong class="skill_command_boxR">${skill}</strong></span>`;
		skill_build_command.append(str);
	};
};

// 스킬 픽률,승률
let skill_pick_rate = $('.skill_pick_rate');
let skill_win_rate = $('.skill_win_rate');
for(let i=0; i<skill_build_rate.length; i++){
	let str;
	if(i == 0){
		str = `<strong>${skill_build_rate[0]}</strong><br><small>${skill_build_rate[1]}</small>`;
		skill_pick_rate.append(str);
	};
	if(i == 0){
		str = `${skill_build_rate[2]}`;
		skill_win_rate.append(str);
	};
};

// 시작 아이템
let start_item_img_mini_box = $('.start_item_img_mini_box');
let start_item_pick_rate = $('.start_item_pick_rate');
let start_item_win_rate = $('.start_item_win_rate');
let start_item_img_mini_box2 = $('.start_item_img_mini_box2');
let start_item_pick_rate2 = $('.start_item_pick_rate2');
let start_item_win_rate2 = $('.start_item_win_rate2');
for(let i=0; i<start_item.length; i++){
	let str;
	if(i < 2){
		str = `<div class="item_icon"><div style="position: relative;"><img src="${start_item[i]}"></div></div>`;
		start_item_img_mini_box.append(str);
	};
	if(i < 2){
		str = `<div class="item_icon"><div style="position: relative;"><img src="${start_item[i]}"></div></div>`;
		start_item_img_mini_box2.append(str);
	};
};
for(let i=0; i<start_item_rate.length; i++){
	let str;
	if(i == 0){
		str = `<strong>${start_item_rate[0]}</strong><br><small>${start_item_rate[1]}</small>`;
		start_item_pick_rate.append(str);
	};
	if(i == 0){
		str = `${start_item_rate[2]}`;
		start_item_win_rate.append(str);
	};
	if(i == 0){
		str = `<strong>${start_item_rate2[0]}</strong><br><small>${start_item_rate2[1]}</small>`;
		start_item_pick_rate2.append(str);
	};
	if(i == 0){
		str = `${start_item_rate2[2]}`;
		start_item_win_rate2.append(str);
	};
};

// 메인아이템,신발아이템
let main_item_icon = $('.main_item_icon');
let main_item_pick_rate1 = $('.main_item_pick_rate1');
let main_item_win_rate1 = $('.main_item_win_rate1');
let main_item_pick_rate2 = $('.main_item_pick_rate2');
let main_item_win_rate2 = $('.main_item_win_rate2');
let main_item_pick_rate3 = $('.main_item_pick_rate3');
let main_item_win_rate3 = $('.main_item_win_rate3');
let boots_item_pick_rate1 = $('.boots_item_pick_rate1');
let boots_item_win_rate1 = $('.boots_item_win_rate1');
let boots_item_pick_rate2 = $('.boots_item_pick_rate2');
let boots_item_win_rate2 = $('.boots_item_win_rate2');
for(let i=0; i<main_item_img1.length; i++){
	let str;
	// 메인 아이템1
	if(i == 0){
		str = `<img src="${main_item_img1[0]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[0].append(str2);
	};
	if(i == 0){
		str = `<img src="${main_item_img1[1]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[1].append(str2);
	};
	if(i == 0){
		str = `<img src="${main_item_img1[2]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[2].append(str2);
	};
	// 메인 아이템2
	if(i == 0){
		str = `<img src="${main_item_img2[0]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[3].append(str2);
	};
	if(i == 0){
		str = `<img src="${main_item_img2[1]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[4].append(str2);
	};
	if(i == 0){
		str = `<img src="${main_item_img2[2]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[5].append(str2);
	};
	// 메인 아이템3
	if(i == 0){
		str = `<img src="${main_item_img3[0]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[6].append(str2);
	};
	if(i == 0){
		str = `<img src="${main_item_img3[1]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[7].append(str2);
	};
	if(i == 0){
		str = `<img src="${main_item_img3[2]}">`;
		str2 = document.createElement('div');
		str2.classList.add('main_item_icon_mini');
		str2.innerHTML=str;
		main_item_icon[8].append(str2);
	};
	// 메인 아이템 픽률,승률1
	if(i == 0){
		str = `<strong>${main_item_rate1[0]}</strong><br><small>${main_item_rate1[1]}</small>`;
		main_item_pick_rate1.append(str);
		str = `<strong>${main_item_rate1[2]}</strong>`;
		main_item_win_rate1.append(str);
	};
	// 메인 아이템 픽률,승률2
	if(i == 0){
		str = `<strong>${main_item_rate2[0]}</strong><br><small>${main_item_rate2[1]}</small>`;
		main_item_pick_rate2.append(str);
		str = `<strong>${main_item_rate2[2]}</strong>`;
		main_item_win_rate2.append(str);
	};
	// 메인 아이템 픽률,승률3
	if(i == 0){
		str = `<strong>${main_item_rate3[0]}</strong><br><small>${main_item_rate3[1]}</small>`;
		main_item_pick_rate3.append(str);
		str = `<strong>${main_item_rate3[2]}</strong>`;
		main_item_win_rate3.append(str);
	};
	// 신발 아이템 픽률,승률
	if(i == 0){
		str = `<strong>${boots_item_rate1[0]}</strong><br><small>${boots_item_rate1[1]}</small`;
		boots_item_pick_rate1.append(str);
		str = `<strong>${boots_item_rate1[2]}</strong>`;
		boots_item_win_rate1.append(str);
		str = `<strong>${boots_item_rate2[0]}</strong><br><small>${boots_item_rate2[1]}</small`;
		boots_item_pick_rate2.append(str);
		str = `<strong>${boots_item_rate2[2]}</strong>`;
		boots_item_win_rate2.append(str);
	};
};

















