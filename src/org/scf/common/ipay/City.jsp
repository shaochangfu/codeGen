<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>city</title>
	<link rel="shortcut icon" href="http://localhost:8080/WebUtils2/public/img/favicon.png" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/WebUtils2/public/jQueryEasyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/WebUtils2/public/jQueryEasyUI/themes/icon.css">
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
	</style>
	<script type="text/javascript" src="http://localhost:8080/WebUtils2/public/jQueryEasyUI/jquery.min.js"></script>
	<script type="text/javascript" src="http://localhost:8080/WebUtils2/public/jQueryEasyUI/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		var url;
		function newRecord(){
			$('#dlg').dialog('open').dialog('setTitle','New check records');
			$('#fm').form('clear');
			url = 'http://localhost:8080/WebUtils2/city/saveRecords';
		}
		function editRecord(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('open').dialog('setTitle','Edit check records');
				$('#fm').form('load',row);
				url = 'http://localhost:8080/WebUtils2/city/updateRecords?id='+row.id;
			}
		}
		function saveRecord(){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						$('#dlg').dialog('close');		// close the dialog
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.msg
						});
					}
				}
			});
		}
		function removeRecord(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','Are you sure you want to remove this records?',function(r){
					if (r){
						$.post('http://localhost:8080/WebUtils2/city/removeRecords',{id:row.corderid},function(result){
							if (result.success){
								$('#dg').datagrid('reload');	// reload the user data
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.msg
								});
							}
						},'json');
					}
				});
			}
		}
		
		function doSearch(){
			$('#dg').datagrid('load',{
					ID: $('#ID').val(),
					Name: $('#Name').val(),
					CountryCode: $('#CountryCode').val(),
					District: $('#District').val(),
					Population: $('#Population').val(),
			});
		}
	</script>
</head>
<body>
	<div id="tb" style="padding:3px">
			<span>ID:</span>
			<input id="ID" style="line-height:26px;border:1px solid #ccc">
			<span>Name:</span>
			<input id="Name" style="line-height:26px;border:1px solid #ccc">
			<span>CountryCode:</span>
			<input id="CountryCode" style="line-height:26px;border:1px solid #ccc">
			<span>District:</span>
			<input id="District" style="line-height:26px;border:1px solid #ccc">
			<span>Population:</span>
			<input id="Population" style="line-height:26px;border:1px solid #ccc">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"  plain="true" onclick="doSearch()">Search</a>
	</div>
	<table id="dg" title="支付配置" class="easyui-datagrid" style="width:100%;height:450px"
			url="http://localhost:8080/WebUtils2/city/citySearch"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="ID" width="50">ID</th>
				<th field="Name" width="50">Name</th>
				<th field="CountryCode" width="50">CountryCode</th>
				<th field="District" width="50">District</th>
				<th field="Population" width="50">Population</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newRecord()">New Records</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editRecord()">Edit Record</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeRecord()">Remove Recode</a>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:700px;height:500px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">pay check status</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>ID:</label>
				<input name="ID" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Name:</label>
				<input name="Name" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>CountryCode:</label>
				<input name="CountryCode" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>District:</label>
				<input name="District" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Population:</label>
				<input name="Population" class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRecord()">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
</body>
</html>