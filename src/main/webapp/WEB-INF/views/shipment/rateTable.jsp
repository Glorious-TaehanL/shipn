<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<table id="jqGrid22"></table>
 <script type="text/javascript"> 
 var token = $("meta[name='_csrf']").attr("content");
 var header = $("meta[name='_csrf_header']").attr("content");
 $(document).ajaxSend(function(e, xhr, options) { xhr.setRequestHeader(header, token); });
 var $j = jQuery.noConflict();
        $j(document).ready(function () {
        	/* basic code
            $j("#jqGrid22").jqGrid({
                url: 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=orders',
                mtype: "GET",
                datatype: "jsonp",
                colModel: [
                    { label: 'OrderID', name: 'OrderID', key: true, width: 75 },
                    { label: 'Customer ID', name: 'CustomerID', width: 150 },
                    { label: 'Order Date', name: 'OrderDate', width: 150                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          },
                    { label: 'Freight', name: 'Freight', width: 150 },
                    { label:'Ship Name', name: 'ShipName', width: 150 }
                ],
				page: 1,
                width: 700,
                height: 310,
                rowNum: 20,
				scrollPopUp:true,
				scrollLeftOffset: "83%",
				viewrecords: true,
                scroll: 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
                emptyrecords: 'Scroll to bottom to retrieve new page', // the message will be displayed at the bottom 
                pager: "#jqGridPager"
            });
        	*/
        	
        });

    </script>