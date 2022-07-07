const signup=document.forms["signup"];
const checkId=document.getElementById("checkId");
const checkPhone=document.getElementById("checkPhone");
const checkEmail=document.getElementById("checkEmail");

signup["id"].addEventListener("blur",async (e)=>{
	let v=e.target.value;
	if(v.length>=4){
		//mem/ajax/findId/{id}
		let res=await fetch("/member/ajax/findId/"+v);
		let json=await res.json();
		console.log(json)
		if(json){
			checkId.classList.remove("text-primary");
			checkId.classList.add("text-danger");
			checkId.innerText="존재하는 id";
		}else{
			checkId.classList.remove("text-danger");
			checkId.classList.add("text-primary");
			checkId.innerText="사용가능";
		}
	}else{
			checkId.classList.remove("text-primary");
			checkId.classList.add("text-danger");
			checkId.innerText="id의 길이는 4이상이어야 합니다.";
	}
})
signup["phone"].addEventListener("blur",async (e)=>{
	let v=e.target.value;
	let phoneEx=/^01(0|1|6|9)-(\d{3,4})-(\d{4})$/;
	console.log(phoneEx.test(v));
	if(phoneEx.test(v)){
		//mem/ajax/findId/{id}
		let res=await fetch("/member/ajax/findPhone/"+v);
		let json=await res.json();
		console.log(json);
		if(json){
			checkPhone.classList.remove("text-primary");
			checkPhone.classList.add("text-danger");
			checkPhone.innerText="존재하는 핸드폰 번호";
		}else{
			checkPhone.classList.remove("text-danger");
			checkPhone.classList.add("text-primary");
			checkPhone.innerText="사용가능";
		}
	}else{
			checkPhone.classList.remove("text-primary");
			checkPhone.classList.add("text-danger");
			checkPhone.innerText="폰의 형식을 맞추세요!";
	}
})
signup["email"].addEventListener("blur",async (e)=>{
	let v=e.target.value;
	let emailEx=/([0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[0-9a-zA-Z]{2,3}$/;
	if(emailEx.test(v)){
		//mem/ajax/findId/{id}
		let res=await fetch("/member/ajax/findEmail/"+v);
		let json=await res.json();
		console.log(json);
		if(json){
			checkEmail.classList.remove("text-primary");
			checkEmail.classList.add("text-danger");
			checkEmail.innerText="존재하는 이메일";
		}else{
			checkEmail.classList.remove("text-danger");
			checkEmail.classList.add("text-primary");
			checkEmail.innerText="사용가능";
		}
	}else{
			checkEmail.classList.remove("text-primary");
			checkEmail.classList.add("text-danger");
			checkEmail.innerText="이메일의 규칙을 따르세요.";
	}
})

