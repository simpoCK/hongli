package com.hxy.finance.voucher.action;

import com.hxy.base.annotation.SysLog;
import com.hxy.base.utils.PageUtils;
import com.hxy.base.utils.Query;
import com.hxy.base.utils.Result;
import com.hxy.sys.entity.OrganEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 凭证管理
 * @author chenkun
 * @version 1.0
 * @since 2017年11月20日
 */
@RestController
@RequestMapping("finance/voucher")
public class VoucherAction {


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("finance:voucher:list")
    @SysLog("查看凭证列表")
    public Result list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<OrganEntity> organList = new ArrayList<>();
        int total = 0;
        PageUtils pageUtil = new PageUtils(organList, total, query.getLimit(), query.getPage());
        return Result.ok().put("page", pageUtil);
    }


}
