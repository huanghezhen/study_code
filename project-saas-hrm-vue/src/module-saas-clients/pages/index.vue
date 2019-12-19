<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">

        <el-table :data="dataList" border style="width: 100%">
          <el-table-column fixed type="index" label="序号" width="50"/>
          <el-table-column fixed prop="name" label="名称" width="150"/>
          <el-table-column fixed prop="version" label="版本" width="150"/>
          <el-table-column fixed prop="companyPhone" label="电话" width="150"/>
          <el-table-column fixed prop="expirationDate" label="截至时间" width="150"/>
          <el-table-column fixed prop="state" label="状态" width="150">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.state"
                inactive-value="0"
                active-value="1"
                disabled
                active-color="#13ce66"
                inactive-color="#ff4949"/>
            </template>
          </el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
              <template slot-scope="scope">
                <router-link :to="'/saas-clients/detail/'+scope.row.id">查看</router-link>
              </template>
            </el-table-column>
        </el-table>
      </el-card>
     </div>
  </div>
</template>

<script>
import {list} from '@/api/base/saasClients'
export default {
  name: 'saas-clients-index',
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
