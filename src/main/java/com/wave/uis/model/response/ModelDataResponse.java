package com.wave.uis.model.response;

import java.util.List;

public class ModelDataResponse implements ResponseWrapper {

	private ResponseModel data;
	private List<ResponseModel> dataList;

	public ModelDataResponse() {
		super();
	}

	public ModelDataResponse(ResponseModel data) {
		this.data = data;
	}

	public ModelDataResponse(List<ResponseModel> dataList) {
		this.dataList = dataList;
	}

	public Object getData() {
		if (data == null) {
			return this.dataList;
		}
		return this.data;
	}

}
