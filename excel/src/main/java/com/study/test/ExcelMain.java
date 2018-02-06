package com.study.test;

import com.study.entity.Student;
import com.study.util.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelMain {
    public static void main(String[] args) {
        List<Student> dataSet = new ArrayList<Student>();
        dataSet.add(new Student(10000001, "张三", 20, true, new Date()));
        dataSet.add(new Student(20000002, "李丽", 24, false, new Date()));
        dataSet.add(new Student(30000003, "王五", 22, true, new Date()));

        LinkedHashMap<String, String> propertyHeaderMap = new LinkedHashMap<>();
        //propertyHeaderMap.put("id", "唯一标识"); //注释掉，不导出id
        propertyHeaderMap.put("name", "姓名");
        propertyHeaderMap.put("age", "年龄");
        propertyHeaderMap.put("sexName", "性别"); //直接获取Student中的sexName，而不是sex
        propertyHeaderMap.put("birthday", "生日");

        try {
            XSSFWorkbook ex = ExcelUtil.generateXlsxWorkbook("测试tab", propertyHeaderMap, dataSet);
            OutputStream out = new FileOutputStream("F://student3.xlsx");
            ex.write(out);
            System.out.println("导出成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
