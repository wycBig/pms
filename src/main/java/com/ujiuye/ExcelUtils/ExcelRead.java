package com.ujiuye.ExcelUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelRead {
    public static String getExcelContent(Cell cell){
        String result = "";
        switch (cell.getCellType()){
            case HSSFCell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                result = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                result = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                result = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                result = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                result = cell.getStringCellValue();
                break;
            default:
                result="";
                break;
        }
        return result;
    }
}
