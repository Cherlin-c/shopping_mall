package ${package.Controller};

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

import ${package.Entity}.${table.entityName};
import ${package.Service}.${table.serviceName};
import com.cloud.mall.common.utils.PageUtils;
import com.cloud.mall.common.utils.R;

/**
* <p>
    * ${table.comment!} 前端控制器jhhh
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
    @RestController
<#else>
    @Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
        public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
        public class ${table.controllerName} {
    </#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
    * 列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
    PageUtils page = ${table.serviceName?uncap_first}.queryPage(params);

    return R.ok().put("page", page);
    }


    /**
    * 信息
    */
    @RequestMapping("/{id}")
    public R info(@PathVariable("id") Long id){
    ${table.entityName} ${table.entityName?uncap_first} = ${table.serviceName?uncap_first}.getById(id);

    return R.ok().put("${table.entityName?uncap_first}", ${table.entityName?uncap_first});
    }

    /**
    * 保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ${table.entityName} ${table.entityName?uncap_first}){
    ${table.serviceName?uncap_first}.save(${table.entityName?uncap_first});

    return R.ok();
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ${table.entityName} ${table.entityName?uncap_first}){
    ${table.serviceName?uncap_first}.updateById(${table.entityName?uncap_first});

    return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Set<Long> ids){
    ${table.serviceName?uncap_first}.removeByIds(ids));

    return R.ok();
    }

    }
</#if>