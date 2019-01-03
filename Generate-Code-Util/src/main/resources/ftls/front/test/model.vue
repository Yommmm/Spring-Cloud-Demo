<template>
  <div class="model-index">
    <Spin v-if="spinShow" size="large" fix></Spin>
    <!-- 错误 -->
    <error-pages v-if="pageShow === 1" @refresh-page="queryWithPage" ></error-pages>
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
		<Page show-sizer show-elevator show-total size="small" placement="top" :current="currentPage" @on-change="pageChange" @on-page-size-change="pageSizeChange" :total="total" :page-size="pageSize" style="margin-left: 10px;" :page-size-opts="pageSizeList"></Page>
	  </div>
    </zlst-layout-f7>
    <detail v-if="detailShow" :id="id" @close="close"></detail>
    <add-or-edit v-if="addShow" :id="id" @close="close"></add-or-edit>
  </div>
</template>

<script>
import utils from "../../tools/utils.js";
import btn from "./children/btn.vue";
import detail from "./children/detail.vue";
import addOrEdit from "./children/addOrEdit.vue";
export default {
  name: "arriveIndex",
  components: {
      detail,
      addOrEdit,
  },
  data: function() {
    return {
      tableHeight: 0,
      pageShow: 0, //页面开关(0:空白页;1:错误页 ;2:主页)
      spinShow: true, //加载动画开关
      detailShow:false, //详情开关
      addShow:false, //新增开关
      id:null,//组件入参
      tableData:[],
      /**
       * 表格属性
       */
      columns: [
        {
          title: "业务类型",
          key: "flowTypeName",
          fixed: "left",
          sortable: true,
          width: 200
        },
        {
          title: "货品/物料",
          key: "goodsName",
          sortable: true,
          width: 200
        },
        {
          title: "供应商",
          key: "supplierName",
          width: 220
        },
        {
          title: "收货方",
          key: "receverName",
          width: 280
        },
        {
          title: " 采购单号",
          key: "purchaseOrder",
          width: 240
        },
        {
          title: "到货通知单号",
          key: "arriveNoteCode",
          width: 240
        },
        {
          title: "状态",
          key: "statusName",
          width: 150
        },
        {
          title: "车牌号",
          key: "licensePlateNumber",
          width: 210
        },
         {
          title: "操作人",
          key: "operateBy",
          //   sortable: true,
          minWidth: 150
        },
        {
          title: "操作",
          align: "center",
          fixed: "right",
          width: 100,
          render: (h, params) => {
            const row = params.row;
            return h(btn, {
              on: {
                detailsBtn: () => {
                  this.detailsBtn(row.arriveNoteId);
                },
                editBtn: () => {
                    this.editBtn(row.arriveNoteId)
                }
              }
            });
          }
        }
      ]
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
        this.detailShow=true;
    },
    
    /**
     * 页面控制方法区
     */
    // 分页查询表单数据
    queryWithPage: function() {
      var that = this;
      that.spinShow = false;
      that.pageShow = 2;
    },
    // 页面跳转
    pageChange: function(page) {
      this.queryPage = page;
      this.queryWithPage();
    },
    // 条数改变
    pageSizeChange: function(rows) {
      this.queryRows = rows;
      this.queryWithPage();
    },
  },

  mounted: function() {
      this.queryWithPage()
  }
};
</script>

<style lang="scss">
@import "styleKit.scss";

</style>
