<template>
  <div>
    <imp-panel>
        <h3 class="box-title" slot="header" style="width: 100%;">
          <el-row style="width: 100%;">
            <el-col :span="12">
              <el-button type="primary" icon="el-icon-plus" @click="handleAdd">新增</el-button>
              <!-- <router-link :to="{ path: 'userAdd'}">
                
              </router-link> -->
            </el-col>
            <el-col :span="12">
              <div class="el-input" style="width: 200px; float: right;">
                <i class="el-input__icon el-icon-search"></i>
                <input type="text" placeholder="输入用户名称" v-model="searchKey" @keyup.enter="search($event)"
                        class="el-input__inner">
              </div>
            </el-col>
          </el-row>
        </h3>
        <div slot="body" v-loading="listLoading">
          <el-table
            :data="tableData.rows"
            border
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <!--checkbox 适当加宽，否则IE下面有省略号 https://github.com/ElemeFE/element/issues/1563-->
            <el-table-column
              prop="id"
              type="selection"
              width="50">
            </el-table-column>
            <el-table-column
              label="图片" width="76">
              <template slot-scope="scope">
                <img :src='scope.row.pictrue' style="height: 35px;vertical-align: middle;" alt="">
              </template>
            </el-table-column>
            <el-table-column
              prop="sku"
              label="SKU">
            </el-table-column>
            <el-table-column
              prop="cnName"
              label="产品名称">
            </el-table-column>
            <el-table-column
              prop="weight"
              label="重量">
            </el-table-column>
            <el-table-column
              prop="price"
              label="价格">
            </el-table-column>
            <el-table-column
              prop="supplierName"
              label="供应商名称">
            </el-table-column>
            <el-table-column
              prop="skuLink"
              label="供应商产品详情链接">
            </el-table-column>
            <el-table-column
              prop="salesVolume"
              label="销量">
            </el-table-column>
            <el-table-column label="操作" width="285">
              <template slot-scope="scope">
                <el-button
                  size="small"
                  type="default"
                  icon="edit"
                  @click="handleEdit(scope.$index, scope.row)">编辑
                </el-button>
                <el-button
                  size="small"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除
                </el-button>
              </template>
            </el-table-column>
          </el-table>
    
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="tableData.pagination.pageNo"
            :page-sizes="[5, 10, 20]"
            :page-size="tableData.pagination.pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="tableData.pagination.total">
          </el-pagination>
        </div>
      </imp-panel>
      <el-dialog title="新增产品" :visible.sync="formVisible">
        <div>
          <el-form ref="formData" :model="formData" :rules="formRules" label-width="120px">
            <el-form-item label="SKU" prop="sku">
              <el-input name="sku" v-model="formData.sku"></el-input>
            </el-form-item>
            <el-form-item label="产品名称" prop="cnName">
              <el-input name="cnName" v-model="formData.cnName"></el-input>
            </el-form-item>
            <el-form-item label="重量" prop="weight">
              <el-input name="weight" type="number" v-model="formData.weight"></el-input>
            </el-form-item>
            <el-form-item label="价格" prop="price">
              <el-input name="price" type="number" v-model="formData.price"></el-input>
            </el-form-item>
            <el-form-item label="供应商名称" prop="supplierName">
              <el-input name="supplierName" v-model="formData.supplierName"></el-input>
            </el-form-item>
            <el-form-item label="供应商产品链接" prop="skuLink">
              <el-input name="skuLink" v-model="formData.skuLink"></el-input>
            </el-form-item>
            <el-form-item label="销量" prop="salesVolume">
              <el-input name="salesVolume" v-model="formData.salesVolume"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="formVisible = false">取 消</el-button>
          <el-button type="primary" @click="addSave" :loading="saveLoading">保 存</el-button>
        </div>
      </el-dialog>
  </div>
</template>

<script>
import panel from '@/components/Panel'
import { getList, deleted, update, add } from '@/api/product'

export default {
  components: {
    'imp-panel': panel
  },
  data() {
    /* const validatePass = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('密码不能小于6位'))
      } else {
        callback()
      }
    }*/
    return {
      currentRow: {},
      formVisible: false,
      saveLoading: false,
      listLoading: false,
      defaultProps: {
        children: 'children',
        label: 'name',
        id: 'id'
      },
      searchKey: '',
      tableData: {
        pagination: {
          total: 0,
          pageNo: 1,
          pageSize: 10,
          parentId: 0
        },
        rows: []
      },
      formData: {
        id: 0,
        sku: '',
        cnName: '',
        weight: 0,
        price: 0,
        supplierName: '',
        skuLink: '',
        salesVolume: 0
      },
      formRules: {
        sku: [{ required: true, trigger: 'blur' }],
        cnName: [{ required: true, trigger: 'blur' }]
      }
    }
  },
  methods: {
    addSave() {
      this.$refs.formData.validate(valid => {
        if (valid) {
          this.saveLoading = true
          add(this.formData).then(res => {
            this.saveLoading = false
            this.formVisible = false
            this.$message(res.message)
            this.loadData()
          }).catch(error => {
            this.saveLoading = false
            this.$message.error(error)
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    editSave() {
      this.$refs.formData.validate(valid => {
        if (valid) {
          this.saveLoading = true
          update(this.formData).then(res => {
            this.saveLoading = false
            this.formVisible = false
            this.$message(res.message)
            this.loadData()
          }).catch(error => {
            this.$message.error(error)
          })
        } else {
          return false
        }
      })
    },
    search(target) {
      this.loadData()
    },
    handleSelectionChange(val) {
      console.log(val)
    },
    handleSizeChange(val) {
      this.tableData.pagination.pageSize = val
      this.loadData()
    },
    handleCurrentChange(val) {
      this.tableData.pagination.pageNo = val
      this.loadData()
    },
    handleAdd() {
      this.formData = {
        id: '',
        sku: '',
        cnName: '',
        weight: 0,
        price: 0,
        supplierName: '',
        skuLink: '',
        salesVolume: 0
      }
      this.formVisible = true
    },
    handleEdit(index, row) {
      this.formVisible = true
      this.formData = { ...row }
      // console.log(row)
      // this.$router.push({
      //   path: 'userAdd', query: {
      //     id: row.id
      //   }
      // })
    },
    handleDelete(index, row) {
      deleted({ id: row.id }).then(res => {
        this.$message(res.message)
        this.loadData()
      }).catch(error => {
        this.$message.error(error)
      })
    },
    loadData() {
      this.listLoading = true
      getList({
        sku: this.searchKey,
        pagination: {
          size: this.tableData.pagination.pageSize,
          current: this.tableData.pagination.pageNo
        }
      }).then(res => {
        this.listLoading = false
        this.tableData.rows = res.data.list
        this.tableData.pagination.total = res.data.totalCount
        // this.tableData.pagination.pageSize = res.data.totalPage
      }).catch(error => {
        this.listLoading = false
        this.$message.error(error)
      })
    }
  },
  created() {
    this.loadData()
  }
}
</script>
<style>
  .el-pagination {
    float: right;
    margin-top: 15px;
  }
</style>
  