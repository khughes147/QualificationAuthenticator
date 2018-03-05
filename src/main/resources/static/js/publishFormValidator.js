$(document).ready(function(){
        $('#startDateID').datepicker({
            format: "dd/mm/yyyy"
        });
        $('#endDateID').datepicker({
            format: "dd/mm/yyyy"
        });
        document.getElementById("endDateID").readOnly = true;
        document.getElementById("startDateID").readOnly = true;

//Write on Form
	$('#studentNameID').blur(function(event) {
		var input=$(this);
		var is_name=input.val();
		if(is_name){input.removeClass("is-invalid").addClass("is-valid"),
		$('p.studentNameErrorMessage').remove();}
		else{input.removeClass("is-valid").addClass("is-invalid"),
		$('p.studentNameErrorMessage').remove(),
		$('#studentNameID').after('<p class="studentNameErrorMessage">Student name can\'t be empty.</p>');}
	});
	//check to make sure its an email
	//if @ not included it wont allow the form to be submitted.
	$('#studentEmail').blur(function(event) {
		var input=$(this);
		var re = /^[\w]+[\w.%+-]*@[\w.-]+\.ac\.uk$/;
		var is_email=re.test(input.val());
		if(is_email){input.removeClass("is-invalid").addClass("is-valid"),
		$('p.studentEmailErrorMessage').remove();}
		else{input.removeClass("is-valid").addClass("is-invalid"),
		$('p.studentEmailErrorMessage').remove(),
		$('#studentEmail').after('<p class="studentEmailErrorMessage">Email must be an .ac.uk address.</p>');}
	});
	$('#studentID').blur(function(event) {
		var input=$(this);
		var message=$(this).val();
		if(message){input.removeClass("is-invalid").addClass("is-valid"),
		$('p.studentIdErrorMessage').remove();}
		else{input.removeClass("is-valid").addClass("is-invalid"),
		$('p.studentIdErrorMessage').remove(),
		$('#studentID').after('<p class="studentIdErrorMessage">Student ID can\'t be empty.</p>');}
	});



    	$('#courseNameID').blur(function(event) {
    		var input=$(this);
    		var message=$(this).val();
    		if(message){input.removeClass("is-invalid").addClass("is-valid"),
    		$('p.courseNameErrorMessage').remove();}
    		else{input.removeClass("is-valid").addClass("is-invalid"),
    		$('p.courseNameErrorMessage').remove(),
    		$('#courseNameID').after('<p class="courseNameErrorMessage">Course name can\'t be empty.</p>');}
    	});
    	$('#startDateID').blur(function(event) {
    		var input=$(this);
    		input.addClass("is-valid");

    	});
    	$('#endDateID').blur(function(event) {
    		var input=$(this);
    		input.addClass("is-valid");

    	});
    	$('#classificationID').blur(function(event) {
    		var input=$(this);
    		var message=$(this).val();
    		if(message){input.removeClass("is-invalid").addClass("is-valid"),
    		$('p.classificationErrorMessage').remove();}
    		else{input.removeClass("is-valid").addClass("is-invalid"),
    		$('p.classificationErrorMessage').remove(),
    		$('#classificationID').after('<p class="classificationErrorMessage">Classification field can\'t be empty.</p>');}
    	});
    	$('#uniKeyID').blur(function(event) {
    		var input=$(this);
    		var message=$(this).val();
    		if(message){input.removeClass("is-invalid").addClass("is-valid"),
    		$('p.keyErrorMessage').remove();}
    		else{input.removeClass("is-valid").addClass("is-invalid"),
    		$('p.keyErrorMessage').remove(),
    		$('#uniKeyID').after('<p class="keyErrorMessage">A University key is required.</p>');}
    	});

$("#publishButton").click(function(event){

    if ($('#studentNameID').hasClass('form-control is-valid')){
        if ($('#studentEmail').hasClass('form-control is-valid')){
            if ($('#studentID').hasClass('form-control is-valid')){
                    if ($('#courseNameID').hasClass('form-control is-valid')){
                        if ($('#startDateID').hasClass('form-control is-valid')){
                            if ($('#endDateID').hasClass('form-control is-valid')){
                                if ($('#classificationID').hasClass('form-control is-valid')){
                                    if ($('#uniKeyID').hasClass('form-control is-valid')){


                                    }else{
                                    alert("Please ensure all fields are completed correctly."),
                                    event.stopPropagation();
                                    event.preventDefault();}
                                }else{
                                alert("Please ensure all fields are completed correctly."),
                                event.stopPropagation();
                                event.preventDefault();}
                            }else{
                            alert("Please ensure all fields are completed correctly."),
                            event.stopPropagation();
                            event.preventDefault();}
                        }else{
                        alert("Please ensure all fields are completed correctly."),
                        event.stopPropagation();
                        event.preventDefault();}
                    }else{
                    alert("Please ensure all fields are completed correctly."),
                    event.stopPropagation();
                    event.preventDefault();}
                }else{
                alert("Please ensure all fields are completed correctly."),
                event.stopPropagation();
                event.preventDefault();}
            }else{
            alert("Please ensure all fields are completed correctly."),
            event.stopPropagation();
            event.preventDefault();}
        }else{
        alert("Please ensure all fields are completed correctly."),
        event.stopPropagation();
        event.preventDefault();}
});
});