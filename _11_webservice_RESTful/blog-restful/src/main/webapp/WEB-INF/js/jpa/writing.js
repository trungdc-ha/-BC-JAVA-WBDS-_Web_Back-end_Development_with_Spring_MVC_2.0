var writingJpa = writingJpa || {};

writingJpa.getWritingList = function () {
    $.ajax({
        url:'http://localhost:8080/writing/',
        method: 'GET',
        dataType: 'json',
        contentType: 'application/json',
    }).always(
        function(data){
            $.each(data, function(index, value){
                var time = Date(value.time);
                var category = value.category;
                $('#writingList').find("tbody").append(
                    "<tr>" +
                    "<td>"+ value.tittle +"</td>" +
                    "<td>"+ category.name +"</td>" +
                    "<td>"+ time +"</td>" +
                    "<td>" +
                    "<button type='button'>Edit</button> "+
                    "<button type='button'>Remove</button> "+
                    "</td>" +
                    "</tr>"
                );
            });
        }
    );
};

writingJpa.init = function(){
    writingJpa.drawTable();
};

$(document).ready(function(){
        writingJpa.init();
    }
);