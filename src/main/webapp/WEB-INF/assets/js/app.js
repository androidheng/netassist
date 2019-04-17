$(function () {
	//轮播
	$('#swiper').swiper({
		pagination: '#swiper .swiper-pagination',
		paginationClickable: true,
		autoplay: 5000
	});
	$('#hutong').swiper({
		pagination: '#hutong .swiper-pagination',
		slidesPerView: 3,
		paginationClickable: true,
		spaceBetween: 30,
		autoplay: 5000
	});

	//动画
	var list = ['slide-left', 'slide-right', 'slide-bottom', 'slide-top']
	$.each($('.product-list').find("li"), function (i, n) {
		var a = parseInt(Math.random() * 4)
		$(n).scrollspy({
			animation: list[a],
			delay: 0
		})
	})
	$.each($('.news-list').find("li"), function (i, n) {
		var a = parseInt(Math.random() * 4)
		$(n).scrollspy({
			animation: list[a],
			delay: 0
		})
	})


	//回到顶部
	if ($(document).scrollTop() > 200) {
		$("#top").slideDown(500)
	}
	$(document).scroll(function () {
		if ($(document).scrollTop() > 200) {
			$("#top").slideDown(500)
		} else {
			$("#top").slideUp(500)
		}
	})

	$("#top").click(function () {
		goTop()
	})

	function goTop() {
		$('html,body').animate({
			'scrollTop': 0
		}, 600);
	}

	$.each($('#example-list').find(".exampleRoom"), function (i, n) {
		if (i < 6) {
			$(n).scrollspy({
				animation: 'scale-up',
				delay: 100 * i,
				repeat: false
			})
		} else {
			$(n).scrollspy({
				animation: 'scale-up',
				delay: 100 * (i - 6),
				repeat: false
			})
		}
	})

	$("#tijao").click(function () {
		// alert(1)
		if ($("#phone").val().length != 11 || $("#phone").val() == "") {
			alert("请输入正确的手机号")
			return false
		}
		if ($("#name").val() == "") {
			alert("请输入名字")
			return false
		}
		if ($("#text").val() == "") {
			alert("请输入内容")
			return false
		}
		let data = {
			name: $("#name").val(),
			phone: $("#phone").val(),
			text: $("#text").val(),
		}
		$.ajax({
			url: 'http://192.168.1.112:3000/suggestion/add',
			data: data,
			success: function (r) {
				if (r.code == 0) {
					alert("提交成功")
					$("#name").val("")
					$("#phone").val("")
					$("#text").val("")
				} else {
					alert("提交失败")
				}
			}
		})
	})
});