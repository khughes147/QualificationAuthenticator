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
                   var output="<h5 id='removeUniHeader'> Select a University to remove </h5> <table id='uniListTable'><thead><th class='myTableHeader'>Admin Email</th><th class='myTableHeader'>University</th><th class='myTableHeader'>Admin Name</th><th class='myTableHeader'>Unique Key</th></thead><tbody>";
                                    $.each(data, function(i, item){
                                       output += "<tr>";
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

function removeUni(){


 var email = $(".email").text();

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


