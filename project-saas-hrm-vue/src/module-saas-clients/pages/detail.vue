<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        <el-tabs v-model="activeName">
          <el-tab-pane label="企业信息" name="first">
            <el-form ref="form" :model="detail" label-width="80px">
              <el-form-item label="名称">
                <el-input v-model="detail.name" disabled></el-input>
              </el-form-item>

              <el-form-item label="公司地址">
                <el-input v-model="detail.companyAddress" disabled></el-input>
              </el-form-item>

              <el-form-item label="公司电话">
                <el-input v-model="detail.companyPhone" disabled></el-input>
              </el-form-item>

              <el-form-item label="邮箱">
                <el-input v-model="detail.mailbox" disabled></el-input>
              </el-form-item>
              <el-form-item label="备注">
                <el-input v-model="detail.remarks"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary">审核</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-form>
          </el-tab-pane>
          <el-tab-pane label="账户信息" name="second">账户信息</el-tab-pane>
          <el-tab-pane label="交易记录" name="third">交易记录</el-tab-pane>
        </el-tabs>
      </el-card>
    </div>
  </div>
</template>

<script>
  import {detail} from '@/api/base/saasClients'
  export default {
    name: 'saas-clients-detail',
    data() {
      return {
        activeName: 'first',
        detail: {}
      }
    },
    methods: {
      getDetail(id) {
        detail({id:id}).then(result => {
          this.detail = result.data.data
          console.log(id)
          console.log(this.detail)
        })
      }
    },
    // 创建完毕状态
    created() {
      let id = this.$route.params.id
      this.getDetail(id)
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
