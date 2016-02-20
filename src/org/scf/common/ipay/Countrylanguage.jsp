<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>countrylanguage</title>
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
			url = 'http://localhost:8080/WebUtils2/countrylanguage/saveRecords';
		}
		function editRecord(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('open').dialog('setTitle','Edit check records');
				$('#fm').form('load',row);
				url = 'http://localhost:8080/WebUtils2/countrylanguage/updateRecords?id='+row.id;
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
						$.post('http://localhost:8080/WebUtils2/countrylanguage/removeRecords',{id:row.corderid},function(result){
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
					CountryCode: $('#CountryCode').val(),
					Language: $('#Language').val(),
					IsOfficial: $('#IsOfficial').val(),
					Percentage: $('#Percentage').val(),
			});
		}
	</script>
</head>
<body>
	<div id="tb" style="padding:3px">
			<span>CountryCode:</span>
			<input id="CountryCode" style="line-height:26px;border:1px solid #ccc">
			<span>Language:</span>
			<input id="Language" style="line-height:26px;border:1px solid #ccc">
			<span>IsOfficial:</span>
			<input id="IsOfficial" style="line-height:26px;border:1px solid #ccc">
			<span>Percentage:</span>
			<input id="Percentage" style="line-height:26px;border:1px solid #ccc">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"  plain="true" onclick="doSearch()">Search</a>
	</div>
	<table id="dg" title="支付配置" class="easyui-datagrid" style="width:100%;height:450px"
			url="http://localhost:8080/WebUtils2/countrylanguage/countrylanguageSearch"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="CountryCode" width="50">CountryCode</th>
				<th field="Language" width="50">Language</th>
				<th field="IsOfficial" width="50">IsOfficial</th>
				<th field="Percentage" width="50">Percentage</th>
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
				<label>CountryCode:</label>
				<input name="CountryCode" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Language:</label>
				<input name="Language" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>IsOfficial:</label>
				<input name="IsOfficial" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Percentage:</label>
				<input name="Percentage" class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRecord()">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
</body>
</html>