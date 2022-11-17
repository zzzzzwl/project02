<template>
  <el-carousel :interval="4000" type="card" height="300px">
    <el-carousel-item v-for="item in items" :key="item">
      <h3 text="2xl" justify="center">
        <img :src="item.img" >
      </h3>
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  name: "Home",
  data(){
    return{
      items:[
        {img:require('../assets/images/如约而至.jpg')},
        {img:require('../assets/images/大千世界.jpg')},
        {img:require('../assets/images/经典咏流传.jpg')},
      ],

    }
  },
  methods:{
    setSize:function () {
      // 通过浏览器宽度(图片宽度)计算高度
      this.bannerHeight = 400 / 2160* this.screenWidth;
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
  }

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