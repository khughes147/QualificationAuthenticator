$('myModal').show().on('hidden', function() {
    $('myModal').modal('hide')
});

function sendEmailAdmin()
{


        $.ajax(
        {
            type: "POST",
            data: $("#addUniForm").serialize(),
            cache: false,
            url: "/addUniversity",

            success: function(data)
            {

            $('#addSuccessModal').modal('show')

            },
            error: function(data)
            {

            }

        });
}

$(document).ready(function(){
//Write on Form
	$('#add_uniID').blur(function(event) {
		var input=$(this);
		var is_name=input.val();
		if(is_name){input.removeClass("is-invalid").addClass("is-valid"),
		$('p.uniErrorMessage').remove();}
		else{input.removeClass("is-valid").addClass("is-invalid"),
		$('p.uniErrorMessage').remove(),
		$('#add_uniID').after('<p class="uniErrorMessage">University name can\'t be empty.</p>');}
	});
	//check to make sure its an email
	//if @ not included it wont allow the form to be submitted.
	$('#add_emailID').blur(function(event) {
		var input=$(this);
		var re = /^[\w]+[\w.%+-]*@[\w.-]+\.ac\.uk$/;
		var is_email=re.test(input.val());
		if(is_email){input.removeClass("is-invalid").addClass("is-valid"),
		$('p.emailErrorMessage').remove();}
		else{input.removeClass("is-valid").addClass("is-invalid"),
		$('p.emailErrorMessage').remove(),
		$('#add_emailID').after('<p class="emailErrorMessage">Email must be an .ac.uk address.</p>');}
	});
	$('#add_adminID').blur(function(event) {
		var input=$(this);
		var message=$(this).val();
		if(message){input.removeClass("is-invalid").addClass("is-valid"),
		$('p.adminErrorMessage').remove();}
		else{input.removeClass("is-valid").addClass("is-invalid"),
		$('p.adminErrorMessage').remove(),
		$('#add_adminID').after('<p class="adminErrorMessage">Admin name can\'t be empty.</p>');}
	});

//submit form validation
$("#add_submitButton").click(function(event){
	var form_data=$("#addUniForm").serializeArray();
	var error_free=true;


    if ($('#add_adminID').hasClass('form-control is-valid')){
        if ($('#add_uniID').hasClass('form-control is-valid')){
            if ($('#add_emailID').hasClass('form-control is-valid')){
             $("#uniListTable").hide();
            sendEmailAdmin();
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
    event.preventDefault();};







});
});