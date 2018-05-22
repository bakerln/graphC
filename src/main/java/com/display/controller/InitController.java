package com.display.controller;
import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import com.display.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by LiNan on 2018-04-25.
 * Description: 初始化箱场
 */
@Controller
@RequestMapping(value = "/init")
public class InitController {

    @Autowired
    private InitService initService;

    /**
     *  初始化箱场，通过版本记录
     * @param response
     */

    @RequestMapping(value = "/initElement")
    public void addElement(HttpServletResponse response, String diagramValue){

        //分解数据
        HashMap dataMap = (HashMap) JsonUtil.toObject(diagramValue,Map.class);
        ArrayList dataList = (ArrayList) dataMap.get("nodeDataArray");
        List area = new LinkedList();
        List group = new LinkedList();
        for (Object data:dataList) {
           HashMap one = (HashMap) data;
           if ("OfGroups".equals(one.get("category"))||"OfGroupsT".equals(one.get("category"))){
               area.add(one);
           }else {
               group.add(one);
           }
        }
        //Version
        String version = initService.getVersion();

        //保存数据
        initService.addInitArea(area,version);

        initService.addInitGroup(group,version);

        //TODO 清空Container表字段（isplan = 3）

        WebUtil.out(response, JsonUtil.createOperaStr(true,"init success"));
    }

}
