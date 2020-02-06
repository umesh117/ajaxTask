/*Insert request is handled by ajax3.js*/

$(document).ready(function () {
    $("button#addStudent").click(function (event) {
        console.log("inserting data");
        $('#exampleModal').on('hidden.bs.modal', function () {
            $(this).find('form').trigger('reset');
            $("#IDstd_id").val(0);
        });
        var formElement = document.getElementById("studentForm");
        console.log(formElement);
        var formdata = new FormData(formElement);
        event.preventDefault();
        fire_ajax_submit(formdata);
    });
});

function fire_ajax_submit(formData) {
    console.log(formData);
    $.ajax({
        type: "POST",
        url: "/ajaxinsertStudent",
        enctype: 'multipart/form-data',
        processData: false,
        data: formData,
        dataType:'json',
        contentType: false,
        cache:false,
        success: function (response) {
            $("#errorfname").html("");
            $("#errorlname").html("");
            $("#erroremail").html("");
            $("#errorusername").html("");
            $("#errorpassword").html("");
            if (response.validated) {
                console.log(response);
                console.log(response.student.std_id);
                $("#stdBody").append(
                    "<tr id='raw"+response.student.std_id+"'>"+
                    "<td id='fname"+response.student.std_id+"'>"+response.student.fname+"</td>"+
                    "<td id='lname"+response.student.std_id+"'>"+response.student.lname+"</td>"+
                    "<td id='email"+response.student.std_id+"'>"+response.student.email+"</td>"+
                    "<td id='username"+response.student.std_id+"'>"+response.student.username+"</td>"+
                    "<td><img id='img"+response.student.std_id+"' src=/images/"+response.student.std_id+" height='100' width='100'/></td>"+
                    "<td><a href='#exampleModal' data-toggle='modal' class='btn btn-outline-primary'onclick='ajaxUpdate("+response.student.std_id+");' id='update"+tempStudent.std_id+"'>Update</a>"+
                    "<button type='button' class='btn btn-outline-primary' onclick='ajaxDelete("+response.student.std_id+");'>DELETE</button>"+"</td>"+
                    "<td hidden>"+student.std_id+"</td>"+
                    "</tr>");

                $("#IDstd_id").val(0);
                $("#IDfname").val("");
                $("#IDlname").val("");
                $("#IDfile").val("");
                $("#IDemail").val("");
                $("#IDusername").val("");
                $("#IDpassword").val("");
                $("#SuccessFlag").append("Data submitted successfully!");
                /*close the model*/
            }else{
                $.each(response.errorMessages,function (key,value) {
                    $("#"+"error"+key).append(value);
                })
            }
        }
    });


}