<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>country</title>
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
			url = 'http://localhost:8080/WebUtils2/country/saveRecords';
		}
		function editRecord(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('open').dialog('setTitle','Edit check records');
				$('#fm').form('load',row);
				url = 'http://localhost:8080/WebUtils2/country/updateRecords?id='+row.id;
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
						$.post('http://localhost:8080/WebUtils2/country/removeRecords',{id:row.corderid},function(result){
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
					Code: $('#Code').val(),
					Name: $('#Name').val(),
					Continent: $('#Continent').val(),
					Region: $('#Region').val(),
					SurfaceArea: $('#SurfaceArea').val(),
					IndepYear: $('#IndepYear').val(),
					Population: $('#Population').val(),
					LifeExpectancy: $('#LifeExpectancy').val(),
					GNP: $('#GNP').val(),
					GNPOld: $('#GNPOld').val(),
					LocalName: $('#LocalName').val(),
					GovernmentForm: $('#GovernmentForm').val(),
					HeadOfState: $('#HeadOfState').val(),
					Capital: $('#Capital').val(),
					Code2: $('#Code2').val(),
			});
		}
	</script>
</head>
<body>
	<div id="tb" style="padding:3px">
			<span>Code:</span>
			<input id="Code" style="line-height:26px;border:1px solid #ccc">
			<span>Name:</span>
			<input id="Name" style="line-height:26px;border:1px solid #ccc">
			<span>Continent:</span>
			<input id="Continent" style="line-height:26px;border:1px solid #ccc">
			<span>Region:</span>
			<input id="Region" style="line-height:26px;border:1px solid #ccc">
			<span>SurfaceArea:</span>
			<input id="SurfaceArea" style="line-height:26px;border:1px solid #ccc">
			<span>IndepYear:</span>
			<input id="IndepYear" style="line-height:26px;border:1px solid #ccc">
			<span>Population:</span>
			<input id="Population" style="line-height:26px;border:1px solid #ccc">
			<span>LifeExpectancy:</span>
			<input id="LifeExpectancy" style="line-height:26px;border:1px solid #ccc">
			<span>GNP:</span>
			<input id="GNP" style="line-height:26px;border:1px solid #ccc">
			<span>GNPOld:</span>
			<input id="GNPOld" style="line-height:26px;border:1px solid #ccc">
			<span>LocalName:</span>
			<input id="LocalName" style="line-height:26px;border:1px solid #ccc">
			<span>GovernmentForm:</span>
			<input id="GovernmentForm" style="line-height:26px;border:1px solid #ccc">
			<span>HeadOfState:</span>
			<input id="HeadOfState" style="line-height:26px;border:1px solid #ccc">
			<span>Capital:</span>
			<input id="Capital" style="line-height:26px;border:1px solid #ccc">
			<span>Code2:</span>
			<input id="Code2" style="line-height:26px;border:1px solid #ccc">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"  plain="true" onclick="doSearch()">Search</a>
	</div>
	<table id="dg" title="支付配置" class="easyui-datagrid" style="width:100%;height:450px"
			url="http://localhost:8080/WebUtils2/country/countrySearch"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="Code" width="50">Code</th>
				<th field="Name" width="50">Name</th>
				<th field="Continent" width="50">Continent</th>
				<th field="Region" width="50">Region</th>
				<th field="SurfaceArea" width="50">SurfaceArea</th>
				<th field="IndepYear" width="50">IndepYear</th>
				<th field="Population" width="50">Population</th>
				<th field="LifeExpectancy" width="50">LifeExpectancy</th>
				<th field="GNP" width="50">GNP</th>
				<th field="GNPOld" width="50">GNPOld</th>
				<th field="LocalName" width="50">LocalName</th>
				<th field="GovernmentForm" width="50">GovernmentForm</th>
				<th field="HeadOfState" width="50">HeadOfState</th>
				<th field="Capital" width="50">Capital</th>
				<th field="Code2" width="50">Code2</th>
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
				<label>Code:</label>
				<input name="Code" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Name:</label>
				<input name="Name" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Continent:</label>
				<input name="Continent" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Region:</label>
				<input name="Region" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>SurfaceArea:</label>
				<input name="SurfaceArea" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>IndepYear:</label>
				<input name="IndepYear" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Population:</label>
				<input name="Population" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>LifeExpectancy:</label>
				<input name="LifeExpectancy" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>GNP:</label>
				<input name="GNP" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>GNPOld:</label>
				<input name="GNPOld" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>LocalName:</label>
				<input name="LocalName" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>GovernmentForm:</label>
				<input name="GovernmentForm" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>HeadOfState:</label>
				<input name="HeadOfState" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Capital:</label>
				<input name="Capital" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>Code2:</label>
				<input name="Code2" class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRecord()">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
</body>
</html>