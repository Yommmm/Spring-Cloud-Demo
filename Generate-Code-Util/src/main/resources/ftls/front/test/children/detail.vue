<template>
	<div class="detail-page zlst-layout-gap1">
     <BackTop></BackTop>
		<Spin size="large" fix v-if="spinShow"></Spin>
    <logistics-head icon="icon-daohuo" iconShadow :title="'单号：'+ detailsData.arriveNoteCode" @goBack="goBack" :hrShow="false">
         <span slot="tags">
        <z-tag color="green">{{detailsData.statusName}}</z-tag>
      </span>
        <!-- <span slot="second-line">
            <span class="zlst-margin-right-15px"></span>
          </span> -->
      </logistics-head>
    <div class="content zlst-margin-top-10px">
      <Tabs  class="zlst-classic-tabs-d4">
        <TabPane label="详情">
            <div class="logistics-wms-goods-arrive-arriveDetailPage zlst-margin-top-15px">
                <div class="zlst-detail-wrap-primary">
                <span class="fc-navi">基本信息</span>
                <ul class="zlst-detail-list-primary">
                    <li class="clearself">
                    <b>采购单号</b>
                    <span>{{detailsData.purchaseOrder | textFilter }} </span>
                    </li>
                    <li>
                    <b>合同号</b>
                    <span> {{detailsData.contractNo | textFilter }}</span>
                    </li>
                    <li class="clearself">
                    <b>供应商</b>
                    <span>{{detailsData.supplierName | textFilter }} </span>
                    </li>
                    <li>
                    <b>收货方(物流)</b>
                    <span>{{detailsData.companyName | textFilter }} </span>
                    </li>
                    <li class="clearself">
                    <b>收货方(实体)</b>
                    <span>{{detailsData.receverName | textFilter }} </span>
                    </li>
                    <li>
                    <b>采购日期</b>
                    <span>{{ detailsData.orderDate | timeFilter('yyyy/MM/dd HH:mm:ss') }} </span>
                    </li>
                    <li class="clearself">
                    <b>发货时间</b>
                    <span> {{ detailsData.shipDate | timeFilter('yyyy/MM/dd HH:mm:ss') }}</span>
                    </li>
                    <li>
                    <b>收货时间</b>
                    <span>{{ detailsData.arriveDate | timeFilter('yyyy/MM/dd HH:mm:ss') }} </span>
                    </li>
                    <li class="clearself">
                    <b>发货人</b>
                    <span>{{detailsData.consignorId | textFilter }} </span>
                    </li>
                    <li >
                    <b>收货人</b>
                    <span> {{detailsData.consigneeId | textFilter }}</span>
                    </li>
                    <li class="clearself">
                    <b>运输单号</b>
                    <span>{{detailsData.tmNote | textFilter }} </span>
                    </li>
                    <li class="clearself">
                    <b>车牌号</b>
                    <span> {{detailsData.licensePlateNumber | textFilter }}</span>
                    </li>
                    <li class="clearself">
                    <b>备注</b>
                    <span>{{detailsData.remark | textFilter }} </span>
                    </li>
                </ul>
                </div>
            </div>
         </TabPane>
        </Tabs>
      </div>
	</div>
</template>

<script>
import logisticsHead from "../../../components/logistics/logisticsHead.vue";
import utils from "../../../tools/utils.js";
export default {
  components: {
    logisticsHead
  },
  props:['id'],
  // 数据过滤
  filters: {
    textFilter: function(val) {
      return utils.isEmptyFilter(val);    
    },
    timeFilter: function(val, format) {
      return utils.timeEmptyFilter(val, format);
    }
  },
  data() {
    return {
      spinShow:false,
      detailsData: {
        "arriveNoteCode":"AADHD20181225000533",
        "receverName":null,
        "supplierName":"广西华磊新材料有限公司",
        "statusName":"已到货",
        "flowTypeName":"原料氧化铝入库",
        "contractNo":"123",
        "purchaseOrder":"123",
        "consignorId":null,
        "consigneeId":null,
        "tmNote":null,
        "orderDate":null,
        "licensePlateNumber":"43113",
        "arriveDate":1545729828000,
        "shipDate":null,
        "remark":"123",
        "companyName":"东南亚陆港"
      },
    };
  },
  methods: {
    goBack: function() {
      this.$emit("close");
    },
    queryGoodsArrive: function() {
      
    }
  },
  mounted: function() {
    this.queryGoodsArrive();
  }
};
</script>

<style  lang="scss">
@import "styleKit.scss";
.detail-page {
  font-size: $font-size-m;
  .zlst-detail-list-primary > li b {
    font-weight: normal;
    min-width: 90px;
  }
  .zlst-detail-list-primary {
    margin: 0;
  }
  .ivu-tabs-nav .ivu-tabs-tab-active {
    color: $color-font2;
  }
  .ivu-tabs-bar {
    border-bottom: 1px dashed #dddee1;
  }

}
</style>
