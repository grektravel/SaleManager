function addProduct() {
	$('#productDialog').dialog("option", "title", 'Add Product');
	$('#productDialog').dialog('open');
}

function editProduct(id) {

	$.get("get/" + id, function(result) {

		$("#productDialog").html(result);

		$('#productDialog').dialog("option", "title", 'Edit Product');

		$("#productDialog").dialog('open');

		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#productDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#productForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#productForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
