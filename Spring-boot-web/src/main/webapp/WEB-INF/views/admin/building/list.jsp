<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check("main-container", "fixed");
        } catch (e) {}
    </script>

    <div id="sidebar" class="sidebar responsive">
        <script type="text/javascript">
            try {
                ace.settings.check("sidebar", "fixed");
            } catch (e) {}
        </script>


        <!-- /.sidebar-shortcuts -->
        <script type="text/javascript">
            try {
                ace.settings.check("sidebar", "collapsed");
            } catch (e) {}
        </script>
    </div>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check("breadcrumbs", "fixed");
                    } catch (e) {}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul>
                <!-- /.breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        Danh sách tòa nhà
                    </h1>
                </div>
                <!-- /.page-header -->
                <div class="row">
                    <div class="widget-box" style="font-family: 'Times New Roman', Times, serif;">
                        <div class="widget-header">
                            <h4 class="widget-title">Tìm kiếm</h4>

                            <span class="widget-toolbar">
                        <a href="#" data-action="reload">
                          <i class="ace-icon fa fa-refresh"></i>
                        </a>

                        <a href="#" data-action="collapse">
                          <i class="ace-icon fa fa-chevron-up"></i>
                        </a>

                        <a href="#" data-action="close">
                          <i class="ace-icon fa fa-times"></i>
                        </a>
                      </span>
                        </div>

                        <div class="widget-body" style="display: block">
                            <div class="widget-main">
                                <form:form id="form-list" modelAttribute="modelSearch" action="/admin/building-list" method="get">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <label>Tên tòa nhà</label>
                                                <form:input path="name" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-6">
                                                <label>Diện tích sàn</label>
                                                <form:input path="floorArea" class="form-control"></form:input>
                                            </div>
                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-2">
                                                <label>Quận</label>
                                                <form:select path="districtCode" class="form-control">
                                                    <option value="">-- Chọn Quận --</option>
                                                    <form:options items="${districts}"></form:options>
                                                </form:select>

                                            </div>
                                            <div class="col-xs-5">
                                                <label>Phường</label>
                                                <form:input path="ward" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-5">
                                                <label>Đường</label>
                                                <form:input path="street" class="form-control"></form:input>
                                            </div>
                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <label>Số tầng hầm</label>
                                                <form:input path="numberOfBasement" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-4">
                                                <label>Hướng</label>
                                                <form:input path="direction" class="form-control"/>
                                            </div>
                                            <div class="col-xs-4">
                                                <label>Hạng</label>
                                                <form:input path="level" class="form-control"></form:input>
                                            </div>
                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-3">
                                                <label>Diện tích từ</label>
                                                <form:input path="areaFrom" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-3">
                                                <label>Diện tích đến</label>
                                                <form:input path="areaTo" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-3">
                                                <label>Giá thuê từ</label>
                                                <form:input path="rentPriceFrom" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-3">
                                                <label>Giá thuê đến</label>
                                                <form:input path="rentPriceTo" class="form-control"></form:input>
                                            </div>
                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-5">
                                                <label>Tên quản lý</label>
                                                <form:input path="managerName" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-5">
                                                <label>SDT quản lý</label>
                                                <form:input path="managerPhone" class="form-control"></form:input>
                                            </div>
                                            <div class="col-xs-2">
                                                <label>Chọn nhân viên</label>
                                                <form:select path="staffId" class="form-control">
                                                    <option value="">-- Chọn nhân viên --</option>
                                                    <form:options items="${staffs}"></form:options>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <form:checkboxes items="${typeCode}" path="typeCode"></form:checkboxes>
                                            </div>
                                        </div>
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <button class="btn btn-success" id="btn-search">
                                                    <i class="ace-icon glyphicon glyphicon-search"></i>
                                                    Tìm kiếm
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="pull-right">
                        <a href="/admin/building-edit">
                            <button class="btn btn-app btn-primary btn-sm" title="Thêm tòa nhà">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </a>

                        <button class="btn btn-app btn-danger btn-sm" title="Xóa tòa nhà" id="btn-deleteBuilding">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </button>
                    </div>
                </div>
                <div class="hr hr-18 dotted hr-double"></div>
                <div class="row">
                    <div class="col-xs-12">
                        <table id="building-list" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" >
                                        <span class="lbl"></span>
                                    </label>
                                </th>

                                <th>Tên tòa nhà</th>
                                <th>Địa chỉ</th>
                                <th>Số tầng hầm</th>
                                <th>Tên quản lý</th>
                                <th>SDT quản lý</th>
                                <th>Diện tích sàn</th>
                                <th>Diện tích thuê</th>
                                <th>Diện tích trống</th>
                                <th>Giá thuê</th>
                                <th>Phí dịch vụ</th>
                                <th>Phí môi giới</th>
                                <th>Thao tác</th>
                            </thead>

                            <tbody>
                                <c:forEach var="item" items="${buildingList}">
                                    <tr>
                                        <td class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace" value="${item.id}">
                                                <span class="lbl"></span>
                                            </label>
                                        </td>
                                        <td>${item.nameBuilding}</td>
                                        <td>${item.address}</td>
                                        <td>${item.numberOfBasement}</td>
                                        <td>${item.managerName}</td>
                                        <td>${item.managerPhoneNumber}</td>
                                        <td>${item.floorArea}</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <div class="hidden-sm hidden-xs btn-group">
                                                <button class="btn btn-xs btn-success" onclick="assignmentBuilding(${item.id})" title="Giao tòa nhà">
                                                    <i class="ace-icon fa fa-check"></i>
                                                </button>

                                                <button class="btn btn-xs btn-info" onclick="up" title="Sửa tòa nhà">
                                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                </button>

                                                <button class="btn btn-xs btn-danger" title="Xóa tòa nhà">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- /.page-content -->
        </div>
    </div>

    <!-- /.main-content -->
    <div class="modal" id="assignmentBuildingModal" style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Danh sách nhân viên</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <table id="staff-list" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>

                            <th>Họ tên nhân viên</th>

                        </thead>

                        <tbody>
                        <tr>
                            <td class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace" value="32">
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>Nguyễn Văn A</td>
                        </tr>
                        <tr>
                            <td class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace" value="34">
                                    <span class="lbl"></span>
                                </label>
                            </td>
                            <td>Nguyễn Văn B</td>
                        </tr>
                        </tbody>
                    </table>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="btn-assignmentBuilding">Giao tòa nhà</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                </div>
            </div>
        </div>
        <input type="hidden" id="buildingId" value="">
    </div>
</div>

<script src="assets/js/jquery.2.1.1.min.js"></script>

<script>
    $('#btn-search').click(function (e){
        e.preventDefault();
        $('#form-list').submit();
    })

    function assignmentBuilding(id) {
        $('#buildingId').val(id);
        $('#assignmentBuildingModal').modal();
    }

    $('#btn-assignmentBuilding').click(function (e) {
        e.preventDefault();
        var json = {};
        json['buildingId'] = $('#buildingId').val();
        var staffIds = $('#building-list').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        json['staffIds'] = staffIds;
        if(json['buildingId'] != '' && json['staffIds'].length != 0){
            updateAssignment(json);
        }else{
            alert("");
        }
    })

    $('#btn-deleteBuilding').click(function (e) {
        e.preventDefault();
        var data ={};
        var ids = $('#building-list').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['ids'] = ids;
        if(data['ids'] != ''){
            deleteBuilding(data['ids']);
        }
        else{
            alert("Khong co toa nha nao duoc chon !");
        }
    })
    //BEGIN AJAX
    function updateAssignment(data){
        $.ajax({
            url:"http://localhost:8080/api/assignments",
            type: "POST",
            data: JSON.stringify(data), //Convert tu Object trong JS qua JSON
            dataType: "JSON", //Kieu du lieu ma server se tra ra
            contentType: 'application/json',
            success: function (response) {
                console.log("success");
            },
            error : function(response){
                console.log("failed")
            }
        });
    }
    function deleteBuilding(data){
        console.log("http://localhost:8080/api/buildings/" + data);
        $.ajax({
            url:"http://localhost:8080/api/buildings/" + data,
            type: "DELETE",
            data: JSON.stringify(data), //Convert tu Object trong JS qua JSON
            dataType: "JSON", //Kieu du lieu ma server se tra ra
            contentType: 'application/json',
            success: function (response) {
                console.log("success");
            },
            error : function(response){
                console.log("failed")
            }
        });
    }

    //END AJAX
</script>

</body>
</html>
