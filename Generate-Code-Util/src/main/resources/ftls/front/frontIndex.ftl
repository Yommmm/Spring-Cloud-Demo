<template>
  <div class="${componentPre}-index">
    <Spin v-if="spinShow" size="large" fix></Spin>
    <!-- 错误 -->
    <error-pages v-if="pageShow === 1" @refresh-page="queryWithPage"></error-pages>
    <!-- 页面 -->
    <zlst-layout-f7 v-if="pageShow === 2 && !addShow && !detailShow" @table-height="(height)=> { tableHeight = height }">
      <!--上面固定标题栏区域-->
      <div slot="layout-menu">
        <z-table-menu>
          <div slot="z-table-menu-left">
            
          </div>
          <div slot="z-table-menu-right">
            <div style="text-align: right;float: right; line-height:34px">
                <i class="iconfont icon-plus" @click="toAdd()"> 新增 </i>
            </div>    
          </div>
        </z-table-menu>
        
      </div>
      <!-- 中间主体部分,内容区自适应，纵向内容过多，则出现纵向滚动条；整体页面宽度小于1280px，则出现横向滚动条 -->
      <div slot="layout-content-container">
        <!-- 主体表格 -->
        <Table stripe :columns="columns" :data="tableData" :height="tableHeight"></Table>
      </div>
      <div slot="layout-content-footer" class="zlst-page">
		<span class="totalNum">共 {{total}} 条</span>
		<z-page
          :total="totalNum"
          :current="queryPage"
          :page-size="queryRows"
          @on-change="onPageChange"
          @on-page-size-change="onPageSizeChange">
        </z-page>	  
        </div>
    </zlst-layout-f7>
    <${componentPre}-detail v-if="detailShow" :id="id" @close="close"></${componentPre}-detail>
    <${componentPre}-add-edit v-if="addShow" :id="id" @close="close"></${componentPre}-add-edit>
  </div>
</template>

<script>
import utils from "../../tools/utils.js";
import ${packName}Btn from "./children/${packName}Btn.vue";
import ${packName}Detail from "./children/${packName}Detail.vue";
import ${packName}AddEdit from "./children/${packName}AddEdit.vue";
export default {
  name: "${packName}Index",
  components: {
    ${packName}Btn,
    ${packName}Detail,
    ${packName}AddEdit
  },
  data: function() {
    return {
      tableHeight: 0,
      pageShow: 0, //页面开关(0:空白页;1:错误页 ;2:主页)
      spinShow: true, //加载动画开关
      detailShow: false, //详情开关
      addShow: false, //新增开关
      id: null, //组件入参
      tableData: [], //表单数据
      queryConditions: {}, //查询条件
      
      // 分页查询条件
      totalNum: 0,
      queryPage: 1,
      queryRows: 20,
      pageSizeList: [20, 40, 60, 80, 100],
      
      /**
       * 表格属性
       */
      columns: [
      	<#list fields as fields>
		<#if fields.fieldName != "active" && fields.fieldName != "createdBy" && fields.fieldName != "createTime" 
		  && fields.fieldName != "modifiedBy" && fields.fieldName != "modifyTime">
		{
		  title: "${fields.frontColumnName}",
          align: "center",
          width: 180,
          key: '${fields.fieldName}',
		},
		</#if>
		</#list>
      	{
          title: "操作",
          align: "center",
          fixed: "right",
          width: 100,
          render: (h, params) => {
            const row = params.row;
            return h(${packName}Btn, {
              on: {
                detailsBtn: () => {
                  this.detailsBtn(row.${packName}Id);
                },
              }
            });
          }
        }
      ],
    };
  },

  /**
   * 所有操作方法
   */
  methods: {
  	/**
  	 * 按钮方法区
  	 */
  	// 关闭按钮
    close: function(){
      this.detailShow = false;
      this.addShow = false;
      this.queryWithPage();
    },
    // 新增按钮
    toAdd: function(){
      this.pageShow = 0;
      this.id = null;
      this.addShow = true;
    },
    // 编辑按钮
    editBtn: function(id) {
      this.pageShow = 0;
      this.id = id;
      this.addShow = true;
    },
    // 详情按钮
    detailsBtn: function(id) {
      this.pageShow=0;
      this.id=id;
      this.detailShow = true;
    },
    
    /**
     * 页面控制方法区
     */
    // 分页查询表单数据
    queryWithPage: function() {
      var that = this;
      that.spinShow = true;
      
      var path = "${packName}Index";
      that.queryConditions.pageNum = this.queryPage;
      that.queryConditions.pageSize = this.queryRows;
      
      getData.post(path, that.queryConditions).then(function(res) {
        if (res.status === 200 && res.data.resultCode === 0) {
          that.spinShow=false;
          that.tableData  = res.data.data;
          that.totalNum = res.data.totalNum;
          that.pageShow = 2;
        } else {
          that.spinShow = false;
          that.pageShow = 1;
          that.$Message.error({
	        content: res.data.errorInfo.errorMsg,
	        duration: 3,
	        className: "ivu-message-error-g"
          });
        }
      );             
    },
    // 页面跳转
    onPageChange: function(page) {
      this.queryPage = page;
      this.queryWithPage();
    },
    // 条数改变
    onPageSizeChange: function(rows) {
      this.queryRows = rows;
      this.queryWithPage();
    },
  },

  mounted: function() {
    this.queryWithPage();
  }
};
</script>

<style lang="scss">
@import "styleKit.scss";

</style>
