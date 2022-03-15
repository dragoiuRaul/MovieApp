package ro.pex.movie.service.reports.excel;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import ro.pex.movie.model.dto.ExcelWorkSheetDto;

@Service
public class ExcelReportService {

	@SuppressWarnings("unchecked")
	public <T> byte[] writeToExcelInMultipleSheets(@SuppressWarnings("rawtypes") List<ExcelWorkSheetDto> workSheetsDtoList, XSSFWorkbook workbook)
			throws Exception {
		if (workSheetsDtoList == null || (workSheetsDtoList != null && workSheetsDtoList.isEmpty()) || workbook == null) {
			return null;
		}
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		for (ExcelWorkSheetDto<T> currentWorksheet : workSheetsDtoList) {
			Sheet sheet = null;
			int rowCount = 0;
			int columnCount = 0;
			sheet = workbook.createSheet(currentWorksheet.getName());
			Class<? extends Object> clazz = currentWorksheet.getContent().get(0).getClass();
			List<String> fieldNames = getFieldNamesForClass(clazz);
			Row row = sheet.createRow(rowCount++);
			createHeaderColumns(workbook, fieldNames, columnCount, row);
			for (T currentData : currentWorksheet.getContent()) {
				row = sheet.createRow(rowCount++);
				columnCount = 0;
				for (String fieldName : fieldNames) {
					Cell cell = row.createCell(columnCount);
					CellStyle cellStyle = workbook.createCellStyle();
					Object value = getValueThroughReflection(clazz, currentData, fieldName);
					if (value != null) {
						setCellValueBasedOnDataType(workbook, cell, cellStyle, value);
					}

					columnCount++;
				}
			}
		}
		workbook.write(result);
		result.flush();

		return result.toByteArray();
	}

	// retrieve field names from a POJO class
	private List<String> getFieldNamesForClass(Class<?> clazz) throws Exception {
		List<String> fieldNames = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fieldNames.add(fields[i].getName());
		}

		return fieldNames;
	}

	private void createHeaderColumns(XSSFWorkbook workbook, List<String> fieldNames, int columnCount, Row row) {
		for (String fieldName : fieldNames) {
			Cell cell = row.createCell(columnCount++);
			CellStyle cellStyle = getCenterAlignedCellStyle(workbook);
			cellStyle.setFont(getHeaderBoldFont(workbook));
			cellStyle.setFillForegroundColor(IndexedColors.BLUE.index);
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(fieldName.toUpperCase());
		}
	}

	private String capitalize(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	private CellStyle getCurrencyCellStyle(Workbook workbook) {
		CellStyle currencyStyle = workbook.createCellStyle();
		currencyStyle.setWrapText(true);
		DataFormat df = workbook.createDataFormat();
		currencyStyle.setDataFormat(df.getFormat("#0.00"));
		return currencyStyle;
	}

	private Font getHeaderBoldFont(Workbook workbook) {
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight((short) (10 * 20));
		font.setFontName("Calibri");
		font.setColor(IndexedColors.WHITE.getIndex());
		return font;
	}

	private CellStyle getCenterAlignedCellStyle(Workbook workbook) {
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);
		cellStyle.setBorderTop(BorderStyle.NONE);
		cellStyle.setBorderBottom(BorderStyle.NONE);
		cellStyle.setBorderLeft(BorderStyle.NONE);
		cellStyle.setBorderRight(BorderStyle.NONE);
		return cellStyle;
	}

	private CellStyle getLeftAlignedCellStyle(Workbook workbook, Font font) {
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HorizontalAlignment.LEFT);
		cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);
		cellStyle.setBorderTop(BorderStyle.NONE);
		cellStyle.setBorderBottom(BorderStyle.NONE);
		cellStyle.setBorderLeft(BorderStyle.NONE);
		cellStyle.setBorderRight(BorderStyle.NONE);
		return cellStyle;
	}

	private <T> Object getValueThroughReflection(Class<? extends Object> clazz, T data, String fieldName)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = null;
		try {
			method = clazz.getMethod("get" + capitalize(fieldName));
		} catch (NoSuchMethodException nme) {
			method = clazz.getMethod("get" + fieldName);
		}
		Object value = method.invoke(data, (Object[]) null);
		return value;
	}

	private void setCellValueBasedOnDataType(XSSFWorkbook workbook, Cell cell, CellStyle cellStyle, Object value) {
		CreationHelper createHelper = workbook.getCreationHelper();
		if (value instanceof String) {
			cell.setCellValue((String) value);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Double) {
			cell.setCellStyle(getCurrencyCellStyle(workbook));
			cell.setCellValue((Double) value);
		} else if (value instanceof LocalDate) {
			cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
			cell.setCellStyle(cellStyle);
			cell.setCellValue((LocalDate) value);
		} else if (value instanceof Boolean) {
			cell.setCellStyle(getCenterAlignedCellStyle(workbook));
			if (value.equals(true)) {
				cell.setCellValue(1);
			} else {
				cell.setCellValue(0);
			}
		}
	}

}
