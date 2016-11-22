	function operateFormatter(value, row, index) {
		
		operateButtons = {
		activated : '<button class="activate btn btn-success btn-sm"><i class="glyphicon glyphicon-check"></i></button> ',
		deactivated : '<button class="deactivate btn btn-warning btn-sm"><i class="glyphicon glyphicon-remove"></i></button> ',
		onHold: '<button class="onHold btn btn-info btn-sm"><i class="glyphicon glyphicon-hourglass"></i></button> '
		}
		
		stringBuild = '';
		
		for(prop in operateButtons){
			if(row["status"] != String(prop)){
				stringBuild += operateButtons[prop];
			}
		}
		
		
		
        return [
            '<button class="edit btn btn-primary btn-sm">',
            '<i class="glyphicon glyphicon-edit"></i>',
            '</button>  ',
            stringBuild,
            '<button class="delete btn btn-danger btn-sm">',
            '<i class="glyphicon glyphicon-trash"></i>',
            '</button>'
        ].join('');
    }
	
	$('#table').on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function () {
		$('#delete').prop('disabled', !$('#table').bootstrapTable('getSelections').length);
	});
	
	$('#delete').click(function () {
        var rows = getIdSelections();
    	 sweetAlrtConfirm("Delete", "Are you sure you want to do delete these item/s?", function(){
    		rows.map(function(rs){
    		datas = cleanUpRow(rs);
        	alertMessage = function(){};
        	ajaxLoader("/volunteer_tracker/delete", datas, alertMessage);
    		});
    	})
        
        $('#delete').prop('disabled', true);
    });
	
	function getIdSelections() {
        return $.map($('#table').bootstrapTable('getSelections'), function (row) {
            return row;
        });
    }

    
	$('#table').bootstrapTable({
		url: '/volunteer_tracker/all'
	});
	

	    
	
	$('.datepicker').datepicker();
    
    window.operateEvents = {
            'click .edit': function (e, value, row, index) { 
            	loadModal(row, "edit");           	
            },
            'click .delete': function (e, value, row, index) { 
            	submitVarsButtons(row, "deleted", "delete");
            },
            'click .deactivate': function (e, value, row, index) {	
            	submitVarsButtons(row, "deactivated", "update");
            },
            'click .activate': function (e, value, row, index) {	
            	submitVarsButtons(row, "activated", "update");
            },
            'click .onHold': function (e, value, row, index) {	
            	submitVarsButtons(row, "onHold", "update");
            }
        };
    
    
    function loadModal(object, events){
    		
    	$('#myModal').find('.modal-body').empty();
    	$('form').removeClass().addClass("form-" + events);

    	var data = '';
    	var gender = ["Male", "Female"];
    	var status = ["activated", "deactivated", "onHold"];
    	
    	for(variable in object){
    		
    		if(variable === 'gender' || variable === 'status') {
    			vardata = eval(variable).map(function(val){
    						
    						if (events == "edit" && val == object[variable]){
    							checkedvar = "checked";
    						}
    						else if(events != "edit" && (val == "Male" || val == "activated")) {
    							checkedvar = "checked";
    						}
    						else
    							checkedvar = "";
    							
    				
            				return [ 	'<label class="radio-inline">',
            							'<input ' + checkedvar + ' type="radio" name="' + variable + '" value="' + val + '"> ' + val,
            							'</label>'
            						].join('');
    						}).join('');
    		}
    		else if(variable === 'dateStarted'){
    			valdate = (events === "edit") ? 'value="' + object[variable] + '"' : '';
    			vardata = '<input type="text" ' + valdate + ' name="' + variable + '" data-date-format="yyyy-mm-dd" data-provide="datepicker" class="datepicker form-control">';
    		}
    		else {
    			value = (events === "edit") ? 'value="' + object[variable] + '"' : (variable === 'id') ? 'value="0"' : '';
    			disableId = (variable === 'id') ? 'readonly' : '';
    			vardata = '<input ' + disableId + ' type="text" class="form-control"  name="' + variable + '"'  + value + ' > ';
    		}
    		
    		
	    		if(variable != 0) {
	            	data += [ 	'<div class="form-group">',
	            				'<label class="col-sm-4 control-label">' + fixLabels(variable) +'</label>',
					        	'<div class="col-sm-7">',
					        	vardata,
					        	'</div></div>'
	            			].join('');
	    		}
	    		
    		}
    		
    		
    		$('#myModal').modal('show').find('.modal-body').append(data);
    		
    }
    
	function fixLabels(label){
		return label.replace(/[A-Z]/g, " $&").toUpperCase().replace("_", " ");
	}
	
	function cleanUpRow(row){
		delete row[0];
		for(vars in row){row[vars] = String(row[vars])}
		datas = JSON.stringify(row);
		return datas;
	}
	
	function submitVarsButtons(row, state, urlsubmit){
		if(state != "onHold") {
	    	sweetAlrtConfirm(state.charAt(0).toUpperCase().slice(0, -1), "Are you sure you want to " + state.slice(0, -1) + " this person?", function(){
	    		if(state != "deleted"){ row.status = state; }
	    		datas = cleanUpRow(row);
	        	alertMessage = sweetAlrt(state.charAt(0).toUpperCase() + state, 'You have successfully ' + state + ' a volunteer.', 'success');
	        	ajaxLoader("/volunteer_tracker/" + urlsubmit, datas, alertMessage);
	    	})
		}
		else if(state == "onHold"){
	    	sweetAlrtConfirm("On Hold", "Are you sure you want to place this person on hold?", function(){
	    		row.status = state;
	    		datas = cleanUpRow(row);
	        	alertMessage = sweetAlrt("On Hold", 'You have successfully placed a volunteer on hold.', 'success');
	        	ajaxLoader("/volunteer_tracker/" + urlsubmit, datas, alertMessage);
	    	})
		}
	}
    	
	$('.add').on('click', function(){
		loadModal($('#table').bootstrapTable('getData')[0], "add");
	})
	

	
	function setData(){
				data = {};
				$('form').serializeArray().map(function(x){
								data[x.name] = x.value;
							})
								
					return JSON.stringify(data);
	}
	
	
	
	$.validator.setDefaults({
		    errorElement: "span",
		    errorClass: "help-block",
		    highlight: function (element, errorClass, validClass) {
		        $(element).closest('.form-group').addClass('has-error');
		    },
		    unhighlight: function (element, errorClass, validClass) {
		        $(element).closest('.form-group').removeClass('has-error');
		    },
		    errorPlacement: function (error, element) {
		    	if (element.prop("type") === "checkbox" || element.prop("type") === "radio") {
		            error.appendTo(element.parent().parent());
		        }
		        if (element.parent('.input-group').length) {
		            error.insertAfter(element.parent());
		        } else {
		            error.insertAfter(element);
		        }
		    }
	});

	$("form").validate({
			rules: {
				firstName: "required",
				lastName: "required",
				gender: "required",
				dateStarted: "required",
				status: "required",
				email: {
					required: true,
					email: true
				},
				age: {
					required: true,
					number: true
				},
				mobile_number: {
					required: true,
					number: true
				}
			},
	        submitHandler: function(form) {
	        	
	        	if(this.currentForm.className == "form-add") {
	        	formUrl = "/volunteer_tracker/add";
	        	sweetSetup = sweetAlrt('Added!', 'You have successfully added a volunteer.', 'success');
	        	}
	        	else if(this.currentForm.className == "form-edit"){
	        	formUrl = "/volunteer_tracker/update";
	        	sweetSetup = sweetAlrt('Updated!', 'You have successfully updated the details.', 'success');
	        	}
	        		
	        	ajaxLoader(formUrl, setData(), sweetSetup);
	            
	         }
		});
	
		function ajaxLoader(formUrl, datas, alertfunc){
            $.ajax({
                type: "POST",
                url: formUrl,
                data: datas,
                dataType: "json",
                headers: { 
                    'Accept': 'application/json',
                    'Content-Type': 'application/json' 
                },
                success: function(){
                	$('#myModal').modal('hide');
                    $('#table').bootstrapTable('refresh');
                    alertfunc();
                }
            });
		}
	
		function sweetAlrt(title, message, response){
			return function(){
						return swal(title, message, response);
					} 
		}
		
		function sweetAlrtConfirm(confirmTitle, confirmText, successFuncs){
			swal({
				  title: confirmTitle,
				  text: confirmText,
				  type: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Yes!'
				}).then(function () {
					successFuncs();
				})
		}