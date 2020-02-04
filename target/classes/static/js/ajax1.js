$(document).ready(function ()   {
    $.ajax({
        type:"GET",
        url:"/studentList",
        contentType:"application/json",
        success:function (data) {
            $.each(data,function (index,tempStudent) {
               $("#stdBody").append(
               "<tr id='raw"+tempStudent.std_id+"'>"+
                    "<td id='fname"+tempStudent.std_id+"'>"+tempStudent.fname+"</td>"+
                    "<td id='lname"+tempStudent.std_id+"'>"+tempStudent.lname+"</td>"+
                    "<td id='email"+tempStudent.std_id+"'>"+tempStudent.email+"</td>"+
                    "<td id='username"+tempStudent.std_id+"'>"+tempStudent.username+"</td>"+
                    "<td><img img id='img"+tempStudent.std_id+"'  src=/images/"+tempStudent.profilePic+" height='100' width='100'/></td>"+
                   "<td><a href='#exampleModal' data-toggle='modal' class='btn btn-outline-primary'onclick='ajaxUpdate("+tempStudent.std_id+");' id='update"+tempStudent.std_id+"'>Update</a>"+
                    "<button type='button' class='btn btn-outline-primary' onclick='ajaxDelete("+tempStudent.std_id+");'>DELETE</button>"+"</td>"+
                   "<td hidden>"+tempStudent.std_id+"</td>"+
                "</tr>");
            })
        }
    });
});