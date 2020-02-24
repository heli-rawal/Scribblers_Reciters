$(document).ready( function () {

		/* simple tip creation */

		$(".tipN").simpletips({});
		$(".tipT").simpletips({position:"top"});
		$(".tipTL").simpletips({position:"top_left"});
		$(".tipTLP").simpletips({position:"top_left", type: 'image'});
		$(".tipTR").simpletips({position:"top_right"});
		$(".tipB").simpletips({position:"bottom"});
		$(".tipBL").simpletips({position:"bottom_left"});
		$(".tipBR").simpletips({position:"bottom_right"});
		$(".tipL").simpletips({position:"left"});
		$(".tipLT").simpletips({position:"left_top"});
		$(".tipLB").simpletips({position:"left_bottom"});
		$(".tipR").simpletips({position:"right"});
		$(".tipRT").simpletips({position:"right_top"});
		$(".tipRB").simpletips({position:"right_bottom"});
		$(".tipNi").simpletips({type:"image"});
		$(".tipTi").simpletips({position:"top", type:"image"});
		$(".tipTLi").simpletips({position:"top_left", type:"image"});
		$(".tipTRi").simpletips({position:"top_right", type:"image"});
		$(".tipBi").simpletips({position:"bottom", type:"image"});
		$(".tipBLi").simpletips({position:"bottom_left", type:"image"});
		$(".tipBRi").simpletips({position:"bottom_right", type:"image"});
		$(".tipLi").simpletips({position:"left", type:"image"});
		$(".tipLTi").simpletips({position:"left_top", type:"image"});
		$(".tipLBi").simpletips({position:"left_bottom", type:"image"});
		$(".tipRi").simpletips({position:"right", type:"image"});
		$(".tipRTi").simpletips({position:"right_top", type:"image"});
		$(".tipRBi").simpletips({position:"right_bottom", type:"image"});
		
		/* numeric spinner creation */

		$(".ticker_normal").simpleTicker({
			type: 'integer', 
			step: 10, 
			numbers: 'all'
		});

		/* autogrow textfield creation */

		$(".autogrow").growTextarea({
			minrows: 5, 
			autogrow: true, 
			maxchars: 3000
		});

		/* checkbox creation */

		$(".normalCheckbox").simpleChecker({
			type:'normal'
		});
		
		//===== Masked input =====//
	
		$.mask.definitions['~'] = "[+-]";
		$("#phone").mask("+7 (999) 999-99-99");
		$("#post").mask("999-9999");
		$("#card_number").mask("9999-9999-9999-9999");
		$("#cvv2").mask("999");

		// autofill creation */

		$(".helpfill").helpFill({
			type:"local"
		});

		/* select creation */

		$("select.select_search").simpleSelector({
			searched:true
		});
		$("select.selectSpinner").simpleSelector({
			type:"spinner"
		});

		/* validation rules */

		$("#comment").validate({
			errorClass: "error",
			validClass: "valid",
			ignore: ".ignore, *:not(:visible)",
			errorElement: "label",
			rules: {
	            name: {
	                required: !0
	            },
	            email: {
	                required: !0,
	                email: !0
	            },
	            subject: {
	                required: !0
	            },
	            comment: {
	                required: !0,
	                minlength: 20
	            },
	            captcha: {
	                required: !0,
	                remote: {
						url: "php/check.php",
						type: "post"
					}
	            }
	        },
	        messages: {
	            name: {
	                required: "Please enter your name"
	            },
	            email: {
	                required: "Please enter your email",
	                email: "Incorrect email format"
	            },
	            subject: {
	                required: "Please enter your subject"
	            },
	            comment: {
	                required: "Please enter your comment"
	            },
	            captcha: {
	                required: "Captcha is required",
					remote: "Valid captcha is required"
	            }
	        },
			// Do not change code below
	        success: function () {
	        	$(window).trigger("fastPopupResize");
	        },
			// Do not change code below
	        showErrors: function () {
	        	this.defaultShowErrors();
	        	$(window).trigger("fastPopupResize");
	        },
			// Do not change code below
			highlight: function (e, s, r) {
				$(e).removeClass(r).addClass(s);
				$(e).closest(".unit.check, .input, .textarea, .select").removeClass("wrapper-"+r).addClass("wrapper-"+s);
			},
			// Do not change code below
			unhighlight: function (e, s, r) {
				$(e).removeClass(s).addClass(r);
				$(e).closest(".unit.check, .input, .textarea, .select").removeClass("wrapper-"+s).addClass("wrapper-"+r);
			},
			// Do not change code below
			errorPlacement: function (e, s) {
				$(s).is(":checkbox") || $(s).is(":radio") ? ($(s).is(":checkbox") ? $(s).closest(".unit.check").append(e) : $(s).closest(".unit.radio").after(e) ) : $(s).closest(".input, .textarea, .select").append(e);
			},
			submitHandler: function (form) {
				var $outputTarget = $(form).find("#response");
				$(form).ajaxSubmit({
					target: $outputTarget,
					error: function (e) {
						console.log("error");
						$outputTarget.addClass("error-message").removeClass("none").html("An error occured: " + e.status + " - " + e.statusText);
						$(form).find('button[type="submit"]').attr("disabled", !1).removeClass("processing");
					},
					beforeSubmit: function () {
						console.log("beforeSubmit");
						$(form).find('button[type="submit"]').attr("disabled", !0).addClass("processing")
					},
					success: function () {
						$(form).resetForm();
						$outputTarget.removeClass("none").addClass("success-message");
						$(form).find('button[type="submit"]').attr("disabled", !1).removeClass("processing");
						setTimeout(function () {
							$outputTarget.addClass("none").removeClass("success-message").html("");
							$(form).find('button[type="submit"]').attr("disabled", !1).removeClass("processing");
						}, 10000)
					}
				})
			}
		})
});	