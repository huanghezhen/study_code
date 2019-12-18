<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        saas页面
      </el-card>
     </div>
  </div>
</template>

<script>
import {list} from '@/api/base/saasClients'
export default {
  name: 'saas-clients-table-index',
  data() {

  },
  methods: {
    getList() {
      list().then(result => {
        console.log(result)
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
