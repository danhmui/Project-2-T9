<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
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
                <li class="active">Chỉnh sửa tòa nhà</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Thông tin tòa nhà
                </h1>
            </div>
            <!-- /.page-header -->
            <div class="row">
                <div class="col-xs-12">
                    <form:form modelAttribute="modelInsertOrUpdate" class="form-horizontal" action="/admin/building-edit" id="listForm" method="post">
                        <div class="form-group">
                            <label class="col-xs-3 ">Tên tòa nhà <span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="name" class="form-control" id="name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3" >Quận <span style="color: red">(*)</span></label>
                            <div class="col-xs-4">
                                <form:select path="district" class="form-control" id="district">
                                    <option value="">-- Chọn Quận --</option>
                                    <c:forEach var="item" items="${districts}">
                                        <form:option value="${item.key}">${item.value}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phường<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="ward" class="form-control" id="ward"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Đường<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="street" class="form-control" id="street"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Kết cấu</label>
                            <div class="col-xs-9">
                                <form:input path="structure" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Số tầng hầm<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="numberOfBasement" class="form-control" id="numberofbasement"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Diện tích sàn<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="floorArea" class="form-control" id="floorarea"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Hướng</label>
                            <div class="col-xs-9">
                                <form:input path="direction" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Hạng</label>
                            <div class="col-xs-9">
                                <form:input path="level" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Diện tích thuê<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="rentArea" class="form-control" id="rentarea"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Giá thuê<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="rentPrice" class="form-control" id="rentprice"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Mô tả giá</label>
                            <div class="col-xs-9">
                                <form:input path="rpDescription" class="form-control" id="rpdescription"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí dịch vụ</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="servicePrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí ô tô</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="carPrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí mô tô</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="motorPrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí ngoài giờ</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="overtimePrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tiền điện</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="electricPrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tiện nước</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="waterPrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Đặt cọc</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="deposit">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Thanh toán</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="pay">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Thời hạn thuê</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="rentalTerm">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-3">Thời gian trang trí</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="decorationTime">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tên quản lý<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="managerName" class="form-control" id="managerName"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">SĐT quản lý<span style="color: red">(*)</span></label>
                            <div class="col-xs-9">
                                <form:input path="managerPhone" class="form-control" id="managerPhone"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí môi giới</label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="stockPrice">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Ghi chú  </label>
                            <div class="col-xs-9">
                                <input type="text" class="form-control" name="note">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Hình đại diện</label>
                            <form:input path="imageName" class="col-xs-3 control-label" type="file" id="uploadImage"/>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label"></label>
                            <div class="col-xs-9">
                                <c:if test="${not empty modelInsertOrUpdate.imageName}">
                                    <c:set value="/repository${modelInsertOrUpdate.imageName}" var="imagePath"/>
                                    <img src="${imagePath}" id="viewImage" width="300px" height="300px" style="margin-top: 50px"/>
                                </c:if>
                                <c:if test="${empty modelInsertOrUpdate.imageName}">
                                    <img src="/img/loading.gif" id="viewImage" width="300px" height="300px">
                                </c:if>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 ">Loại tòa nhà<span style="color: red">(*)</span></label>
                            <div class="col-xs-6">
                                <c:forEach items="${typeList}" var="item">
                                    <label class="checkbox-inline">
                                        <form:checkbox path="type" value="${item.key}"/>
                                        <span class="lbl"></span>
                                            ${item.value}
                                    </label>
                                </c:forEach>
                                <form:hidden path="id" id="type"/>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>


            <form:form modelAttribute="modelInsertOrUpdate" class="form-group">
                <label class="col-xs-3 "></label>
                <div class="col-xs-9">
                    <c:if test="${mode == 'insert'}">
                        <button type="button" class="btn btn-primary" id="btnAddBuilding">
                            Thêm tòa nhà
                        </button>
                    </c:if>
                    <c:if test="${mode == 'update'}">
                        <button type="button" class="btn btn-primary" id="btnAddBuilding">
                            Sửa tòa nhà
                        </button>
                    </c:if>
                    <button type="button" class="btn btn-danger" id="btnCancel">
                        Hủy thao tác
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="assets/js/jquery.2.1.1.min.js"></script>

<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
</script>

<script>
    var imageName = "";
    var imageBase64 = "";

    $('#btnCancel').click(function(){
        window.location.href = "/admin/building-list";
    });

    $('#btnAddBuilding').click(function(a){
        a.preventDefault();
        $('.error-msg').remove();
        var formData = $('#listForm').serializeArray();
        var json = {};
        var typeCode = [];

        $.each(formData, function(i, it){
            if(it.name !== 'type')
                json[it.name] = it.value;
            else
                typeCode.push(it.value);
        });
        json['type'] = typeCode;
        if(imageBase64 !== ''){
            json['imageName'] = imageName;
            json['imageBase64'] = imageBase64;
        }

        var isValid = true;
        function checkEmpty(value){
            return !value || String(value).trim() == '';
        }
        if(checkEmpty(json['name'])) {
            $('#name').after('<span class="error-msg" style="color: red; display: block;"> Tên tòa nhà không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['district'])) {
            $('#district').after('<span class="error-msg" style="color: red; display: block;"> Quận không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['ward'])) {
            $('#ward').after('<span class="error-msg" style="color: red; display: block;"> Phường không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['street'])) {
            $('#street').after('<span class="error-msg" style="color: red; display: block;"> Đường không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['numberOfBasement'])) {
            $('#numberofbasement').after('<span class="error-msg" style="color: red; display: block;"> Số tầng hầm không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['floorArea'])) {
            $('#floorarea').after('<span class="error-msg" style="color: red; display: block;"> Diện tích sàn không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['rentArea'])) {
            $('#floorarea').after('<span class="error-msg" style="color: red; display: block;"> Diện tích thuê không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['rentPrice'])) { // Đã sửa key thành rentPrice
            $('#rentprice').after('<span class="error-msg" style="color: red; display: block;"> Giá thuê không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['managerName'])) { // Đã sửa id và key thành managerName giống trong Form
            $('#managerName').after('<span class="error-msg" style="color: red; display: block;"> Tên quản lý không được thiếu </span>');
            isValid = false;
        }
        if (checkEmpty(json['managerPhone'])) { // Đã sửa id và key thành managerPhone giống trong Form
            $('#managerPhone').after('<span class="error-msg" style="color: red; display: block;"> SĐT quản lý không được thiếu </span>');
            isValid = false;
        }
        if (json['type'].length === 0) { // Check mảng type rỗng
            // Tìm đến phần tử checkbox cuối cùng thuộc nhóm loại tòa nhà để chèn lỗi phía sau
            $('input[name="type"]').last().parent().after('<span class="error-msg" style="color: red; display: block; margin-top: 5px;"> Loại tòa nhà không được thiếu </span>');
            isValid = false;
        }

        if(isValid){
            addBuilding(json);
        }else{
            alert("Vui lòng nhập đầy đủ các trường bắt buộc có dấu (*)");
        }
    })

    function addBuilding(data){
        $.ajax({
            url: '/api/admin/building-edit',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(data){
                console.log(data);
                alert("Thêm tòa nhà thành công !!!");
                window.location.href = "/admin/building-list";
            },
            error: function(data) {
                console.log("failed");
                alert("Thêm tòa nhà không thành công !");
            }
        })
    }

    $('#uploadImage').change(function (e){
       var reader = new FileReader();
       var file = $(this)[0].files[0];
       reader.onload = function (x){
           imageBase64 = x.target.result;
           imageName = file.name;
       };
       reader.readAsDataURL(file);
       openImage(this, "viewImage");
    });

    function openImage(input, imageView){
        if(input.files && input.files[0]){
            var reader = new FileReader();
            reader.onload = function (e){
                $('#' + imageView).attr("src", reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>

</body>
</html>
