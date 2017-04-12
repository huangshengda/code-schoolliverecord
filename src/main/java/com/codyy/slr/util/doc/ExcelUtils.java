package com.codyy.slr.util.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codyy.slr.util.BeanUtils;
import com.codyy.slr.util.StringUtils;
import com.codyy.slr.util.doc.annotation.ExcelColumn;
import com.codyy.slr.vo.ValueBean;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * 
 * ClassName:ExcelUtils Function: 操作Excel工具类 功能 : Excel文件的导入 Excel文件的导出
 * 
 * @author zhangtian
 * @Date 2014 2014年8月8日 下午7:15:51
 *
 */
public class ExcelUtils {

	private final String DEFAULT_SHEET_NAME = "sheet1";
	public final static String EXCEL_TYPE_XLS = "xls";
	public final static String EXCEL_TYPE_XLSX = "xlsx";
	private final int MAX_SHEET_SIZE = 65000;
	// === HSSFWorkbook对象
	private HSSFWorkbook workbook = null;
	// === XSSFWorkbook对象
	private XSSFWorkbook xssfWorkbook = null;
	// === Excel文件的头部标题样式
	private HSSFCellStyle headerStyle = null;
	// === Excel文件的第二行提示信息样式
	private HSSFCellStyle warnerStyle = null;
	// === Excel文件列头的样式
	private HSSFCellStyle titleStyle = null;
	// === Excel文件的数据样式
	private HSSFCellStyle dataStyle = null;
	// === Excel文件中的错误数据的显示样式
	private HSSFCellStyle errorDataStyle = null;

	private static Map<Character, String> transferMap = null;// 需要转换的字符
	static {
		transferMap = new HashMap<Character, String>();
		transferMap.put('<', "&lt;");
		transferMap.put('>', "&gt;");
		transferMap.put('&', "&amp;");
		transferMap.put('\'', "&apos;");
		transferMap.put('"', "&quot;");
		transferMap.put('\r', "");
		transferMap.put('\n', "<br>");
	}

	public static String trans(String value) {
		if (value == null) {
			return value;
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			String str = transferMap.get(ch);
			if (str != null) {
				buffer.append(str);
			} else {
				buffer.append(ch);
			}
		}
		return buffer.toString();
	}

	// ======================================== Excel 公共方法调用
	// =============================================
	/*
	 * 获取HSSFWorkbook对象
	 */
	private HSSFWorkbook getHSSFWorkbook() {

		return new HSSFWorkbook();
	}

	private HSSFWorkbook getHSSFWorkbook(POIFSFileSystem in) throws IOException {

		return new HSSFWorkbook(in);
	}

	private XSSFWorkbook getXSSFWorkbook(InputStream in) throws IOException {

		return new XSSFWorkbook(in);
	}

	// ======================================= 创建公共样式
	// ==============================================
	/*
	 * 设置Excel文件的头部标题的样式
	 */
	private void setHeaderCellStyles(HSSFWorkbook workbook, HSSFSheet sheet) {
		headerStyle = workbook.createCellStyle();

		// === 设置边框
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		headerStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("粗体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 16);

		// === 设置粗体显示
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// === 选择需要用到的字体格式
		headerStyle.setFont(font);
		// === 设置自动换行
		// headerStyle.setWrapText(true) ;
		// sheet.autoSizeColumn((short)0, true); // === 调整第一列宽度
	}

	/*
	 * 设置Excel文件的第二列的注意事项提示信息的样式
	 */
	@SuppressWarnings("unused")
	private void setWarnerCellStyles(HSSFWorkbook workbook, HSSFSheet sheet) {
		warnerStyle = workbook.createCellStyle();

		// === 设置边框
		warnerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		warnerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		warnerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		warnerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		warnerStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		warnerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置左对齐
		warnerStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 10);

		// === 设置粗体显示
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// === 设置字体颜色
		font.setColor(HSSFColor.RED.index);

		// === 选择需要用到的字体格式
		warnerStyle.setFont(font);

		// === 设置自动换行
		warnerStyle.setWrapText(true);
	}

	/*
	 * 设置Excel文件的列头样式
	 */
	private void setTitleCellStyles(HSSFWorkbook workbook, HSSFSheet sheet) {
		titleStyle = workbook.createCellStyle();
		// === 设置边框
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		titleStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("粗体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 12);

		// === 设置粗体显示
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// === 选择需要用到的字体格式
		titleStyle.setFont(font);

		// === 设置自动换行
		// titleStyle.setWrapText(true) ;
	}

	/*
	 * 设置Excel文件的数据样式
	 */
	private void setDataCellStyles(HSSFWorkbook workbook, HSSFSheet sheet) {
		dataStyle = workbook.createCellStyle();
		// === 设置单元格格式为文本格式
		HSSFDataFormat dataFormat = workbook.createDataFormat();
		dataStyle.setDataFormat(dataFormat.getFormat("@"));
		dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		dataStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		dataStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		dataStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 11);

		// === 选择需要用到的字体格式
		dataStyle.setFont(font);

		// === 设置自动换行
		// dataStyle.setWrapText(true) ;
	}

	/*
	 * 错误数据重新导入Excel中的样式
	 */
	private void setErrorDataStyle(HSSFWorkbook workbook, HSSFSheet sheet) {
		errorDataStyle = workbook.createCellStyle();
		// === 设置边框颜色
		errorDataStyle.setBottomBorderColor(HSSFColor.RED.index);
		errorDataStyle.setLeftBorderColor(HSSFColor.RED.index);
		errorDataStyle.setRightBorderColor(HSSFColor.RED.index);
		errorDataStyle.setTopBorderColor(HSSFColor.RED.index);

		// === 设置边框
		errorDataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		errorDataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		errorDataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		errorDataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		errorDataStyle.setFillForegroundColor(HSSFColor.ROSE.index);
		errorDataStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		errorDataStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 11);

		// === 选择需要用到的字体格式
		errorDataStyle.setFont(font);
	}

	// ======================================= 创建公共数据
	// ==============================================
	private void createAppRowHeaderData(HSSFSheet sheet, String headerTitle, Integer cellHeaderNum) {

		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 800);

		HSSFCell headerCell = row.createCell(0);
		headerCell.setCellValue(new HSSFRichTextString(headerTitle));
		headerCell.setCellStyle(headerStyle);

		if (cellHeaderNum != 0) {
			// 创建Excel头，第一行所有单元格
			for (int i = 1; i < cellHeaderNum; i++) {
				headerCell = row.createCell(i);
				headerCell.setCellStyle(headerStyle);
				sheet.autoSizeColumn((short) i, true);// 设置单元格自动调整内容大小
			}
			// === 合并头部单元格 参数：firstRow, lastRow, firstCol, lastCol
			sheet.addMergedRegion(new CellRangeAddress((short) 0, (short) 0, (short) 0, (short) (cellHeaderNum - 1)));
			// === 设置单元格自动列宽，中文支持较好
			// sheet.setColumnWidth(0, headerTitle.getBytes().length*2*256);
			/*
			 * for (int i = 0; i < cellHeaderNum; i++) {
			 * sheet.autoSizeColumn((short) i, true); }
			 */
		} else {
			sheet.autoSizeColumn((short) 0, true);
		}
	}

	private void createAppRowCellHeaderData(HSSFSheet sheet, List<String> cellHeader) {

		HSSFRow row = sheet.createRow(1);
		row.setHeight((short) 500);

		HSSFCell cellHeaderCell = null;
		if (CollectionUtils.isNotEmpty(cellHeader)) {
			for (int i = 0; i < cellHeader.size(); i++) {
				cellHeaderCell = row.createCell(i);
				cellHeaderCell.setCellValue(new HSSFRichTextString(cellHeader.get(i)));
				cellHeaderCell.setCellStyle(titleStyle);
				// === 设置列宽
				sheet.setColumnWidth(i, (short) 7000);
			}
		}

	}

	private void createAppRowHasData(HSSFSheet sheet, List<Object> appData, Class<?> clazz, Integer cellHeaderNum) {

		HSSFRow row = null;
		HSSFCell cellAppDataCell = null;
		ExcelColumn excelColumn = null;
		if (cellHeaderNum != 0) {
			if (CollectionUtils.isNotEmpty(appData)) {
				// === 行记录数
				for (int i = 0; i < appData.size(); i++) {
					// === 列记录数
					row = sheet.createRow(i + 2);
					Object o = appData.get(i);
					Field[] fields = o.getClass().getDeclaredFields();
					int j = 0;
					for (Field field : fields) {
						if (field.isAnnotationPresent(ExcelColumn.class)) {
							field.setAccessible(true);
							excelColumn = field.getAnnotation(ExcelColumn.class);
							try {
								cellAppDataCell = row.createCell(j);
								if (StringUtils.equals(excelColumn.autoIncrement(), "Y")) {
									cellAppDataCell.setCellValue(new HSSFRichTextString((i + 1) + ""));
								} else {
									Object value = field.get(o);
									if (value != null) {
										cellAppDataCell.setCellValue(new HSSFRichTextString(StringUtils.replaceEscapeChar(value.toString())));
									} else {
										cellAppDataCell.setCellValue(new HSSFRichTextString(""));
									}
								}
								cellAppDataCell.setCellStyle(dataStyle);
								j++;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	private void createAppRowErrorData(HSSFSheet sheet, List<Object> appData, Class<?> clazz, Integer cellHeaderNum) {
		HSSFRow row = null;
		HSSFCell cellAppDataCell = null;
		if (cellHeaderNum != 0) {
			if (CollectionUtils.isNotEmpty(appData)) {
				// === 行记录数
				for (int i = 0; i < appData.size(); i++) {
					// === 列记录数
					row = sheet.createRow(i + 2);
					Object o = appData.get(i);
					Field[] fields = o.getClass().getDeclaredFields();// 一个类中所有属性
					int j = 0;
					for (Field field : fields) {
						if (field.isAnnotationPresent(ExcelColumn.class)) {
							field.setAccessible(true);
							try {
								cellAppDataCell = row.createCell(j);
								Object value = field.get(o);// 获取属性值
								if (field.getType().isAssignableFrom(ValueBean.class)) {
									if (value != null) {
										ValueBean valueBean = (ValueBean) value;
										if (valueBean.getIsErr()) {
											cellAppDataCell.setCellValue(new HSSFRichTextString(valueBean.getValue()));
											cellAppDataCell.setCellStyle(errorDataStyle);
										} else {
											cellAppDataCell.setCellValue(new HSSFRichTextString(valueBean.getValue()));
											cellAppDataCell.setCellStyle(dataStyle);
										}
									} else {
										cellAppDataCell.setCellValue(new HSSFRichTextString(""));
										cellAppDataCell.setCellStyle(dataStyle);
									}
								} else {
									if (value != null) {
										cellAppDataCell.setCellValue(new HSSFRichTextString(value.toString()));
									} else {
										cellAppDataCell.setCellValue(new HSSFRichTextString(""));
									}
									cellAppDataCell.setCellStyle(dataStyle);
								}
								j++;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * exportContainDataExcelSheet:(这里用一句话描述这个方法的作用)
	 *
	 * @param headerTitle
	 *            标题信息
	 * @param warnerInfo
	 *            警告提示信息
	 * @param cellHeader
	 *            列头信息
	 * @param appData
	 *            导入Excel的数据 格式： List<List<String>> 外层List封装行数据，内层List封装列数据
	 * @param filePath
	 *            Excel文件存放路径
	 */
	// === 导出带有数据的Excel的表格
	@SuppressWarnings("unchecked")
	public HSSFWorkbook exportContainDataExcelSheet(Map<String, Object> results, Class<?> clazz) {
		// ======================== 页签创建 ==========================
		// === 获取HSSFWorkbook对象
		workbook = getHSSFWorkbook();
		// HSSFSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME);
		String headerTitle = results.get("headerName").toString();
		List<String> cellHeader = (List<String>) results.get("columnNames");
		Integer cellHeaderNum = cellHeader.size();
		List<Object> appData = (List<Object>) results.get("appDatas");
		// excel单个sheet最多可以显示65535条记录
		List<List<Object>> exportDatas = BeanUtils.splitCollection(appData, MAX_SHEET_SIZE);
		for (int i = 0; i < exportDatas.size(); i++) {
			HSSFSheet sheet = workbook.createSheet("sheet" + (i + 1));
			buildExportDataBySheet(sheet, headerTitle, cellHeaderNum, cellHeader, exportDatas.get(i), clazz);
		}
		return workbook;
		// ========================= 文件输出 ==========================
		// FileOutputStream out = new FileOutputStream(filePath);
		// workbook.write(out);
		// out.close();
	}

	public void buildExportDataBySheet(HSSFSheet sheet, String headerTitle, Integer cellHeaderNum, List<String> cellHeader, List<Object> appData,
			Class<?> clazz) {
		int maxSheetSize = MAX_SHEET_SIZE;
		if (CollectionUtils.isNotEmpty(appData)) {
			if (appData.size() > maxSheetSize) {
				appData = appData.subList(0, maxSheetSize);
			}
		}
		// ========================= 样式设置 =========================
		// === 设置表头样式
		setHeaderCellStyles(workbook, sheet);
		// === 设置列头样式
		setTitleCellStyles(workbook, sheet);
		// === 设置数据样式
		setDataCellStyles(workbook, sheet);

		// ========================= 数据创建 ==========================
		// === 创建标题数据
		createAppRowHeaderData(sheet, headerTitle, cellHeaderNum);
		// === 创建列头数据信息
		createAppRowCellHeaderData(sheet, cellHeader);
		// === 为空模板创建初始化数据 空数据样式
		createAppRowHasData(sheet, appData, clazz, cellHeaderNum);
	}

	/**
	 * 
	 * exportContainErrorDataExcelSheet:(这里用一句话描述这个方法的作用)
	 *
	 * @param headerTitle
	 *            标题信息
	 * @param warnerInfo
	 *            警告提示信息
	 * @param cellHeader
	 *            列头信息
	 * @param appData
	 *            导入Excel的数据 格式： List<List<String>> 外层List封装行数据，内层List封装列数据
	 *            String类型的列数据含有状态为信息，以&分割，且&之后为空或者0，表示正确的数据，&之后为1表示错误的数据
	 *            错误的数据，在生成的Excel中标记为外层红圈警告 如：张三&1 李四&0 王五
	 * @param filePath
	 *            Excel文件存放路径
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public HSSFWorkbook exportContainErrorDataExcelSheet(Map<String, Object> results, Class<?> clazz) {

		try {
			// ======================== 页签创建 ==========================
			// === 获取HSSFWorkbook对象
			workbook = getHSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME);

			// ========================= 样式设置 =========================
			// === 设置表头样式
			setHeaderCellStyles(workbook, sheet);
			// === 设置列头样式
			setTitleCellStyles(workbook, sheet);
			// === 设置数据样式
			setDataCellStyles(workbook, sheet);
			// === 设置错误数据样式
			setErrorDataStyle(workbook, sheet);

			// ========================= 数据创建 ==========================
			// === 创建标题数据
			createAppRowHeaderData(sheet, results.get("headerName").toString(), ((List<String>) results.get("columnNames")).size());
			// === 创建列头数据信息
			createAppRowCellHeaderData(sheet, (List<String>) results.get("columnNames"));
			// === 为空模板创建初始化数据 空数据样式
			createAppRowErrorData(sheet, (List<Object>) results.get("appDatas"), clazz, ((List<String>) results.get("columnNames")).size());

			// ========================= 文件输出 ==========================
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	// ======================================== Excel 导入公共方法
	// ==============================================
	/**
	 *
	 * importExcelData: Excel 模板严格按照生成的模板格式 获取列头信息 即获取了遍历的集合
	 * 每行应该具有的数据列数，必须强制满足条件 即：导入的数据行 列数必须与列头数保持一致 需要解析数据中是否有错误标记位，有则全部去掉
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public List<Object> importExcelData(String filePath, Class<?> clazz)
			throws FileNotFoundException, IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
		workbook = getHSSFWorkbook(fs);

		HSSFSheet sheet = workbook.getSheetAt(0);
		return importExcelData(sheet, clazz);
	}

	/**
	 * importExcelData2007:(Excel2007+文件解析特殊处理)
	 * 
	 * @return
	 * @author zhangtian
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public List<Object> importExcelData2007(InputStream in, Class<?> clazz)
			throws FileNotFoundException, IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {
		xssfWorkbook = getXSSFWorkbook(in);
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		return importExcelData(xssfSheet, clazz);
	}

	// 导入微信家校通学生档案数据
	public List<Object> importExcelData2007WX(InputStream in, Class<?> clazz, Integer headerRow, Integer lastRow)
			throws FileNotFoundException, IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {
		xssfWorkbook = getXSSFWorkbook(in);
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		return importExcelDataWX(xssfSheet, clazz, headerRow, lastRow);
	}

	/**
	 *
	 * importExcelDate: Excel 模板严格按照生成的模板格式 获取列头信息 即获取了遍历的集合
	 * 每行应该具有的数据列数，必须强制满足条件 即：导入的数据行 列数必须与列头数保持一致 需要解析数据中是否有错误标记位，有则全部去掉
	 * 
	 * @param in
	 * @throws IOException
	 * @throws ParseException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public List<Object> importExcelData(InputStream in, Class<?> clazz)
			throws IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		POIFSFileSystem fs = new POIFSFileSystem(in);
		workbook = getHSSFWorkbook(fs);

		HSSFSheet sheet = workbook.getSheetAt(0);
		return importExcelData(sheet, clazz);
	}

	public List<Object> importExcelData(InputStream in, Class<?> clazz, String... sheetNames)
			throws IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		POIFSFileSystem fs = new POIFSFileSystem(in);
		workbook = getHSSFWorkbook(fs);

		List<Object> objs = new ArrayList<Object>();
		if (ArrayUtils.isEmpty(sheetNames)) {
			return objs;
		}
		for (String sheetName : sheetNames) {
			HSSFSheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				continue;
			}
			List<Object> obj = importExcelData(sheet, clazz);
			objs.addAll(obj);

		}
		return objs;
	}

	/**
	 *
	 * importExcelData: Excel 模板严格按照生成的模板格式 获取列头信息 即获取了遍历的集合
	 * 每行应该具有的数据列数，必须强制满足条件 即：导入的数据行 列数必须与列头数保持一致 需要解析数据中是否有错误标记位，有则全部去掉
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public List<Object> importExcelData(File file, Class<?> clazz)
			throws FileNotFoundException, IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		workbook = getHSSFWorkbook(fs);

		HSSFSheet sheet = workbook.getSheetAt(0);
		return importExcelData(sheet, clazz);
	}

	public List<String> getExcelTitles(InputStream in, String excelType, Integer headerRow) throws IOException {
		Sheet sheet = null;

		if (StringUtils.equals(excelType, ExcelUtils.EXCEL_TYPE_XLS)) {
			POIFSFileSystem fs = new POIFSFileSystem(in);
			workbook = getHSSFWorkbook(fs);
			sheet = workbook.getSheetAt(0);
		} else {
			xssfWorkbook = getXSSFWorkbook(in);
			sheet = xssfWorkbook.getSheetAt(0);
		}

		List<String> titleNameList = new ArrayList<String>();

		Row headerCellRow = sheet.getRow(headerRow);
		Integer headerCellCountNum = Integer.valueOf(headerCellRow.getLastCellNum());

		for (int m = 0; m < headerCellCountNum; m++) {
			String titleColumnName = String.valueOf(headerCellRow.getCell(m).getRichStringCellValue().toString()).trim();
			titleNameList.add(titleColumnName);
		}

		return titleNameList;
	}

	/*
	 * Excel 模板严格按照生成的模板格式 获取列头信息 即获取了遍历的集合 每行应该具有的数据列数，必须强制满足条件 即：导入的数据行
	 * 列数必须与列头数保持一致 需要解析数据中是否有错误标记位，有则全部去掉 需要过滤掉全空数据，即每列数据均为空
	 */
	// modified by zhangtian 实现类用接口抽象
	private List<Object> importExcelData(Sheet sheet, Class<?> clazz)
			throws IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		// === 提取导入数据模板中的列头信息，即第三列的数据
		Row headerCellRow = sheet.getRow(1);
		Integer headerCellCountNum = Integer.valueOf(headerCellRow.getLastCellNum());
		List<Object> rowList = new ArrayList<Object>();
		// 存Excel列头名称和对象属性匹配的名称
		Map<String, String> columnMap = new HashMap<String, String>();

		// === 循环遍历字节码注解 获取属性名称
		Field[] fields = clazz.getDeclaredFields();// 获取javabean中所有属性名称UserImportModel.class
		for (int m = 0; m < headerCellCountNum; m++) {
			// 获取Excel列头名称
			String columnNameE = String.valueOf(headerCellRow.getCell(m).getRichStringCellValue().toString()).trim();
			for (Field field : fields) {
				if (field.isAnnotationPresent(ExcelColumn.class)) {// 判断属性是否有ExcelColumn注解
					ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
					String fieldName = field.getName();// UserImportModel.class对象中属性名称
					if (StringUtils.equals(excelColumn.columnName().trim(), columnNameE)) {
						columnMap.put(columnNameE, fieldName);
					}
				}
			}
		}

		// === 标记变量，消除全部的空行记录
		StringBuilder sb = new StringBuilder();

		Row dataRow = null;
		Cell dataCell = null;

		// === 循环遍历数据
		Integer rowNum = sheet.getLastRowNum();
		for (int i = 2; i <= rowNum; i++) {
			sb.delete(0, sb.length());
			sb.append(String.valueOf(i));
			dataRow = sheet.getRow(i);
			if (dataRow != null) {
				Object obj = clazz.newInstance();
				for (int j = 0; j < headerCellCountNum; j++) {
					dataCell = dataRow.getCell(j);
					// =================================== 读取Excel文件中的数据
					// 文本，数值或日期类型的条件判断 开始 =============================
					if (dataCell != null) {
						Object value = "";
						switch (dataCell.getCellType()) {
						// 数值类型
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(dataCell)) {// 日期
								// === 如果是date类型则 ，获取该cell的date值
								// value =
								// HSSFDateUtil.getJavaDate(dataCell.getNumericCellValue()).toString();
								Date date = dataCell.getDateCellValue();
								// SimpleDateFormat sdf = new
								// SimpleDateFormat("yyyy-MM-dd") ;
								// value = sdf.format(date) ;
								value = date;
							} else {// === 纯数字
								dataCell.setCellType(Cell.CELL_TYPE_STRING);
								value = dataCell.getRichStringCellValue().toString();
							}
							break;
						// 字符存类型
						case HSSFCell.CELL_TYPE_STRING:
							value = dataCell.getRichStringCellValue().toString();
							break;
						// 公式类型
						case HSSFCell.CELL_TYPE_FORMULA:
							// === 读公式计算值
							value = String.valueOf(dataCell.getNumericCellValue());
							// === 如果获取的数据值为非法值,则转换为获取字符串
							if (value.equals("NaN")) {
								value = dataCell.getRichStringCellValue().toString();
							}
							// cell.getCellFormula() ;//读公式
							break;
						// 布尔类型
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = dataCell.getBooleanCellValue();
							break;

						case HSSFCell.CELL_TYPE_BLANK:
							value = "";
							break;

						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;

						default:
							value = dataCell.getRichStringCellValue().toString();
							break;
						}
						sb.append(value);

						// === 每一行数据的列头是否匹配，决定如何反射设置属性的值
						String columnNameE = String.valueOf((sheet.getRow(1).getCell(j).getRichStringCellValue())).trim();
						String fieldName = columnMap.get(columnNameE);
						if (fieldName != null) {
							Field f = obj.getClass().getDeclaredField(fieldName);
							value = transValue(f, value);
							f.setAccessible(true);
							f.set(obj, value);
						}
					}
					// =================================== 读取Excel文件中的数据
					// 文本，数值或日期类型的条件判断 结束 =============================
				}
				if (StringUtils.trimToEmpty(sb.toString()).equals(String.valueOf(i))) {
					Collections.emptyList();
				} else {
					rowList.add(obj);
				}
			}

		}

		return rowList;
	}

	private Object transValue(Field f, Object value) {
		Type type = f.getGenericType();
		String typeName = type.toString();
		if (StringUtils.equals("class java.lang.Integer", typeName)) {
			value = Integer.parseInt(value.toString());
		} else if (StringUtils.equals("class java.util.Date", typeName)) {
			if (!(value instanceof Date)) {
				value = null;
			}
		}
		return value;
	}

	// 导入微信家校通学生档案数据
	public List<Object> importExcelDataWX(InputStream in, Class<?> clazz, Integer headerRow, Integer lastRow)
			throws IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		POIFSFileSystem fs = new POIFSFileSystem(in);
		workbook = getHSSFWorkbook(fs);

		HSSFSheet sheet = workbook.getSheetAt(0);
		return importExcelDataWX(sheet, clazz, headerRow, lastRow);
	}

	// 微信家校通 Excel动态列导入
	public List<Object> importExcelDataWXForDynamicColumn(InputStream in, Class<?> clazz, Integer headerRow, Integer lastRow)
			throws IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		POIFSFileSystem fs = new POIFSFileSystem(in);
		workbook = getHSSFWorkbook(fs);

		HSSFSheet sheet = workbook.getSheetAt(0);
		return importExcelDataWXForDynamicColumn(sheet, clazz, headerRow, lastRow);
	}

	// modified by AnChangyun 实现类用接口抽象 --微信家校通
	private List<Object> importExcelDataWX(Sheet sheet, Class<?> clazz, Integer headerRow, Integer lastRow)
			throws IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		// === 提取导入数据模板中的列头信息，即第三列的数据
		Row headerCellRow = sheet.getRow(headerRow);
		Integer headerCellCountNum = Integer.valueOf(headerCellRow.getLastCellNum());
		List<Object> rowList = new ArrayList<Object>();
		// 存Excel列头名称和对象属性匹配的名称
		Map<String, String> columnMap = new HashMap<String, String>();

		// === 循环遍历字节码注解 获取属性名称
		Field[] fields = clazz.getDeclaredFields();// 获取javabean中所有属性名称UserImportModel.class
		for (int m = 0; m < headerCellCountNum; m++) {
			// 获取Excel列头名称
			String columnNameE = String.valueOf(headerCellRow.getCell(m).getRichStringCellValue().toString()).trim();
			for (Field field : fields) {
				if (field.isAnnotationPresent(ExcelColumn.class)) {// 判断属性是否有ExcelColumn注解
					ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
					String fieldName = field.getName();// UserImportModel.class对象中属性名称
					if (StringUtils.equals(excelColumn.columnName().trim(), columnNameE)) {
						columnMap.put(columnNameE, fieldName);
					}
				}
			}
		}

		// === 标记变量，消除全部的空行记录
		StringBuilder sb = new StringBuilder();

		Row dataRow = null;
		Cell dataCell = null;

		// === 循环遍历数据
		Integer rowNum;
		if (lastRow == -1) {
			rowNum = sheet.getLastRowNum();
		} else {
			rowNum = lastRow;
		}
		for (int i = headerRow + 1; i <= rowNum; i++) {
			sb.delete(0, sb.length());
			sb.append(String.valueOf(i));
			dataRow = sheet.getRow(i);
			if (dataRow != null) {
				Object obj = clazz.newInstance();
				for (int j = 0; j < headerCellCountNum; j++) {
					dataCell = dataRow.getCell(j);
					// =================================== 读取Excel文件中的数据
					// 文本，数值或日期类型的条件判断 开始 =============================
					if (dataCell != null) {
						Object value = "";
						switch (dataCell.getCellType()) {
						// 数值类型
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(dataCell)) {// 日期
								// === 如果是date类型则 ，获取该cell的date值
								// value =
								// HSSFDateUtil.getJavaDate(dataCell.getNumericCellValue()).toString();
								Date date = dataCell.getDateCellValue();
								// SimpleDateFormat sdf = new
								// SimpleDateFormat("yyyy-MM-dd") ;
								// value = sdf.format(date) ;
								value = date;
							} else {// === 纯数字
								dataCell.setCellType(Cell.CELL_TYPE_STRING);
								String number = dataCell.getRichStringCellValue().toString();

								if ((Float.parseFloat(number) * 100) % 100 != 0) {
									value = Float.parseFloat(number);
								} else {
									value = Integer.parseInt(number);
								}
							}
							break;
						// 字符存类型
						case HSSFCell.CELL_TYPE_STRING:
							value = trans(dataCell.getRichStringCellValue().toString());
							break;
						// 公式类型
						case HSSFCell.CELL_TYPE_FORMULA:
							// === 读公式计算值
							value = String.valueOf(dataCell.getNumericCellValue());
							// === 如果获取的数据值为非法值,则转换为获取字符串
							if (value.equals("NaN")) {
								value = dataCell.getRichStringCellValue().toString();
							}
							// cell.getCellFormula() ;//读公式
							break;
						// 布尔类型
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = dataCell.getBooleanCellValue();
							break;

						case HSSFCell.CELL_TYPE_BLANK:
							value = "";
							break;

						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;

						default:
							value = dataCell.getRichStringCellValue().toString();
							break;
						}
						sb.append(value);

						// === 每一行数据的列头是否匹配，决定如何反射设置属性的值
						String columnNameE = String.valueOf((sheet.getRow(headerRow).getCell(j).getRichStringCellValue())).trim();
						String fieldName = columnMap.get(columnNameE);
						Field f = obj.getClass().getDeclaredField(fieldName);
						// 学生成绩导入用
						if (fieldName.equals("score")) {
							if (value == null || value.toString().equals("")) {
								value = null;
							} else {
								value = Float.parseFloat(value.toString());
							}
						}
						if (fieldName.equals("examName") || columnNameE.equals("年级") || columnNameE.equals("班级") || columnNameE.equals("学科")
								|| columnNameE.equals("名称")) {
							if (value == null || value.toString().equals("")) {
								value = null;
							} else {
								value = value.toString();
							}
						}

						value = transValue(f, value);
						f.setAccessible(true);
						f.set(obj, value);
					}
					// =================================== 读取Excel文件中的数据
					// 文本，数值或日期类型的条件判断 结束 =============================
				}
				if (StringUtils.trimToEmpty(sb.toString()).equals(String.valueOf(i))) {
					Collections.emptyList();
				} else {
					rowList.add(obj);
				}
			}

		}

		return rowList;
	}

	// 动态列导入
	private List<Object> importExcelDataWXForDynamicColumn(Sheet sheet, Class<?> clazz, Integer headerRow, Integer lastRow)
			throws IOException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {

		// === 提取导入数据模板中的列头信息，即第三列的数据
		Row headerCellRow = sheet.getRow(headerRow);
		Integer headerCellCountNum = Integer.valueOf(headerCellRow.getLastCellNum());
		List<Object> rowList = new ArrayList<Object>();
		// 存Excel列头名称和对象属性匹配的名称
		Map<String, String> columnMap = new HashMap<String, String>();

		// === 循环遍历字节码注解 获取属性名称
		Field[] fields = clazz.getDeclaredFields();// 获取javabean中所有属性名称UserImportModel.class
		for (int m = 0; m < headerCellCountNum; m++) {
			// 获取Excel列头名称
			String columnNameE = String.valueOf(headerCellRow.getCell(m).getRichStringCellValue().toString()).trim();
			for (Field field : fields) {
				if (field.isAnnotationPresent(ExcelColumn.class)) {// 判断属性是否有ExcelColumn注解
					ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
					String fieldName = field.getName();// UserImportModel.class对象中属性名称
					if (StringUtils.equals(excelColumn.columnName().trim(), columnNameE)) {
						columnMap.put(columnNameE, fieldName);
					}
				}
			}
		}

		// === 标记变量，消除全部的空行记录
		StringBuilder sb = new StringBuilder();

		Row dataRow = null;
		Cell dataCell = null;

		// === 循环遍历数据
		Integer rowNum;
		if (lastRow == -1) {
			rowNum = sheet.getLastRowNum();
		} else {
			rowNum = lastRow;
		}
		for (int i = headerRow + 1; i <= rowNum; i++) {
			sb.delete(0, sb.length());
			sb.append(String.valueOf(i));
			dataRow = sheet.getRow(i);
			if (dataRow != null) {
				Object obj = clazz.newInstance();
				for (int j = 0; j < headerCellCountNum; j++) {
					dataCell = dataRow.getCell(j);
					// =================================== 读取Excel文件中的数据
					// 文本，数值或日期类型的条件判断 开始 =============================
					if (dataCell != null) {
						Object value = "";
						switch (dataCell.getCellType()) {
						// 数值类型
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(dataCell)) {// 日期
								// === 如果是date类型则 ，获取该cell的date值
								// value =
								// HSSFDateUtil.getJavaDate(dataCell.getNumericCellValue()).toString();
								Date date = dataCell.getDateCellValue();
								// SimpleDateFormat sdf = new
								// SimpleDateFormat("yyyy-MM-dd") ;
								// value = sdf.format(date) ;
								value = date;
							} else {// === 纯数字
								dataCell.setCellType(Cell.CELL_TYPE_STRING);
								value = dataCell.getRichStringCellValue().toString();
							}
							break;
						// 字符存类型
						case HSSFCell.CELL_TYPE_STRING:
							value = dataCell.getRichStringCellValue().toString();
							break;
						// 公式类型
						case HSSFCell.CELL_TYPE_FORMULA:
							// === 读公式计算值
							value = String.valueOf(dataCell.getNumericCellValue());
							// === 如果获取的数据值为非法值,则转换为获取字符串
							if (value.equals("NaN")) {
								value = dataCell.getRichStringCellValue().toString();
							}
							// cell.getCellFormula() ;//读公式
							break;
						// 布尔类型
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = dataCell.getBooleanCellValue();
							break;

						case HSSFCell.CELL_TYPE_BLANK:
							value = "";
							break;

						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;

						default:
							value = dataCell.getRichStringCellValue().toString();
							break;
						}
						sb.append(value);

						// === 每一行数据的列头是否匹配，决定如何反射设置属性的值
						String columnNameE = String.valueOf((sheet.getRow(headerRow).getCell(j).getRichStringCellValue())).trim();
						String fieldName = columnMap.get(columnNameE);
						if (fieldName != null) {
							Field f = obj.getClass().getDeclaredField(fieldName);
							value = transValue(f, value);
							f.setAccessible(true);
							f.set(obj, value);
						} else {
							Field f = obj.getClass().getDeclaredField("map");
							f.setAccessible(true);
							Object o = f.get(obj);
							@SuppressWarnings("unchecked")
							Map<String, Object> map = (Map<String, Object>) o;
							if (map == null) {
								map = new HashMap<>();
							}
							value = transValue(f, value);
							map.put(columnNameE, value);
							f.set(obj, map);
						}
					}
					// =================================== 读取Excel文件中的数据
					// 文本，数值或日期类型的条件判断 结束 =============================
				}
				if (StringUtils.trimToEmpty(sb.toString()).equals(String.valueOf(i))) {
					Collections.emptyList();
				} else {
					try {
						Field f = obj.getClass().getDeclaredField("columnNum");
						f.setAccessible(true);
						f.set(obj, headerCellCountNum);
					} catch (NoSuchFieldException e) {

					}

					rowList.add(obj);
				}
			}

		}

		return rowList;
	}

	// 微信家校通 Excel动态列导出
	@SuppressWarnings("unchecked")
	public HSSFWorkbook exportContainDataExcelSheetForDynamicColumn(Map<String, Object> results, Integer columnOffset) {
		// ======================== 页签创建 ==========================
		// === 获取HSSFWorkbook对象
		workbook = getHSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME);
		// ========================= 样式设置 =========================
		// === 设置表头样式
		setHeaderCellStylesWX(workbook, sheet);
		// === 设置列头样式
		setTitleCellStylesWX(workbook, sheet);
		// === 设置数据样式
		setDataCellStylesWX(workbook, sheet);

		// ========================= 数据创建 ==========================
		// === 创建标题数据
		if (!results.get("headerName").toString().equals("")) {
			createAppRowHeaderDataWX(sheet, results.get("headerName").toString(), ((List<String>) results.get("columnNames")).size(), (short) (4 * 800));
			// === 创建列头数据信息
			createAppRowCellHeaderDataWX(sheet, (List<String>) results.get("columnNames"), 1);
			// === 为空模板创建初始化数据 空数据样式
			createAppRowHasDataWXForDynamicColumn(sheet, (List<Object>) results.get("appDatas"), (Map<String, Object>) results.get("columnMap"),
					((List<String>) results.get("columnNames")).size(), 2, columnOffset);
		} else {
			// === 创建列头数据信息
			createAppRowCellHeaderDataWX(sheet, (List<String>) results.get("columnNames"), 0);
			// === 为空模板创建初始化数据 空数据样式
			createAppRowHasDataWXForDynamicColumn(sheet, (List<Object>) results.get("appDatas"), (Map<String, Object>) results.get("columnMap"),
					((List<String>) results.get("columnNames")).size(), 1, columnOffset);
		}
		return workbook;
	}

	// 动态列导出
	private void createAppRowHasDataWXForDynamicColumn(HSSFSheet sheet, List<Object> appData, Map<String, Object> columnMap, Integer cellHeaderNum,
			Integer rowOffset, Integer columnOffset) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HSSFRow row = null;
		HSSFCell cellAppDataCell = null;
		ExcelColumn excelColumn = null;
		if (cellHeaderNum != 0) {
			if (CollectionUtils.isNotEmpty(appData)) {
				// === 行记录数
				for (int i = 0; i < appData.size(); i++) {
					// === 列记录数
					row = sheet.createRow(i + rowOffset);
					Object o = appData.get(i);
					Field[] fields = o.getClass().getDeclaredFields();
					int j = 0;
					for (Field field : fields) {
						try {
							if (field.isAnnotationPresent(ExcelColumn.class)) {
								field.setAccessible(true);
								excelColumn = field.getAnnotation(ExcelColumn.class);
								cellAppDataCell = row.createCell(j);
								if (StringUtils.equals(excelColumn.autoIncrement(), "Y")) {
									cellAppDataCell.setCellValue(new HSSFRichTextString((i + 1) + ""));
								} else {
									Object value = field.get(o);
									if (value != null) {
										if (value instanceof java.util.Date || value instanceof java.sql.Date) {
											cellAppDataCell.setCellValue(sdf.format((Date) value));
										} else {
											cellAppDataCell.setCellValue(new HSSFRichTextString(StringUtils.replaceEscapeChar(value.toString())));
										}
									} else {
										cellAppDataCell.setCellValue(new HSSFRichTextString(""));
									}
								}
								cellAppDataCell.setCellStyle(dataStyle);
								j++;
							} else {
								field.setAccessible(true);
								Object value = field.get(o);
								if (value != null) {
									if (value instanceof java.util.Map) {
										@SuppressWarnings("unchecked")
										Map<String, Object> map = (Map<String, Object>) value;
										int size = columnMap.size();
										for (int k = 0; k < size; k++) {
											int index = k + columnOffset;
											cellAppDataCell = row.createCell(index);
											cellAppDataCell.setCellValue(new HSSFRichTextString(
													StringUtils.replaceEscapeChar((String) map.get(columnMap.get(String.valueOf(index))))));
											cellAppDataCell.setCellStyle(dataStyle);
										}
										// for (Map.Entry<String, Object> entry
										// : map.entrySet()){
										// cellAppDataCell =
										// row.getCell((Integer)
										// columnMap.get(entry.getKey()) +
										// columnOffset);
										// cellAppDataCell.setCellValue(new
										// HSSFRichTextString(
										// com.codyy.commons.utils.StringUtils.replaceEscapeChar(entry.getValue().toString())));
										// //
										// cellAppDataCell.setCellStyle(dataStyle);
										// }
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	// 微信家校通成长档案导出
	private void createAppRowCellHeaderDataWX(HSSFSheet sheet, List<String> cellHeader, Integer hDataRow) {

		HSSFRow row = sheet.createRow(hDataRow);
		row.setHeight((short) 500);

		HSSFCell cellHeaderCell = null;
		if (CollectionUtils.isNotEmpty(cellHeader)) {
			for (int i = 0; i < cellHeader.size(); i++) {
				cellHeaderCell = row.createCell(i);
				cellHeaderCell.setCellValue(new HSSFRichTextString(cellHeader.get(i)));
				cellHeaderCell.setCellStyle(titleStyle);
				// === 设置列宽
				sheet.setColumnWidth(i, (short) 7000);
			}
		}

	}

	// ======================================= 创建公共数据 ---微信家校通
	// ==============================================
	private void createAppRowHeaderDataWX(HSSFSheet sheet, String headerTitle, Integer cellHeaderNum, short height) {

		HSSFRow row = sheet.createRow(0);

		HSSFCell headerCell = row.createCell(0);
		headerCell.setCellValue(new HSSFRichTextString(headerTitle));
		headerCell.setCellStyle(headerStyle);

		if (cellHeaderNum != 0) {
			// 创建Excel头，第一行所有单元格
			for (int i = 1; i < cellHeaderNum; i++) {
				headerCell = row.createCell(i);
				headerCell.setCellStyle(headerStyle);
				sheet.autoSizeColumn((short) i, true);// 设置单元格自动调整内容大小
			}
			// === 合并头部单元格 参数：firstRow, lastRow, firstCol, lastCol
			sheet.addMergedRegion(new CellRangeAddress((short) 0, (short) 0, (short) 0, (short) (cellHeaderNum - 1)));
			// === 设置单元格自动列宽，中文支持较好
			// sheet.setColumnWidth(0, headerTitle.getBytes().length*2*256);
			/*
			 * for (int i = 0; i < cellHeaderNum; i++) {
			 * sheet.autoSizeColumn((short) i, true); }
			 */
			row.setHeight(height);
		} else {
			sheet.autoSizeColumn((short) 0, true);
		}
	}

	/*
	 * 设置Excel文件的头部标题的样式 --微信家校通
	 */
	private void setHeaderCellStylesWX(HSSFWorkbook workbook, HSSFSheet sheet) {
		headerStyle = workbook.createCellStyle();

		// === 设置边框
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		// headerStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		// headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 11);

		// === 设置粗体显示
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// === 选择需要用到的字体格式
		headerStyle.setFont(font);
		// === 设置自动换行
		headerStyle.setWrapText(true);
		// sheet.autoSizeColumn((short)0, true); // === 调整第一列宽度
	}

	/*
	 * 设置Excel文件的列头样式 --微信家校通
	 */
	private void setTitleCellStylesWX(HSSFWorkbook workbook, HSSFSheet sheet) {
		titleStyle = workbook.createCellStyle();
		// === 设置边框
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		titleStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
		titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("粗体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 12);

		// === 设置粗体显示
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// === 选择需要用到的字体格式
		titleStyle.setFont(font);

		// === 设置自动换行
		// titleStyle.setWrapText(true) ;
	}

	/*
	 * 设置Excel文件的数据样式 --微信家校通
	 */
	private void setDataCellStylesWX(HSSFWorkbook workbook, HSSFSheet sheet) {
		dataStyle = workbook.createCellStyle();
		// === 设置单元格格式为文本格式
		HSSFDataFormat dataFormat = workbook.createDataFormat();
		dataStyle.setDataFormat(dataFormat.getFormat("@"));
		dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		// dataStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
		// dataStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		dataStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		dataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 11);

		// === 选择需要用到的字体格式
		dataStyle.setFont(font);

		// === 设置自动换行
		dataStyle.setWrapText(true);
	}

	// 微信家校通 Excel动态列导出模板
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HSSFWorkbook exportTemplateForDynamicColumn(String header, Map<Integer, Object> results, Integer columnOffset) {
		// ======================== 页签创建 ==========================
		// === 获取HSSFWorkbook对象
		workbook = getHSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME);
		// ========================= 样式设置 =========================
		// === 设置表头样式
		setHeaderCellStylesWX(workbook, sheet);
		// === 设置列头样式
		setTitleCellStylesWXForTemplate(workbook, sheet);
		// === 设置数据样式
		setDataCellStylesWX(workbook, sheet);

		// ========================= 数据创建 ==========================

		// 创建表头
		if (StringUtils.isNotBlank(header)) {
			createAppRowHeaderDataWX(sheet, header, 6, (short) (2 * 800));
		}

		// === 创建列头数据信息
		for (Map.Entry entry : results.entrySet()) {
			createAppRowCellHeaderForTemplate(sheet, (List<String>) entry.getValue(), (Integer) entry.getKey());
		}

		return workbook;
	}

	/*
	 * 设置Excel文件的列头样式 --微信家校通 导出模板
	 */
	private void setTitleCellStylesWXForTemplate(HSSFWorkbook workbook, HSSFSheet sheet) {
		titleStyle = workbook.createCellStyle();
		// === 设置边框
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// === 设置背景色
		titleStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// === 设置居中
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// === 设置字体
		HSSFFont font = workbook.createFont();
		font.setFontName("粗体");

		// === 设置字体大小
		font.setFontHeightInPoints((short) 11);

		// === 设置粗体显示
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// === 选择需要用到的字体格式
		titleStyle.setFont(font);

		// === 设置自动换行
		// titleStyle.setWrapText(true) ;
	}

	private void createAppRowCellHeaderForTemplate(HSSFSheet sheet, List<String> cellHeader, Integer hDataRow) {

		HSSFRow row = sheet.createRow(hDataRow);
		row.setHeight((short) 300);

		HSSFCell cellHeaderCell = null;
		if (CollectionUtils.isNotEmpty(cellHeader)) {
			for (int i = 0; i < cellHeader.size(); i++) {
				cellHeaderCell = row.createCell(i);
				cellHeaderCell.setCellValue(new HSSFRichTextString(cellHeader.get(i)));
				cellHeaderCell.setCellStyle(titleStyle);
				// === 设置列宽
				sheet.setColumnWidth(i, (short) 3000);
			}
		}

	}

	// === 导出带有数据的Excel的表格 --微信家校通
	@SuppressWarnings("unchecked")
	public HSSFWorkbook exportContainDataExcelSheetWX(Map<String, Object> results, Class<?> clazz) {
		// ======================== 页签创建 ==========================
		// === 获取HSSFWorkbook对象
		workbook = getHSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME);
		// ========================= 样式设置 =========================
		// === 设置表头样式
		setHeaderCellStylesWX(workbook, sheet);
		// === 设置列头样式
		setTitleCellStylesWX(workbook, sheet);
		// === 设置数据样式
		setDataCellStylesWX(workbook, sheet);

		// ========================= 数据创建 ==========================
		// === 创建标题数据
		if (!results.get("headerName").toString().equals("")) {
			createAppRowHeaderDataWX(sheet, results.get("headerName").toString(), ((List<String>) results.get("columnNames")).size(), (short) (4 * 800));
		}
		// === 创建列头数据信息
		if (!results.get("headerName").toString().equals("")) {
			createAppRowCellHeaderDataWX(sheet, (List<String>) results.get("columnNames"), 1);
		} else {
			createAppRowCellHeaderDataWX(sheet, (List<String>) results.get("columnNames"), 0);
		}

		// === 为空模板创建初始化数据 空数据样式
		if (!results.get("headerName").toString().equals("")) {
			createAppRowHasDataWX(sheet, (List<Object>) results.get("appDatas"), clazz, ((List<String>) results.get("columnNames")).size(), 2);
		} else {
			createAppRowHasDataWX(sheet, (List<Object>) results.get("appDatas"), clazz, ((List<String>) results.get("columnNames")).size(), 1);
		}

		return workbook;
		// ========================= 文件输出 ==========================
		// FileOutputStream out = new FileOutputStream(filePath);
		// workbook.write(out);
		// out.close();
	}

	// 微信家校通-->成长档案导出
	private void createAppRowHasDataWX(HSSFSheet sheet, List<Object> appData, Class<?> clazz, Integer cellHeaderNum, Integer hDataRowNum) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HSSFRow row = null;
		HSSFCell cellAppDataCell = null;
		ExcelColumn excelColumn = null;
		if (cellHeaderNum != 0) {
			if (CollectionUtils.isNotEmpty(appData)) {
				// === 行记录数
				for (int i = 0; i < appData.size(); i++) {
					// === 列记录数
					row = sheet.createRow(i + hDataRowNum);
					Object o = appData.get(i);
					Field[] fields = o.getClass().getDeclaredFields();
					int j = 0;
					for (Field field : fields) {
						if (field.isAnnotationPresent(ExcelColumn.class)) {
							field.setAccessible(true);
							excelColumn = field.getAnnotation(ExcelColumn.class);
							try {
								cellAppDataCell = row.createCell(j);
								if (StringUtils.equals(excelColumn.autoIncrement(), "Y")) {
									cellAppDataCell.setCellValue(new HSSFRichTextString((i + 1) + ""));
								} else {
									Object value = field.get(o);
									if (value != null) {
										if (value instanceof java.util.Date || value instanceof java.sql.Date) {
											cellAppDataCell.setCellValue(sdf.format((Date) value));
										} else {
											cellAppDataCell.setCellValue(new HSSFRichTextString(StringUtils.replaceEscapeChar(value.toString())));
										}
									} else {
										cellAppDataCell.setCellValue(new HSSFRichTextString(""));
									}
								}
								cellAppDataCell.setCellStyle(dataStyle);
								j++;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}
