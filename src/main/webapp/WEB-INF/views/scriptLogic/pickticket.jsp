<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">

function txtFiedlValidCheck() {
	var txtElement = $(".validCheckSection input[type=text]");
	for(var i = 0; i < txtElement.length ; i++){
		if((txtElement[i].value == "" || txtElement[i].value == null) && $(txtElement[i]).attr("id") != "to-street2"){
			$(txtElement[i]).addClass("empty");
			return false;
		}else{
			if($(txtElement[i]).hasClass("empty")){
				$(txtElement[i]).removeClass("empty");
			}	
		}
	}	
	return true;
}
		var main = {
			init : function() {
				var _this = this;
				$('#btn-movies-find').on('click', function() {
					_this.find();
					console.log("TEST");
				});
			},
			find : function() {
				var keyword = $('#keyword').val();
				$.ajax({
					type : 'POST',
					url : '/api/v1/movies/' + keyword,
					dataType : 'json',
					contentType : 'application/json; charset=utf-8',
				}).done(function(res) {
					
					var jsonlistndata = JSON.stringify(res.maplist);
					
					$j("#jqGrid22").jqGrid({
							url: '/api/display/jqgrid.do',
							mtype : 'POST',
			                datatype: "json",
			                postData: jsonlistndata,
			                ajaxGridOptions: { contentType: "application/json; charset=UTF-8" },
			                ajaxRowOptions: { contentType: "application/json; charset=UTF-8"},
			                colModel: [
			                    { label: 'title', name: 'title', key: true, width: 75 },
			                    { label: 'link', name: 'link', width: 150 },
			                    { label: 'image', name: 'image', width: 150                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          },
			                    { label: 'subtitle', name: 'subtitle', width: 150 },
			                    { label:'pubDate', name: 'pubDate', width: 150 },
			                    { label: 'director', name: 'director', width: 150 },
			                    { label: 'actor', name: 'actor', width: 150 },
			                    { label: 'userRating', name: 'userRating', width: 150 }
			                ],
							page: 1,
			                width: 700,
			                height: 310,
			                rowNum: 20,
							scrollPopUp:true,
							scrollLeftOffset: "100%",
							viewrecords: true,
			                scroll: 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
			                emptyrecords: 'Scroll to bottom to retrieve new page', // the message will be displayed at the bottom 
			                pager: "#jqGridPager"
			            });
			                
				}).fail(function(error) {
					alert(JSON.stringify(error));
				});
			}
		};
		
		$(window).ready(function(){
			main.init(); //Ajax load
			
			if($(window).width() > 767){
	            var rightH = $('.pick-right').height();
	            var leftH = $('.pick-left').height();
	            var jqgridH = rightH - leftH;
	            $('.ship-jqgrid-container').css('height',jqgridH);
	         }
			
			// ----------------------------------- //
	        // PURPOSE OF FUNC 
			// LOAD S.O INFORMATION BY PICKTICKET NUM# 
			// TRIGGER :: #btn-pickticket-info-find
	     	$('#btn-pickticket-info-find').click(function() {
				var no = $("#articleNo").val();
				
				$.ajax({
					type : "POST",
					url : "/users/pos.do",
					postdata : {
						"articleNo" : no
					},
					error : function(error) {
						console.error("ERROR");
					},
					success : function(data) {
	 					//to section data setup.
						// ship to data set
						//end
// 												Ship to data set.		
						$("#to-picticket").val($("#articleNo").val());
						$("#to-store").val("test store");
						$("#to-division").val("test division");
						$("#to-name").val("test name");
						$("#to-email").val("Test@test.com");
						$("#to-phone").val("213-123-1234");
						$("#to-city").val("LOS ANGELES");
						$("#to-state").val("CA");
						$("#to-country").val("USA");
						$("#to-zip").val("90001");
						$("#to-street").val(data.title);
						$("#to-street2").val(data.content);	

// 						ship from data set.
						$('#from-store').val('store');
						$('#from-name').val('test22');
						$('#from-email').val('test22@test.com');
						$('#from-phone').val('213-123-1234');
						$('#from-city').val('pasadena');
						$('#from-state').val('CA');
						$('#from-country').val('USA');
						$('#from-zip').val('90010');
						$('#from-street').val('address -1');
						$('#from-street2').val('address - 2');
						//from section data setup.
						//ship from data set
						//end
	 					//$("#writer").val(data.writer);
					}
				})
			});
			
	     	// ----------------------------------- //
	        // PURPOSE OF FUNC 
			// VALIDATION CHECK S.O INFORMATION
			// TRIGGER :: #btn-pickticket-info-validation-check
			$('#btn-pickticket-info-validation-check').click(function() {
				console.log($('.shipToSection').serializeObject());
				var inputTxtFlag = txtFiedlValidCheck();
				if(inputTxtFlag){
					$.ajax({
						type : "POST",
						url : "/api/ups/valid/soinfo.do",
						data : JSON.stringify($('.shipToSection').serializeObject()),
						datatype : 'JSON',
		                ajaxGridOptions: { contentType: "application/json; charset=UTF-8" },
		                ajaxRowOptions: { contentType: "application/json; charset=UTF-8"},
						contentType : 'application/json; charset=utf-8',
						success : function(valid) {
							alert(valid);
						},
						error : function(xhr, status, error) {
							console.error('Validation Ajax ERROR :' + error);						
						}
					})	
				}
			});

			$('.savebtn').click(function(){
				alert("Save Information");
			});
			
			
			$('.shipto-tab').click(function(){
				if($(this).parent().hasClass('active')){
					alert('!!!');
				}
				else{
					$(this).parent().addClass('active');
					$('.ship-section.shipTo').addClass('active');
					$('.shipfrom').removeClass('active');
					$('.ship-section.shipFrom').removeClass('active');
				}
			});
			
			$('.shipfrom-tab').click(function(){
				if($(this).parent().hasClass('active')){
					alert('!!!');
				}
				else{
					$(this).parent().addClass('active');
					$('.ship-section.shipFrom').addClass('active');
					$('.shipto').removeClass('active');
					$('.ship-section.shipTo').removeClass('active');
				}
			});
	         
	      });
		
		jQuery.fn.serializeObject = function() {
			var obj = null;
			try {
				if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
					var arr = this.serializeArray();
					if (arr) {
						obj = {};
						jQuery.each(arr, function() {
							obj[this.name] = this.value;
						});
					}
				}
			} catch (e) {
				alert(e.message);
			} finally {
			}

			return obj;
		};
			
//						Ship to data set.		
// 						$("#to-picticket").val($("#articleNo").val());
// 						$("#to-store").val("test store");
// 						$("#to-division").val("test division");
// 						$("#to-name").val("test name");
// 						$("#to-email").val("Test@test.com");
// 						$("#to-phone").val("213-123-1234");
// 						$("#to-city").val("LOS ANGELES");
// 						$("#to-state").val("CA");
// 						$("#to-country").val("USA");
// 						$("#to-zip").val("90001");
// 						$("#to-street").val(data.title);
// 						$("#to-street2").val(data.content);	

//						ship from data set.
// 						$('#from-store').val('store');
// 						$('#from-name').val('test22');
// 						$('#from-email').val('test22@test.com');
// 						$('#from-phone').val('213-123-1234');
// 						$('#from-city').val('pasadena');
// 						$('#from-state').val('CA');
// 						$('#from-country').val('USA');
// 						$('#from-zip').val('90010');
// 						$('#from-street').val('address -1');
// 						$('#from-street2').val('address - 2');


</script>

