<template>
  <div class="${componentPre}-detail-content zlst-margin-top-15px">
    <div class="zlst-detail-wrap-primary">
      <span class="fc-navi">基本信息TODO</span>
      <ul class="zlst-detail-list-primary">
        <#list fields as fields>
		<#if fields.fieldName != "active" && fields.fieldName != "createdBy" && fields.fieldName != "createTime" 
		  && fields.fieldName != "modifiedBy" && fields.fieldName != "modifyTime">
        <li class="clearself">
          <b>${fields.frontColumnName}</b>
          <span>{{detailData.${fields.fieldName} | textFilter }} </span>
        </li>
        </#if>
		</#list>
      </ul>
    </div>
  </div>
</template>

<script>
import utils from "../../../tools/utils.js";
export default {
  name: "${packName}DetailContent",
  props: ["detailData"],
  // 数据过滤
  filters: {
    textFilter: function(val) {
      return utils.isEmptyFilter(val);
    },
    timeFilter: function(val, format) {
      return utils.timeEmptyFilter(val, format);
    },
  },
  data() {
    return {
    
    };
  },
  mounted:function(){
  
  }
};
</script>

<style lang="scss">

</style>
