<template>
  <div id="normal-user-handle-btn">
    <div class="zlst-operation-area">
      <span class="operation-btn" @click="detailsBtn">查看</span>

      <Dropdown @on-click="details" transfer placement="bottom-end">
        <a href="javascript:void(0)">
          <i class="iconfont icon-more"></i>
        </a>
        <DropdownMenu slot="list">
          <DropdownItem name="editBtn">复制</DropdownItem>
        </DropdownMenu>
        
        <DropdownMenu slot="list">
          <DropdownItem name="editBtn">编辑</DropdownItem>
        </DropdownMenu>
        
        <DropdownMenu slot="list">
          <DropdownItem name="editBtn">删除</DropdownItem>
        </DropdownMenu>
        
        <DropdownMenu slot="list">
          <DropdownItem name="editBtn">启用</DropdownItem>
        </DropdownMenu>
        
        <DropdownMenu slot="list">
          <DropdownItem name="editBtn">禁用</DropdownItem>
        </DropdownMenu>
      </Dropdown>
    </div>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
    
    }
  },
  methods: {
    details: function (name) {
      if(name == "editBtn"){
        this.$emit('editBtn');
      }
    },
    detailsBtn: function(){
      this.$emit('detailsBtn');
    }
  },
  mounted: function () {
  
  }
}
</script>

<style scoped lang="scss">
#normal-user-handle-btn{
	.handle-btn {
		.arrow-down-b-icon {
			-webkit-transition: all .5s;
			-moz-transition: all .5s;
			transition: all .5s;
		}
	}
	.handle-btn:hover {
		.arrow-down-b-icon {
			-webkit-transition: all .5s;
			-moz-transition: all .5s;
			transition: all .5s;
			-webkit-transform: rotate(180deg);
			-moz-transform: rotate(180deg);
			-o-transform: rotate(180deg);
			-ms-transform: rotate(180deg);
			transform: rotate(180deg);
		}
	}
}
</style>
