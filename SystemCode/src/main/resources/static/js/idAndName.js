function showIdAndNameSelect(id, modelName, all) {
	var data = getDict(modelName);
	var select = $("#" + id);
	select.empty();

	if (all != undefined || all) {
		select.append("<option value=''>全部</option>");
	}

	$.each(data, function(id, name) {
		select.append("<option value ='" + id + "'>" + name + "</option>");
	});

	return data;
}

function getDict(modelName) {
	var v = sessionStorage[modelName];
	if (v == null || v == "") {
		$.ajax({
			type : 'get',
			url : '/idAndName/'+modelName,
			async : false,
			success : function(data) {
				v = {};
				$.each(data, function(i, d) {
					v[d.id] = d.name;
				});

				console.log(JSON.stringify(v));
				sessionStorage[modelName] = JSON.stringify(v);
			}
		});
	}
	
	return JSON.parse(sessionStorage[modelName]);
}
