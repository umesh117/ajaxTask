/*both insert and update request is handled by this*/
var ajaxUpdate = function(id) {
    $("#SuccessFlag").val("");
    console.log(id);
    var std_id=id;
    var fname=$("#"+"fname"+id).html();
    var lname=$("#"+"lname"+id).html();
    var email=$("#"+"email"+id).html();
    var username=$("#"+"username"+id).html();

    console.log(fname);

    $("#IDstd_id").val(std_id);
    $("#IDfname").val(fname);
    $("#IDlname").val(lname);
    $("#IDemail").val(email);
    $("#IDusername").val(username);

    $("button#saveSubmit").click(function (event) {
        var formElement=document.getElementById("studentForm");
        var formdata=new FormData(formElement);
        event.preventDefault();
        fire_ajax_submit(formdata,id);
    });
};

function fire_ajax_submit(formData,id) {
    console.log(formData);
    $.ajax({
        type: "PUT",
        url: "/ajaxupdateStudent",
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
                $("#IDstd_id").val(0);
                $("#IDfname").val("");
                $("#IDlname").val("");
                $("#IDfile").val("");
                $("#IDemail").val("");
                $("#IDusername").val("");
                $("#IDpassword").val("");
                $("#SuccessFlag").append("Data submitted successfully!");
                /*close the model*/
                if(id==response.student.std_id){
                    $("#"+"fname"+id).html(response.student.fname);
                    $("#"+"lname"+id).html(response.student.lname);
                    $("#"+"email"+id).html(response.student.email);
                    $("#"+"username"+id).html(response.student.username);
                    $("#"+"img"+id).attr("src","/images/"+response.student.profilePic);
                }else{
                    $("#stdBody").append(
                        "<tr id='raw"+response.student.std_id+"'>"+
                        "<td id='fname"+response.student.std_id+"'>"+response.student.fname+"</td>"+
                        "<td id='lname"+response.student.std_id+"'>"+response.student.lname+"</td>"+
                        "<td id='email"+response.student.std_id+"'>"+response.student.email+"</td>"+
                        "<td id='username"+response.student.std_id+"'>"+response.student.username+"</td>"+
                        "<td><img id='img"+response.student.std_id+"' src=/images/"+response.student.std_id+" height='100' width='100'/></td>"+
                        "<td><a href='#exampleModal' data-toggle='modal' class='btn btn-outline-primary'onclick='ajaxUpdate("+response.student.std_id+");' id='update"+response.student.std_id+"'>Update</a>"+
                        "<button type='button' class='btn btn-outline-primary' onclick='ajaxDelete("+response.student.std_id+");'>DELETE</button>"+"</td>"+
                        "<td hidden>"+response.student.std_id+"</td>"+
                        "</tr>");
                }
            }else{
                $.each(response.errorMessages,function (key,value) {
                    $("#"+"error"+key).append(value);
                })
            }
        }
    });
}