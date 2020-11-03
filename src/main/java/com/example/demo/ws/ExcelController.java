package com.example.demo.ws;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.example.demo.file.ExcelUtils;
import com.example.demo.mybatis.pojo.BillResolve;
import com.example.demo.mybatis.service.IBillResolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExcelController
 * @Description Excel导入导出控制器
 * @Autor ansonglin
 * @Date 2019/4/29 18:46
 * @Version 1.0
 **/
@RestController
@RequestMapping("/Excel")
public class ExcelController {

    @Autowired
    private IBillResolveService iBillResolveService;

    @GetMapping("/export")
    public void export(HttpServletResponse response) {
//        模拟从数据库获取需要导出的数据
        List<BillResolve> personList = iBillResolveService.list();
//         导出操作
        ExcelUtils.exportExcel(personList, "测试名sdsdsdddsdsdsdssdsds", "单据信息", BillResolve.class, "测试.xls", response);
//         Workbook sheets = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生", ExcelType.XSSF),
////                BillResolve.class, personList);
    }


    @PostMapping("/importExcel")
    public void importExcel2(@RequestParam("file") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);

        // 需要验证
        importParams.setNeedVerfiy(true);

        try {
            ExcelImportResult<BillResolve> result = ExcelImportUtil.importExcelMore(file.getInputStream(), BillResolve.class, importParams);

            List<BillResolve> successList = result.getList();
            iBillResolveService.saveBatch(successList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //创建
        Map<String,Object> map = new HashMap<>();
        //存
        map.put("key","value");
        //取
        Object value = map.get("key");

    }

}

























