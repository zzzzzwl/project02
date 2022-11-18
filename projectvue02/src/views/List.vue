<template>
  <div class="home" style="padding: 10px">
    <!--    搜索区-->
    <div style="margin: 10px 0;">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable></el-input>
      <el-button type="primary" style="margin-left: 5px" @click="load" >查询</el-button>
    </div>
    <!--    表格区-->
    <el-table :data="tableData" border stripe style="width: 100%;display: flex;">
        <el-table-column prop="musicId" label="ID" sortable  />
        <el-table-column prop="songTitle" label="歌名" sortable  action=""/>
        <el-table-column prop="albumName" label="专辑名" sortable/>
        <el-table-column prop="publicationDate" label="发表日期" sortable/>
        <el-table-column prop="lyricist" label="作词" sortable/>
        <el-table-column prop="composer" label="作曲" sortable/>
        <el-table-column prop="arranger" label="编曲" sortable/>
        <el-table-column prop="songTitle">
          <template #default="scope">
            <el-tooltip
                class="box-item"
                effect="dark"
                content="播放"
                placement="top-start"
            >
              <el-link>
                <el-icon size="large"><CaretRight /></el-icon>
              </el-link>
            </el-tooltip>

            &nbsp;
            <el-tooltip
                class="box-item"
                effect="dark"
                content="下载"
                placement="top-start"
            >
              <el-link v-bind:href="'http://localhost:8888/files/music/'+tableData.at(scope.$index).songTitle">
                <el-icon size="large"><Download /></el-icon>
              </el-link>
            </el-tooltip>
          </template>

        </el-table-column>
    </el-table>
    <!--    分页栏-->
    <div style="margin: 10px 0">
      <el-pagination
          v-model:currentPage="currentPage"
          v-model:page-size="pageSize"
          :page-sizes="[20,total]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />

    </div>
  </div>
</template>

<script>
// @ is an alias to /src

import request from "@/utils/request";

export default {

  name: 'List',

  components: {

  },
  methods:{

    load(){
      request.get("/music",{
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

  },
  created() {
    this.load()
  },
  data(){
    return {
      search:'',
      dialogVisible: false,
      form:{},
      currentPage:1,
      pageSize:20,
      total:0,
      tableData:[],
    }
  }
}
</script>

<style>

</style>
