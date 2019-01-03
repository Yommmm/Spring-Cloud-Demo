<template>
  <div class="zlst-logistics-alIngoInfoDetil zlst-layout-gap1">
    <Spin size="large" fix v-if="spinShow"></Spin>
    <div v-if="!spinShow && !errorShow">
      <logistics-head icon="icon-owNote" iconShadow :title="'TODO:' + 'TODO'" @goBack="goBack" :hrShow="false">
        <span slot="tags">
          <z-tag color="green">TODO</z-tag>
        </span>
        <span slot="second-line">
          <span class="zlst-margin-right-15px">TODO：TODO</span>
        </span>
        </logistics-head>
        <div class="content">
	      <Tabs :animated="false" class="zlst-classic-tabs-d4">
	        <TabPane label="信息详情">
	          <${componentPre}-detail-content :detailData="detailData"></${componentPre}-detail-content>
	        </TabPane>
	      </Tabs>
        </div>
     </div>
     <error-pages v-if="errorShow" @refresh-page="queryDetail" :showGobackBtn="false"></error-pages>
  </div>
</template>

<script>
import logisticsHead from "../../../components/logistics/logisticsHead.vue";
import getData from "../../../api/server/getData.js";
import ${packName}DetailContent from "./${packName}DetailContent.vue";
import utils from "../../../tools/utils.js";
import { API_LIST } from "../../../api/server/config.js";
export default {
  name: "${packName}Detail",
  components: {
    ${packName}DetailContent,
    logisticsHead
  },
  props:["id"],
  data: function() {
    return {
      spinShow: true,
      errorShow: false,
      detailData: [], //详情数据
    };
  },
  filters: {
    timeFilter: function(val, format) {
      return utils.timeEmptyFilter(val, format);
  	}
  },
  mounted: function() {
    this.queryDetail();
  },
  methods: {
    goBack: function() {
      this.$emit("closeMain");
    },
    //查询详情
    queryDetail() {
      var that = this;
      that.errorShow = false;
      that.spinShow = true;
      var path = "${packName}Detail";
      getData.getRestful(path, {${packName}Id: that.id}).then(function(res) {
        if (res.status === 200 && res.data.resultCode === 0) {
          that.spinShow=false;
          that.detailsData  = res.data.data;
        } else {
          that.spinShow = false;
          that.errorShow = true;
          that.$Message.error({
            content: res.data.errorInfo.errorMsg,
            duration: 3,
            className: "ivu-message-error-g"
          });
        }
      });
    },
    //关闭组件页面
    closeDetail:function(){
      this.$emit("closeDetail")
    }
  }
};
</script>

<style  lang="scss">
@import "styleKit.scss";

</style>