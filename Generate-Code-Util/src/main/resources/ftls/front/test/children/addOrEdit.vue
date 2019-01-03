<template>
  <div class="add-or-edit zlst-layout-gap1">
    <BackTop></BackTop>
    <Spin size="large" fix v-if="spinShow"></Spin>
    <logistics-head icon="icon-daohuo" iconDashed :title="utils.isEmpty(id)?'新增':'修改'" hr-show @goBack="goBack">
      <span slot="second-line">
        <span  v-if='utils.isEmpty(id)' >
          <span class="zlst-margin-right-15px">创建人：{{createdBy}}</span>
          <span class="zlst-margin-right-15px">创建时间：{{utils.startDate(new Date())}}</span>
        </span>
        <span v-if='!utils.isEmpty(id)' class="zlst-margin-right-15px">单号：{{goodsArrive.arriveNoteCode}}</span>
      </span>
    </logistics-head>
    <div class="main-div zlst-padding-top-10px">
      <Form ref="validate" :model="goodsArrive" :rules="rules" :label-width="100" :grid="2" class="zlst-padding-top-15px">    
       <FormItem prop="purchaseOrder" label="采购单号" fullField="采购单号">
          <Input v-model="goodsArrive.purchaseOrder" placeholder="输入" class="ivu-form-item-width" />
        </FormItem>
        <FormItem prop="contractNo" label="合同号" fullField="合同号">
          <Input v-model="goodsArrive.contractNo" placeholder="输入" class="ivu-form-item-width" />
        </FormItem>
        <Form-item prop="consignorId" label="发货人" fullField="发货人">
          <Input v-model="goodsArrive.consignorId" placeholder="输入" class="ivu-form-item-width" />
        </Form-item>
        <Form-item prop="consigneeId" label="收货人" fullField="收货人">
          <Input v-model="goodsArrive.consigneeId" placeholder="输入" class="ivu-form-item-width" />
        </Form-item>
        <Form-item prop="tmNote" label="运输单号" fullField="运输单号">
          <Input v-model="goodsArrive.tmNote" placeholder="输入" class="ivu-form-item-width" />
        </Form-item>
        <div class="clearfix"></div>
        <Form-item prop="remark" label="备注" fullField="备注" style="margin-top:5px;">
          <Input type="textarea" v-model="goodsArrive.remark" placeholder="输入" style="width:706px" />
        </Form-item>
      </Form>
      <div class="zlst-form-operate">
        <Button :loading="loading" type="primary" @click="handleSubmit('validate')">确定</Button>
        <Button type="warning" @click="goBack" style="margin-left: 10px;">取消</Button>
      </div>
    </div>
    </div>
</template>

<script>
import logisticsHead from "../../../components/logistics/logisticsHead.vue";
import utils from "../../../tools/utils";
export default {
  components: {
    logisticsHead
  },
   props: ['id'],
  computed:{
  },
  data() {
    return {
      createdBy:"",
      utils:utils,
      spinShow:true,
      loading:false,
      //到货基础信息
      goodsArrive: {
        purchaseOrder: null,
        contractNo: null,
        consignorId: null,
        consigneeId: null,
        tmNote: null,
        remark: null,
      },
      //基础信息校验
      rules: {  
      }
    };
  },
  methods: {
    // 返回
    goBack: function() {
      var that = this;
      that.$Modal.confirm({
        content: "是否取消"+((utils.isEmpty(that.id))?"新增":"修改")+"操作？",
        onOk: function() {
          that.$emit("close");
        },
        okText: "是",
        cancelText: "否"
      });
    },
    //提交按钮，含校验
    handleSubmit: function(name) {
      var that = this
      that.$refs[name].validate(valid => {
         that.$emit("close");
         this.loading=false;
      });
    },
    queryDetail:function(){
     this.spinShow=false;   
     this.goodsArrive={
        "arriveNoteCode":"AADHD20181225000533",
        "statusName":"已到货",
        "flowTypeName":"原料氧化铝入库",
        "contractNo":"123",
        "purchaseOrder":"123",
        "consignorId":"张三",
        "consigneeId":"李四",
        "tmNote":"TK123456",
        "remark":"123",
      }
    }
  },
  //页面加载时候调用
  mounted: function() {
    if(utils.isEmpty(this.id)){
      this.spinShow=false;
    }else{
      this.queryDetail();
    }
  }
};
</script>
<style lang="scss">
@import "styleKit.scss";
.add-or-edit {
  background-color: $color-body;
  font-size: $font-size-m;
  .min-input-width-autocar {
    width: 140px;
  }
  .min-input-width{
    width:200px
  }
  .zlst-dwl-unit {
    color: $color-font6;
  }
  .modal-form .ivu-form-item {
    margin-bottom: 17px;
}
  .yhl-modal {
    .ivu-form-item .ivu-form-item {
      display: inline-block;
    }
  }
  .ivu-tag {
    font-size: 14px;
    height: 26px;
    border-radius: 0px;
    padding: 0 8px;
    line-height: 23px;
  }
  .ivu-tag-border {
    border: 1px solid #dddee1 !important;
  }
  .ivu-tag .ivu-icon-ios-close-empty:hover {
    color: $color-button-ensure-hover !important;
  }
}
</style>
