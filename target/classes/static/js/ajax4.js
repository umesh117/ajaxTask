var ajaxDelete = function(id)   {

    $.ajax({
        type : "DELETE",
        url : "/ajaxdeleteStudent/" +id ,
        success: function () {
            $("#raw"+id).remove();
            console.log("Data deleted successully!");
        },
        error: function (e) {
            console.log(e);
        }
    });
};


