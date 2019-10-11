package com.funzzz.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.funzzz.model.Employees;
import com.funzzz.utils.UncheckedCast;


public class ExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Object obj = map.get("list");
		List<Employees> list = UncheckedCast.castList(obj, Employees.class);
		
		for (Employees employees : list) {
			System.out.println(employees);
		}
		
	}

}


