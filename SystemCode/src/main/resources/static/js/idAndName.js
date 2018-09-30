function showIdAndNameSelect(id, modelName, oriId, all) {
	var data = getDict(modelName);
	var select = $("#" + id);
	select.empty();

	if (all != undefined || all) {
		select.append("<option value=''>全部</option>");
	}

	$.each(data, function(id, name, oriId) {
		if(oriId === id)
		    select.append("<option value ='" + id + "' selected>" + name + "</option>");
		else
            select.append("<option value ='" + id + "'>" + name + "</option>");

    });

	return data;
}

function getDict(modelName) {
		$.ajax({
			type : 'get',
			url : '/idAndName/'+modelName,
			async : false,
			success : function(data) {
				v = {};
				$.each(data, function(i, d) {
					v[d.id] = d.name;
				});

				sessionStorage[modelName] = JSON.stringify(v);
			}
		});

	return JSON.parse(sessionStorage[modelName]);
}
