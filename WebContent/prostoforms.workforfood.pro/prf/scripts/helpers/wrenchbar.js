$(document).ready( function () {

	var method = {};
	var debug = $(document).writeDebug({type:"console"});

	$(window).on("resize",function () {
		$(".settingsHolder").trigger("makeVisible");
		method.changeWWidthSelector();
	})

	var $wrench = ''+
	'<div class="fixed abs_top abs_right abs_bottom b_white zi_10 shadow transition w_200px" id="wrenchbar" style="margin-right: -200px;">'+
		'<div class="w_200px hidden zi_10 relative p_10 absolute settingsHolder abs_top h_100p bs_borderBox abs_left abs_right">'+
			'<div>'+
				'<div class="formSeparator f_12 p_10 relative t_center f_regular"><span class="p_5 radius_2 shadow_small bor_1 bor_solid bor_lgrey">Color Themes</span> </div>'+
				'<div class="p_5 pbot_20 pleft_8 bs_borderBox horizontal_center" style="width: 175px; padding-left: 8px;"> <div class="left w_20px h_20px themeswitcher mright_3 mbot_3 black bor_2 bor_white bor_solid cur_pointer" data-theme="black"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 grey bor_2 bor_white bor_solid cur_pointer" data-theme="grey"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 brown bor_2 bor_white bor_solid cur_pointer" data-theme="brown"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 red bor_2 bor_white bor_solid cur_pointer" data-theme="red"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 orange bor_2 bor_white bor_solid cur_pointer" data-theme="orange"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 yellow bor_2 bor_white bor_solid cur_pointer" data-theme="yellow"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 green bor_2 bor_white bor_solid cur_pointer" data-theme="green"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 lblue bor_2 bor_white bor_solid cur_pointer" data-theme="lblue"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 blue bor_2 bor_white bor_solid cur_pointer" data-theme="blue"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 purple bor_2 bor_white bor_solid cur_pointer" data-theme="purple"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 mint bor_2 bor_white bor_solid cur_pointer" data-theme="mint"></div><div class="left w_20px h_20px themeswitcher mright_3 mbot_3 pink bor_2 bor_white bor_solid cur_pointer" data-theme="pink"></div><div class="clear"></div></div>'+
				'<div class="formSeparator f_12 p_10 relative t_center f_regular">'+
					'<span class="p_5 radius_2 shadow_small bor_1 bor_solid bor_lgrey">Emulate window width</span>'+
				'</div>'+
				'<div class="p_5 pbot_20">'+
					'<select class="spinnerW" id="widthSelector">'+
						'<option selected="selected" value="widthAuto">Auto</option>'+
						'<option value="widthMobileP" data-width="320">Mobile P</option>'+
						'<option value="widthMobileL" data-width="480">Mobile L</option>'+
						'<option value="widthTabletP" data-width="720">Tablet P</option>'+
						'<option value="widthTabletL" data-width="960">Tablet L</option>'+
						'<option value="widthDesktop" data-width="1200">Desktop</option>'+
					'</select>'+
				'</div>'+
				'<div class="formSeparator f_12 p_10 relative t_center f_regular">'+
					'<span class="p_5 radius_2 shadow_small bor_1 bor_solid bor_lgrey">Emulated window size</span>'+
				'</div>'+
				'<div class="p_5 pbot_20">'+
					'<label class="input c_grey hidden">'+
						'<input type="checkbox" value="1" class="small_checkbox" name="showWindowBorder" id="showWindowBorders"> Show window size '+
					'</label>'+
					'<div class="clear"></div>'+
				'</div>'+
				'<div class="formSeparator f_12 p_10 relative t_center f_regular">'+
					'<span class="p_5 radius_2 shadow_small bor_1 bor_solid bor_lgrey">Emulated mobile view</span>'+
				'</div>'+
				'<div class="p_5 pbot_20">'+
					'<label class="input c_grey hidden">'+
						'<input type="checkbox" class="small_checkbox" value="1" name="showMobileView" id="showMobileView"> Show mobile view '+
					'</label>'+
					'<div class="clear"></div>'+
				'</div>'+
				'<div class="formSeparator f_12 p_10 relative t_center f_regular">'+
					'<span class="p_5 radius_2 shadow_small bor_1 bor_solid bor_lgrey">Change text color</span>'+
				'</div>'+
				'<div class="p_5 pbot_20">'+
					'<select class="spinnerW" id="textColorSelector"> <option selected="selected" value="c_black">Default</option> <option value="c_white">c_white</option> <option value="c_grey_d">c_grey_d</option> <option value="c_grey">c_grey</option> <option value="c_grey_a">c_grey_a</option> <option value="c_blue_a">c_blue_a</option> <option value="c_green_d">c_green_d</option> <option value="c_green_b">c_green_b</option> <option value="c_green_a">c_green_a</option> <option value="c_green">c_green</option> <option value="c_brown">c_brown</option> <option value="c_brown_a">c_brown_a</option> <option value="c_blue_d">c_blue_d</option> <option value="c_blue_b">c_blue_b</option> <option value="c_blue">c_blue</option> <option value="c_lblue">c_lblue</option> <option value="c_mint">c_mint</option> <option value="c_purple">c_purple</option> <option value="c_pink">c_pink</option> <option value="c_fuchsia">c_fuchsia</option> <option value="c_red_a">c_red_a</option> <option value="c_red">c_red</option> <option value="c_orange">c_orange</option> <option value="c_orange_d">c_orange_d</option> <option value="c_yellow_d">c_yellow_d</option> <option value="c_yellow">c_yellow</option> <option value="c_yellow_a">c_yellow_a</option> <option value="c_orange_b">c_orange_b</option> </select>'+
				'</div>'+
				'<div class="formSeparator f_12 p_10 relative t_center f_regular">'+
					'<span class="p_5 radius_2 shadow_small bor_1 bor_solid bor_lgrey">Change text size</span>'+
				'</div>'+
				'<div class="p_5 pbot_20">'+
					'<select class="spinnerW" id="textSizeSelector"> <option value="12">12px</option> <option value="14">14px</option> <option selected="selected" value="16">16px</option> <option value="18">18px</option> <option value="20">20px</option> <option value="22">22px</option> <option value="24">24px</option> <option value="26">26px</option> <option value="28">28px</option> <option value="30">30px</option> <option value="32">32px</option> <option value="34">34px</option> <option value="36">36px</option> <option value="38">38px</option> <option value="40">40px</option> <option value="42">42px</option> <option value="44">44px</option> <option value="46">46px</option> <option value="48">48px</option> <option value="50">50px</option></select>'+
				'</div>'+
			'</div>'+
		'</div>'+
		'<div class="w_40px h_40px shadow b_white mleft_m40 absolute abs_top abs_left mtop_20 wrenchbar">'+
			'<i class="fa f_20 h_40px w_40px c_grey lh_40 fa-wrench zi_10 t_center"></i>'+
			'<div class="b_white w_20px h_80px mleft_40 mtop_m60 relative"></div>'+
		'</div>'+
	'</div>';   

	if(!$("body").find("#wrenchbar").length) {
		$("body").append($wrench);
	} else {
		$("body").find("#wrenchbar").remove();
		$("body").append($wrench);
	}

	if ((window.location.hash).length > 1) {
		var hash = (window.location.hash).replace("#","");
		$("body").removeClass("black red orange yellow green lblue blue purple pink mint brown grey").addClass(hash);
	}

	if(!$("body").find(".windowEmulator").length) {
		$("body").prepend('<div class="fixed abs_full"><div class="h_100p horizontal_center relative windowEmulator notShow"></div></div>');
	}

	$(".small_checkbox").simpleChecker({type:"small"});

	$("input#showWindowBorders").bind("change", function () {
		if($(this).is(":checked")) {
			$(".windowEmulator").removeClass("notShow");
		} else {
			$(".windowEmulator").addClass("notShow");
		}
	})
	$("input#showMobileView").bind("change", function () {
		console.log($(this).attr("checked"))
		if($(this).is(":checked")) {
			$("body").addClass("mobile");
		} else {
			$("body").removeClass("mobile");
		}
	})

	$("#textSizeSelector").bind("change",function () {
		$("body").removeClass (function (index, css) {
		    return (css.match (/(^|\s)f_[1-9]\S+/g) || []).join('');
		}).removeClass("f_gigant f_bigest f_big f_medium f_normal f_smaller f_small f_regular");
		$("body").addClass("f_"+$(this).val()).addClass("f_light");
	})

	$("#textColorSelector").bind("change",function () {
		$("body").removeClass (function (index, css) {
		    return (css.match (/(^|\s)c_[a-zA-Z]\S+/g) || []).join('');
		});
		$("body").addClass($(this).val());
	})

	$(".themeswitcher").bind("click touchend" ,function () {
		$("body").removeClass("black red orange yellow green lblue blue purple pink mint brown grey").addClass($(this).data("theme"));
		$(window).trigger("resize");
	}) // themeswitcher
	
	$(".spinnerW").each(function () {
		$(this).simpleSelector({searched:false, type:"spinner", width: "style"});
	});
	method.changeWWidthSelector = function () {
		$("#widthSelector option").each(function (i) {
			if($(this).data("width") > $(window).width()) { $(this).attr("disabled",!0); } else { $(this).attr("disabled",!1); }
		})
		if($("#widthSelector option[value='"+$("#widthSelector").val()+"']").is(":disabled"))  {
			$("#widthSelector").val($("#widthSelector option:first-child").val()).trigger("change");
		}
		$("#widthSelector").trigger("predefinedChange");
	}
	
	$("#widthSelector").bind("change",function () {
		setTimeout(function () {
			$(".settingsHolder").trigger("makeVisible");
		},20)
		$("body").attr("id",$(this).val());
		$(window).trigger("resize");
	})

	// sidebar + scrollbox in sidebar
	$(".settingsHolder").prostoScroller();
	$(".wrenchbar").bind("click", function (event) {
		$("#wrenchbar").toggleClass("hover");
		setTimeout(function () {
			$(".settingsHolder").trigger("makeVisible");
		},20)
	})

	var yame = '(function (d, w, c) { (w[c] = w[c] || []).push(function() { try { w.yaCounter31553618 = new Ya.Metrika({ id:31553618, clickmap:true, trackLinks:true, accurateTrackBounce:true, webvisor:true }); } catch(e) { } }); var n = d.getElementsByTagName("script")[0], s = d.createElement("script"), f = function () { n.parentNode.insertBefore(s, n); }; s.type = "text/javascript"; s.async = true; s.src = "../../../mc.yandex.ru/metrika/watch.js"; if (w.opera == "[object Opera]") { d.addEventListener("DOMContentLoaded", f, false); } else { f(); } })(document, window, "yandex_metrika_callbacks");';
	var yame2 = $('<noscript><div><img src="https://mc.yandex.ru/watch/31553618" style="position:absolute; left:-9999px;" alt="" /></div></noscript>');
	var ga = "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){ (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o), m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m) })(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');ga('create', 'UA-66020576-1', 'auto'); ga('send', 'pageview');";
	$("body").append($('<script>'+yame+'</' + 'script>'),yame2,$("<script>"+ga+"</" + "script>"));
	
});