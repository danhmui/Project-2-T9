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
                    <li class="active">Danh sách tòa nhà</li>
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
                                <form:form id="listForm" modelAttribute="modelSearch" action="/admin/building-list" method="get">
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
                                            <form:select path="district" class="form-control">
                                                <option value="">-- Chọn Quận --</option>
                                                <c:forEach var="item" items="${districts}">
                                                    <form:option value="${item.key}">${item.value}</form:option>
                                                </c:forEach>
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
                                        <security:authorize access="hasRole('MANAGER')">
                                            <div class="col-xs-2">
                                                <label>Chọn nhân viên</label>
                                                <form:select class="form-control" path="staffId">
                                                    <option value="">-- Chọn nhân viên --</option>
                                                    <c:forEach var="item" items="${staffList}">
                                                        <form:option value="${item.key}">${item.value}</form:option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </security:authorize>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="col-xs-6">
                                            <c:forEach var="item" items="${typeList}">
                                                <label class="checkbox-inline">
                                                    <form:checkbox path="typeCode" value="${item.key}"/>
                                                    <span class="lbl"></span>
                                                    ${item.value}
                                                </label>
                                            </c:forEach>
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
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-app btn-danger btn-sm" title="Xóa tòa nhà" id="btn-deleteBuilding">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </security:authorize>
                    </div>
                </div>
                <div class="hr hr-18 dotted hr-double"></div>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="table-responsive">
                            <display:table name="model.listResult" cellpadding="0" cellspacing="0"
                                           requestURI="${formUrl}" partialList="true" sort="external"
                                           size="${model.totalItem}" defaultsort="2" defaultorder="ascending"
                                           id="tableList" pagesize="${model.maxPageItems}"
                                           export="false"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">
                                <display:column title="<fieldset class='form-group'>
                                                        <input type='checkbox' id='checkAll' class='check-box-element'>
                                                        </fieldset>" class="center select-cell"
                                                headerClass="center select-cell">
                                    <fieldset>
                                        <input type="checkbox" name="checkList" value="${tableList.id}"
                                                id="checkbox_${tableList.id}" class="check-box-element"/>
                                    </fieldset>
                                </display:column>
                                <display:column headerClass="text-center" property="buildingName" title="Tên tòa nhà"/>
                                <display:column headerClass="text-center" property="address" title="Địa chỉ"/>
                                <display:column headerClass="text-center" property="numberOfBasement" title="Số tầng hầm"/>
                                <display:column headerClass="text-center" property="managerName" title="Tên quản lý"/>
                                <display:column headerClass="text-center" property="managerPhone" title="SĐT quản lý"/>
                                <display:column headerClass="text-center" property="floorArea" title="Diện tích sàn"/>
                                <display:column headerClass="text-center" property="rentArea" title="Diện tích thuê"/>
                                <display:column headerClass="text-center" property="rentPrice" title="Giá thuê"/>
                                <security:authorize access="hasRole('MANAGER')">
                                    <display:column headerClass="col-actions" title="Thao tác">
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <button class="btn btn-xs btn-success" onclick="assignmentBuilding(${tableList.id})" title="Giao tòa nhà">
                                                <i class="ace-icon fa fa-check"></i>
                                            </button>

                                            <button class="btn btn-xs btn-info" onclick="updateEachBuilding(${tableList.id})" title="Sửa tòa nhà">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </button>

                                            <button class="btn btn-xs btn-danger" onclick="deleteBuilding(${tableList.id})" title="Xóa tòa nhà">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </div>
                                    </display:column>
                                </security:authorize>
                            </display:table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- /.main-content -->
    <form:form modelAttribute="modelSearch" action="/admin/building-list" class="modal" id="assignmentBuildingModal" style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title center">Danh sách nhân viên</h5>
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
                                    <span class="lbl"></span>
                                </label>
                            </th>

                            <th class="center">Họ tên nhân viên</th>
                        </tr>
                        </thead>
                        <tbody>

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
    </form:form>
</div>

<script src="assets/js/jquery.2.1.1.min.js"></script>

<script>
    function updateEachBuilding(id) {
        window.location.href = "/admin/building-edit?id=" + id;
    }

    $('#btn-search').click(function (a){
        a.preventDefault();
        $('#listForm').submit();
    });

    function assignmentBuilding(id) {
        //Luu lai id cua toa nha dang thao tac
        $('#buildingId').val(id);
        //Popup bang giao nhan vien
        $('#assignmentBuildingModal').modal();
        loadStaff(id);
    }

    function loadStaff(id){
        $.ajax({
            url:"/api/admin/buildings/" + id + "/staffs",
            type: "GET",
            dataType: "JSON",
            success : function (response){
                console.log(response.data);
                var row = '';

                $.each(response.data, function (index, item) {
                    var isChecked = (item.checked === 'checked' || item.checked === true) ? 'checked' : '';

                    row += '<tr>';
                    row += '<td class="center">';
                    row += '<label class="pos-rel">';
                    row += '<input type="checkbox" class="ace" value="' + item.id + '" ' + isChecked + '>';
                    row +='<span class="lbl"></span>';
                    row += '</label>';
                    row += '</td>';
                    row += '<td class="center">' + item.fullName + '</td>';
                    row += '</tr>';
                });
                $('#staff-list tbody').html(row);
            },
            error: function (response) {
                console.log('Lỗi tải danh sách nhân viên');
            }
        })
    }

    $('#btn-assignmentBuilding').click(function (e) {
        e.preventDefault();
        var json = {};
        //Lay id cua toa nha da duoc luu truoc do
        json['buildingId'] = $('#buildingId').val();
        //Lay gia tri value (staffid) cua tung checkbox duoc chon
        var staffIds = $('#staff-list').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();//Chuyen ket qua  thanh 1 mang thuan tuy [1,3,5]
        json['staffIds'] = staffIds
        if(json['staffIds'] != '' && json['staffIds'].length != 0){
            updateAssignment(json);
        }else{
            alert("Không thể sửa !");
        }
    })

    function updateAssignment(data){
        $.ajax({
            url:"/api/admin/buildingassignments",
            type: "POST",
            data: JSON.stringify(data), //Convert tu Object trong JS qua JSON
            // dataType: "JSON", //Kieu du lieu ma server se tra ra
            contentType: 'application/json',
            success: function (response) {
                console.log("success");
                alert("Giao tòa nhà thành công!");
                location.reload();
            },
            error : function(response){
                console.log("failed");
                alert("Giao tòa nhà thất bại!");
            }
        });
    }

    $('#btn-deleteBuilding').click(function (e) {
        e.preventDefault();
        var ids = $('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        if(ids.length === 0){
            alert("Vui lòng chọn ít nhất 1 tòa nhà để xóa !");
            return;
        }
        if(confirm("Bạn có chắc chắn muốn xóa " + ids.length + " tòa nhà đã chọn?")){
            deleteBuildings(ids);
        }
    })

    function deleteBuildings(ids) {
        $.ajax({
            url: "/api/admin/building-list",
            type: "DELETE",
            data: JSON.stringify(ids),
            contentType: 'application/json',
            success: function (response) {
                console.log("success");
                alert("Xóa thành công !");
                location.reload();
            },
            error: function (response) {
                console.log("failed");
                alert("Xóa không thành công !");
            }
        });
    }

    function deleteBuilding(id){
        if(confirm("Bạn có chắc chắn muốn xóa tòa nhà này ?"))
            deleteBuildings([id]);
    }
</script>

</body>
</html>
