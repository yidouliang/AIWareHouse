package com.boot.security.server.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.boot.security.server.convert.ExcelProduct2ExecProduct;
import com.boot.security.server.dto.ExcelProduct;
import com.boot.security.server.model.ExecProduct;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel工具类
 * 
 * @author hebh
 *
 */
public class ExcelUtil {

	public static void excelLocal(String path, String fileName, String[] headers, List<Object[]> datas) {
		Workbook workbook = getWorkbook(headers, datas);
		if (workbook != null) {
			ByteArrayOutputStream byteArrayOutputStream = null;
			FileOutputStream fileOutputStream = null;
			try {
				byteArrayOutputStream = new ByteArrayOutputStream();
				workbook.write(byteArrayOutputStream);

				String suffix = ".xls";
				File file = new File(path + File.separator + fileName + suffix);
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}

				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(byteArrayOutputStream.toByteArray());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (fileOutputStream != null) {
						fileOutputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if (byteArrayOutputStream != null) {
						byteArrayOutputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 导出excel
	 * 
	 * @param fileName
	 * @param headers
	 * @param datas
	 * @param response
	 */
	public static void excelExport(String fileName, String[] headers, List<Object[]> datas,
			HttpServletResponse response) {
		Workbook workbook = getWorkbook(headers, datas);
		if (workbook != null) {
			ByteArrayOutputStream byteArrayOutputStream = null;
			try {
				byteArrayOutputStream = new ByteArrayOutputStream();
				workbook.write(byteArrayOutputStream);

				String suffix = ".xls";
				response.setContentType("application/vnd.ms-excel;charset=utf-8");
				response.setHeader("Content-Disposition",
						"attachment;filename=" + new String((fileName + suffix).getBytes(), "iso-8859-1"));

				OutputStream outputStream = response.getOutputStream();
				outputStream.write(byteArrayOutputStream.toByteArray());
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (byteArrayOutputStream != null) {
						byteArrayOutputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @param headers
	 *            列头
	 * @param datas
	 *            数据
	 * @return
	 */
	public static Workbook getWorkbook(String[] headers, List<Object[]> datas) {
		Workbook workbook = new HSSFWorkbook();

		Sheet sheet = workbook.createSheet();
		Row row = null;
		Cell cell = null;
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER_SELECTION);

		Font font = workbook.createFont();

		int line = 0, maxColumn = 0;
		if (headers != null && headers.length > 0) {// 设置列头
			row = sheet.createRow(line++);
			row.setHeightInPoints(23);
			font.setBold(true);
			font.setFontHeightInPoints((short) 13);
			style.setFont(font);

			maxColumn = headers.length;
			for (int i = 0; i < maxColumn; i++) {
				cell = row.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(style);
			}
		}

		if (datas != null && datas.size() > 0) {// 渲染数据
			for (int index = 0, size = datas.size(); index < size; index++) {
				Object[] data = datas.get(index);
				if (data != null && data.length > 0) {
					row = sheet.createRow(line++);
					row.setHeightInPoints(20);

					int length = data.length;
					if (length > maxColumn) {
						maxColumn = length;
					}

					for (int i = 0; i < length; i++) {
						cell = row.createCell(i);
						cell.setCellValue(data[i] == null ? null : data[i].toString());
					}
				}
			}
		}

		for (int i = 0; i < maxColumn; i++) {
			sheet.autoSizeColumn(i);
		}

		return workbook;
	}

    /**
     * 从Excel中导入ExecProduct信息
     * @param excel
     * @return
     */
	public static List<ExecProduct> ExcelImport(File excel) throws IOException {
        List<ExcelProduct> excelProductList = new ArrayList<>();
        Workbook wb;
        if(is2003Excel(excel)) {
            wb = new HSSFWorkbook(new FileInputStream(excel));
        } else {
            wb = new XSSFWorkbook(new FileInputStream(excel));
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        String[] content = new String[10];
        for(int i=0; i<wb.getNumberOfSheets(); i++) {
            sheet = wb.getSheetAt(i);
            for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                row = sheet.getRow(j);
                for (int z = 0; z < row.getLastCellNum(); z++) {
                    cell = row.getCell(z);
                    if (cell != null) {
                        cell.setCellType(CellType.STRING);
                        content[z] = cell.getStringCellValue();
                    }
                }
                ExcelProduct product = new ExcelProduct(content);
                excelProductList.add(product);
            }
        }
        return ExcelProduct2ExecProduct.convert(excelProductList);
    }

    /**
     * 判断Excel的版本
     * @param excel
     * @return
     */
    public static boolean is2003Excel(File excel) {
	    String originName = excel.getName();
	    String suffix = originName.substring(originName.lastIndexOf("."));
        return ".xls".equals(suffix);
    }

    /**
     * 判断该文件是否是Excel文件
     * @param excel
     * @return
     */
    public static boolean isExcel(File excel) {
        String originName = excel.getName();
        String suffix = originName.substring(originName.lastIndexOf("."));
        return ".xls".equals(suffix) || ".xlsx".equals(suffix);
    }


}
