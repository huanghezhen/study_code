<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        <div v-for="(item,index) in dataList" :key="index">
          {{item.id}} + {{item.name}}
        </div>
      </el-card>
     </div>
  </div>
</template>

<script>
import {list} from '@/api/base/saasClients'
export default {
  name: 'saas-clients-table-index',
  data() {
    return {
      dataList:[]
    }
  },
  methods: {
    getList() {
      list().then(result => {
        this.dataList = result.data.data
      })
    }
  },
  // 创建完毕状态
  created() {
    this.getList()
  },
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.alert {
  margin: 10px 0px 0px 0px;
}
.pagination {
  margin-top: 10px;
  text-align: right;
}
</style>
