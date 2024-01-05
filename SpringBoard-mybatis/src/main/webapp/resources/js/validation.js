const checkUser = function(){
	//alert("가입");
	//아이디는 4자이상 15자까지 입력해주세요
	//비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력해주세요
	//이름은 한글로 입력해주세요
	//나이는 숫자를 입력해주세요

	let form = document.userform;
	let userId = document.getElementById("userId").value;
	let userPw = document.getElementById("userPasswd").value;
	let userAge = document.getElementById("userAge").value;
	let userName = document.getElementById("userName").value;

	//정규표현식
	let regPw1 = /[0-9]+/     		//숫자
		let regPw2 = /[a-zA-Z]+/  		//영문자			
			let regPw3 = /[~!@#$%^&*()=-]+/  //특수문자
				let regName = /^[가-힣]+$/ 			//한글만

					if(userId.length< 4 || userId.length > 15){
						alert("아이디는 4자이상 15자까지 입력해주세요.")
						document.getElementById("userId").select();
						return false;
					}else if(userPw.length < 8 || !regPw1.test(userPw) ||
							!regPw2.test(userPw) || !regPw3.test(userPw)){
						alert("비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력해주세요.")
						document.getElementById("userPasswd").select();
						return false;
					}else if(!regName.test(userName)){	//이름이 정규식에 일치하지 않으면
						alert("이름은 한글로 입력해주세요.")
						document.getElementById("userName").select();
						return false;
					}else if(isNaN(userAge) || userAge == ""){	//숫자가 아니면
						alert("나이는 숫자를 입력해주세요.")
						document.getElementById("userAge").select();
						return false;
					}else{
						form.submit();	//유효하면 폼에 전송
					}
}

//ID 중복 검사 순서
/*
			1. 아이디 입력값 가져오기
			2. 입력값을 서버에 전송하고 중복된 아이디가 있는지 확인
 */
let checkId = function(){
	//alert("중복검사");
	let userId = document.getElementById("userId").value;
	let checkResult = document.getElementById("check-result");
	console.log(userId)

	if(userId != ""){
		$.ajax({
			//요청방식 : post, url: /user/checkuserid, 데이터: userId
			type: "post",
			url : "/user/checkuserid",
			data: {"userId": userId},
			//서버에서 응답 - 성공과 실패
			success: function(response){
				console.log(response);
				if(response == "usable"){
					checkResult.innerHTML = "사용가능한 아이디입니다."
						checkResult.style.color = "blue";
				}else{
					checkResult.innerHTML = "이미 사용중인 아이디입니다."
						checkResult.style.color = "red";
				}
			},
			error: function(error){
				console.log("에러발생", error);
			}
		});
	}
}