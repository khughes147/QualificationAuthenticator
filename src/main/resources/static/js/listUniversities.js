function listUniversities()
{


        $.ajax(
        {
            type: "GET",
            cache: false,
            url: "/listUniversities",
            statusCode: {
                  200: function( data ) {
                  $("#uniListTable").show();
                   var output="<table id='uniListTable'><thead><th class='myTableHeader'>Admin Email</th><th class='myTableHeader'>University</th><th class='myTableHeader'>Admin Name</th><th class='myTableHeader'>Contact Number</th><th>Verified Status</th><th class='myTableHeader'>Hashed Key(SHA256)</th><th class='myTableHeader'>Private Key</th></thead><tbody>";
                                    $.each(data, function(i, item){
                                       output += "<tr class='table-row'>";
                                       $.each(item, function(p, value){
                                         output += "<td class='" + p + "'>" + value + "</td>";
                                       });
                                       output += "<td id='uniListButton'> <button type='button' href='#' onclick='removeUni()' id='removeUniversityButtonSingle' class='btn btn-default'>Remove</button> </td> </tr>";
                                    });
                                    output+="</tbody></table></div>";
                                    $("#uniListTable").html(output);
                  },
                  204: function( data ) {
                  $("#uniListTable").show();
                  $("#uniListTable").html("<h5> No registered universities </h5>");
                  }

        }
        });
}

function listUnverifiedUniversities()
{


        $.ajax(
        {
            type: "GET",
            cache: false,
            url: "/listUnverifiedUniversities",
            statusCode: {
                  200: function( data ) {
                  $("#uniListTable").show();
                   var output="<h5 id='removeUniHeader'> Universities awaiting verification </h5> <table id='uniListTable'><thead><th class='myTableHeader'>Admin Email</th><th class='myTableHeader'>University</th><th class='myTableHeader'>Admin Name</th><th class='myTableHeader'>Contact Number</th><th>Verified Status</th><th class='myTableHeader'>Hashed Key(SHA256)</th><th class='myTableHeader'>Private Key</th></thead><tbody>";
                                    $.each(data, function(i, item){
                                       output += "<tr class='table-row'>";
                                       $.each(item, function(p, value){
                                         output += "<td class='" + p + "'>" + value + "</td>";
                                       });
                                       output += "<td id='uniListButton'> <button type='button' href='#' onclick='verifyUni()' id='confirmUniversityButton' class='btn btn-default'>Verify</button> </td> <td id='uniListButton'> <button type='button' href='#' onclick='rejectUni()' id='rejectUniversityButton' class='btn btn-default'>Reject</button> </td> </tr>";
                                    });
                                    output+="</tbody></table></div>";
                                    $("#uniListTable").html(output);
                  },
                  204: function( data ) {
                  $("#uniListTable").show();
                  $("#uniListTable").html("<h5> No Universities awaiting verification </h5>");
                  }

        }
        });

}

function removeUni(){


 var email = $(event.target).closest('.table-row').find('.email').text();
 $(event.target).parent().parent().remove();


$.ajax(
        {
            type: "POST",
            data: jQuery.param({"id" : email}),
            cache: false,
            url: "/deleteUni",

            success: function(data)
            {

            },
            error: function(data)
            {

            }

        });



}

function verifyUni(){


 var email = $(event.target).closest('.table-row').find('.email').text();
 $(event.target).parent().parent().remove();


$.ajax(
        {
            type: "POST",
            data: jQuery.param({"id" : email}),
            cache: false,
            url: "/verifyUni",

            success: function(data)
            {

            },
            error: function(data)
            {

            }

        });

}

function rejectUni(){


 var email = $(event.target).closest('.table-row').find('.email').text();
 $(event.target).parent().parent().remove();


$.ajax(
        {
            type: "POST",
            data: jQuery.param({"id" : email}),
            cache: false,
            url: "/rejectUni",

            success: function(data)
            {

            },
            error: function(data)
            {

            }

        });

}


