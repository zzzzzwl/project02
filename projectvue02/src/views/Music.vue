<template>
  <div class="home" style="padding: 10px">
<!--    功能区-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add()">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
<!--    搜索区-->
    <div style="margin: 10px 0;">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable></el-input>
      <el-button type="primary" style="margin-left: 5px" @click="load" >查询</el-button>
    </div>
<!--    表格区-->
    <el-table :data="tableData" border stripe style="width: 100%;display: flex;">
      <el-table-column prop="musicId" label="ID" sortable  />
      <el-table-column prop="songTitle" label="歌名" sortable  />
      <el-table-column prop="albumName" label="专辑名" sortable/>
      <el-table-column prop="publicationDate" label="发表日期" sortable/>
      <el-table-column prop="lyricist" label="作词" sortable/>
      <el-table-column prop="composer" label="作曲" sortable/>
      <el-table-column prop="arranger" label="编曲" sortable/>
      <el-table-column fixed="right" label="操作" width="180">
        <template #default="scope">
          <el-button @click="handleEdit(scope.row)" >编辑</el-button>
          <el-popconfirm title="确认删除吗?" @confirm="handleDelete(scope.row.musicId)">
            <template #reference>
              <el-button type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
<!--    分页栏-->
    <div style="margin: 10px 0">
      <el-pagination
          v-model:currentPage="currentPage"
          v-model:page-size="pageSize"
          :page-sizes="[5,10,20]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />

    </div>
<!--    新增弹窗-->
    <el-dialog
        v-model="dialogVisible"
        title="提示"
        width="30%"
    >
      <el-form  :model="form" label-width="120px">
        <el-form-item label="歌名">
          <el-input v-model="form.songTitle" style="width: 80%" />
        </el-form-item>
        <el-form-item label="专辑名">
          <el-input v-model="form.albumName" style="width: 80%"/>
        </el-form-item>

        <el-form-item label="发表日期">
          <div class="block">
            <el-date-picker
                v-model="form.publicationDate"
                type="date"
                placeholder="选择日期"
                :size="size"
            />
          </div>
        </el-form-item>
        <el-form-item label="作词">
          <el-input v-model="form.lyricist" style="width: 80%" />
        </el-form-item>
        <el-form-item label="作曲">
          <el-input v-model="form.composer" style="width: 80%" />
        </el-form-item>
        <el-form-item label="编曲">
          <el-input v-model="form.arranger" style="width: 80%" />
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">返回</el-button>
        <el-button type="primary" @click="save" click="dialogVisible = false">
          确定
        </el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
// @ is an alias to /src

import request from "@/utils/request";

export default {

  name: 'Music',

  components: {

  },
  created() {
    this.load()
  },
  methods:{

    add(){
      this.dialogVisible =true
      this.form = {}
    },
    save(){
      if (this.form.musicId){
        request.put("/api/music",this.form).then(res =>{
          console.log(res)
          if (res.code==='0'){
            this.$message({
              type:"success",
              message:"更新成功"
            })
          }else {
            this.$message({
              type:"error",
              message:res.msg
            })
          }



        })


      }else{
        request.post("/api/music",this.form).then(res =>{
          console.log(res)
          this.$message({
            type:"success",
            message:"新增成功"
          })


        })
      }
      this.load()
      this.dialogVisible=false
    },
    load(){
      request.get("/api/music",{
        params:{
          pageNum:this.currentPage,
          pageSize:this.pageSize,
          search:this.search
        }
      }).then(res=>{
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    handleSizeChange(pageSize){
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      this.currentPage=pageNum
      this.load()
    },
    handleDelete(userId){
      console.log(userId)
      request.delete("/api/music/" + userId).then(res=>{
        if (res.code==='0'){
          this.$message({
            type:"success",
            message:"删除成功"
          })
        }
        this.load()
      })
    },
    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible=true

    },

  },
  data(){
    return {
      search:'',
      dialogVisible: false,
      form:{},
      currentPage:1,
      pageSize:10,
      total:0,

      tableData:[],
    }
  }
}
</script>
