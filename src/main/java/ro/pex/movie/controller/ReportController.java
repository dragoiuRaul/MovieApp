package ro.pex.movie.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import ro.pex.movie.model.dto.ExcelWorkSheetDto;
import ro.pex.movie.model.dto.UserDto;
import ro.pex.movie.service.UserService;
import ro.pex.movie.service.reports.excel.ExcelReportService;


@RestController
@RequestMapping("/api")
public class ReportController {
	@Autowired
	private UserService userService;
	@Autowired
	private ExcelReportService excelService;

	@GetMapping("/report/excel")
	public ResponseEntity<StreamingResponseBody> excel() {
		List<UserDto> users = userService.getAll();
		StreamingResponseBody out = null;
		List<ExcelWorkSheetDto> workSheetsDtoList = new ArrayList<>();
		ExcelWorkSheetDto<UserDto> workSheet = new ExcelWorkSheetDto<>();
		try {
			XSSFWorkbook workBook = ((XSSFWorkbook) WorkbookFactory.create(true));
			workSheet.setContent(users);
			workSheet.setName("Name 1");
			workSheetsDtoList.add(workSheet);
			workSheet = new ExcelWorkSheetDto<>();
			workSheet.setContent(users);
			workSheet.setName("Name 2");
			workSheetsDtoList.add(workSheet);
			final byte[] content = excelService.writeToExcelInMultipleSheets( workSheetsDtoList,workBook);
			Files.write(new File("excel.xlsx").toPath(), content);
			out = outputStream -> {
				outputStream.write(content);
			};
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/csv");
		headers.add("Content-Disposition", "attachment; filename=\"myfilename.xlsx\"");
		headers.add("Pragma", "no-cache");
		headers.add("Cache-Control", "no-cache");
		return ResponseEntity.ok().headers(headers).body(out);
	}
}
