package cn.wolfcode.quartz_test.webTest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;

/**
 * Created by WangZhe on 2018年12月12日.
 */

public class ExcelTest {
    public static void main(String[] args) throws Exception {
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/Users/lyyzw/Desktop/客户通二期（第二批数据）寿险1117.xls"));
        //得到Excel工作簿对象
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        //得到Excel工作表对象
        HSSFSheet sheet = wb.getSheetAt(0);
        //得到Excel工作表的行
        HSSFRow row = sheet.getRow(1);
        //得到Excel工作表指定行的单元格
        HSSFCell cell = row.getCell((short) 1);
        HSSFCellStyle cellStyle = cell.getCellStyle();//得到单元格样式
        System.out.println(cellStyle);
    }
}
