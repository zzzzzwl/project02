<template>
  <div >
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in items" :key="item">
        <h3 text="2xl" justify="center">
          <img :src="item.img" >
        </h3>
      </el-carousel-item>
    </el-carousel>
    <h3>热歌推荐</h3>
    <el-table :data="tableData" stripe style="width: 100%;"   size="large">
      <el-table-column  label="排行"  type="index" width="200"/>
      <el-table-column prop="songTitle" label="歌名" width="200"/>
      <el-table-column prop="albumName" label="专辑" width="200"/>
      <el-table-column prop="" label="点击量" width="200"/>
      <el-table-column prop="" label="时长" width="200"/>
      <el-table-column fixed="right" label="" >
        <template #default="scope">
          <el-tooltip
              class="box-item"
              effect="dark"
              content="播放"
              placement="top-start"
          >
          <el-icon size="large"><CaretRight /></el-icon>
          </el-tooltip>
          &nbsp;
          <el-tooltip
              class="box-item"
              effect="dark"
              content="操作"
              placement="top-start"
          >
          <el-icon size="large"><Plus /></el-icon>
          </el-tooltip>
          &nbsp;
          <el-tooltip
              class="box-item"
              effect="dark"
              content="收藏"
              placement="top-start"
          >
          <el-icon size="large"><StarFilled /></el-icon>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
import request from "@/utils/request";

export default {
  name: "Home",

  data(){
    return{
      items:[
        {img:require('../assets/images/如约而至.jpg')},
        {img:require('../assets/images/大千世界.jpg')},
        {img:require('../assets/images/经典咏流传.jpg')},
      ],

      tableData:[
      ],
      dialogVisible: false,
      form:{},
      currentPage:1,
      total:0,
      pageSize:10,
    }
  },

  methods:{
    setSize:function () {
      // 通过浏览器宽度(图片宽度)计算高度
      this.bannerHeight = 400 / 2160* this.screenWidth;
    },
    load(){
      request.get("/music/recommend",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize,
        }
      }).then(res=>{
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
  },
  mounted() {
    // 首次加载时,需要调用一次
    this.screenWidth =  window.innerWidth;
    this.setSize();
    // 窗口大小发生改变时,调用一次
    window.onresize = () =>{
      this.screenWidth =  window.innerWidth;
      this.setSize();
    }
  },

  created() {
    this.load()
  },

}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
img{
  /*设置图片宽度和浏览器宽度一致*/
  width:100%;
  height:inherit;
}
</style>