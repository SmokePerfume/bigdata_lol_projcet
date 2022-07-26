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


// 메인룬 출력
for(let i=0; i<main_rune_alt.length; i++){
	let str;
	if(i == 0){
		str = `<div class="row_item"><div class="rune_item item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div></div>`;
		main_rune_item_box.append(str);
	}
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str)
	}
	
	if(i > 0 && i <= 4 && main_rune_alt[i] < 9999){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[1]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`
		}
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item')
		str2.innerHTML=str;
		row_item[1].append(str2)
	}
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str)
	}
	
	if(i > 4 && i <= 7){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[2]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`
		}
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item')
		str2.innerHTML=str;
		row_item[2].append(str2)
	}
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str)
	}
	
	if(i > 7 && i <= 10){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[3]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`
		}
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item')
		str2.innerHTML=str;
		row_item[3].append(str2)
	}
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		main_rune_item_box.append(str)
	}
	
	if(i > 10 && i <= 13){
		let row_item = $(".row_item");
		if(main_rune_alt[i] == rune_main_alt[4]){
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}"></div>`
		}else{
			str = `<div class="rune_item"><img alt="${main_rune_alt[i]}" src="${main_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`
		}
		str2 = document.createElement('div');
		str2.classList.add('m_rune_item')
		str2.innerHTML=str;
		row_item[4].append(str2)
	}
}

// 서브룬 출력
for(let i=0; i<sub_rune_alt.length; i++){
	let str;
	if(i == 0){
		str = `<div class="row_item"><div class="rune_item item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div></div>`;
		sub_rune_item_box.append(str);
	}
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		sub_rune_item_box.append(str)
	}
	
	if(i > 0 && i <= 3){
		let row_item = $(".row_item");
		if(sub_rune_alt[i] == rune_sub_alt[1]){
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div>`
		}else{
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`
		}
		str2 = document.createElement('div');
		str2.classList.add('s_rune_item')
		str2.innerHTML=str;
		row_item[6].append(str2)
	}
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		sub_rune_item_box.append(str)
	}
	
	if(i > 3 && i <= 6){
		let row_item = $(".row_item");
		if(sub_rune_alt[i] == rune_sub_alt[1] || sub_rune_alt[i] == rune_sub_alt[2]){
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div>`
		}else{
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`
		}
		str2 = document.createElement('div');
		str2.classList.add('s_rune_item')
		str2.innerHTML=str;
		row_item[7].append(str2)
	}
	
	if(i > 0 && i <= 1){
		str = `<div class="row_item"></div>`;
		sub_rune_item_box.append(str)
	}
	
	if(i > 6 && i <= 9){
		let row_item = $(".row_item");
		if(sub_rune_alt[i] == rune_sub_alt[2]){
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}"></div>`
		}else{
			str = `<div class="rune_item"><img alt="${sub_rune_alt[i]}" src="${sub_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)"></div>`
		}
		str2 = document.createElement('div');
		str2.classList.add('s_rune_item')
		str2.innerHTML=str;
		row_item[8].append(str2)
	}
}

// 스탯 룬 출력
for(let i=0; i<stats_rune_alt.length; i++){
	let str;
	if(i == 0){
		str = `<div class="row_item"></div>`
		stats_rune_item_box.append(str)
	}
	
	if(i >= 0 && i <= 2){
		let row_item = $(".row_item");
		if(stats_rune_alt[i] == rune_stats_alt[0]){
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}">`
		}else{
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)">`
		}
		str2 = document.createElement('div');
		str2.classList.add('st_rune_item')
		str2.innerHTML=str;
		row_item[9].append(str2)
	}
	
	if(i == 0){
		str = `<div class="row_item"></div>`
		stats_rune_item_box.append(str)
	}
	
	if(i > 2 && i <= 5){
		let row_item = $(".row_item");
		if(stats_rune_alt[i] == rune_stats_alt[1]){
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}">`
		}else{
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)">`
		}
		str2 = document.createElement('div');
		str2.classList.add('st_rune_item')
		str2.innerHTML=str;
		row_item[10].append(str2)
	}
	
	if(i == 0){
		str = `<div class="row_item"></div>`
		stats_rune_item_box.append(str)
	}
	
	if(i > 5 && i <= 8){
		let row_item = $(".row_item");
		if(stats_rune_alt[i] == rune_stats_alt[2]){
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}">`
		}else{
			str = `<img alt="${stats_rune_alt[i]}" src="${stats_rune_img[i]}" style="opacity: 0.5;filter: grayscale(100%)">`
		}
		str2 = document.createElement('div');
		str2.classList.add('st_rune_item')
		str2.innerHTML=str;
		row_item[11].append(str2)
	}
	
}

// 룬 사이드박스 룬,픽률,승률
for(i=0; i<rune_rate_code.length; i++){
	let str;
	if(i == 0){
		str = `<div class="side_box"></div>`
		side_rune_box1.append(str)
	}
	
	if(i < 3){
		let side_box = $('.side_box');
		str = `<img alt="${rune_rate_code[i]}" src="${rune_rate_img[i]}">`
		side_box.append(str)
	}
	
	if(i == 0){
		str = `<div><span class="pick_rate">${rune_game_rate[0]}<small>${rune_game_rate[1]}</small></span><span class="win_rate"><em>${rune_game_rate[2]}</em></span></div>`
		side_rune_box1.append(str)
	}
}

// 룬 사이드박스2 룬,픽률,승률
for(i=0; i<rune_rate_code2.length; i++){
	let str;
	if(i == 0){
		str = `<div class="side_box1"></div>`
		side_rune_box2.append(str)
	}
	
	if(i < 3){
		let side_box = $('.side_box1');
		str = `<img alt="${rune_rate_code2[i]}" src="${rune_rate_img2[i]}">`
		side_box.append(str)
	}
	
	if(i == 0){
		str = `<div><span class="pick_rate">${rune_game_rate2[0]}<small>${rune_game_rate2[1]}</small></span><span class="win_rate"><em>${rune_game_rate[2]}</em></span></div>`
		side_rune_box2.append(str)
	}
}

// 스펠 픽률,승률
let pick_rate = $(".pick-rate");
let win_rate = $(".win-rate");
for(i=0; i<spell_rate0.length; i++){
	let str;
	if(i == 0){
		str = `<strong>${spell_rate0[0]}</strong><br><small>${spell_rate0[1]}</small>`;
		pick_rate.append(str)
	}
	if(i == 0){
		str = `${spell_rate0[2]}`;
		win_rate.append(str)
	}
}
// 스펠 픽률,승률2
let pick_rate2 = $(".pick-rate2");
let win_rate2 = $(".win-rate2");
for(i=0; i<spell_rate1.length; i++){
	let str;
	if(i == 0){
		str = `<strong>${spell_rate1[0]}</strong><br><small>${spell_rate1[1]}</small>`;
		pick_rate2.append(str)
	}
	if(i == 0){
		str = `${spell_rate1[2]}`;
		win_rate2.append(str)
	}
}



