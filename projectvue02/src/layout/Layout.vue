<template>
  <div>
    <!--    头部-->
    <Header :user="user"></Header>
    <!--    主体-->
    <div style="display: flex">

      <!--      侧边栏-->
      <Aside></Aside>
      <!--      内容区域-->
      <router-view style="flex: 1" @userInfo="refreshUser" :getmusicurl="getmusicurl" />
    </div>
    <!--    底栏播放组件-->
    <Bottom ref="Bottom"></Bottom>
  </div>
</template>

<script>
import Header from "@/components/Header";
import Aside from "@/components/Aside";
import Bottom from "@/components/Bottom";
import request from "@/utils/request";
export default {
  name: "Layout",
  components:{
    Header,
    Aside,
    Bottom

  },
  data() {
    return {
      user: {},
      musicurl:''
    }
  },
  created() {
    this.refreshUser()
  },
  methods:{
    refreshUser(){
      let userJson = sessionStorage.getItem("user");
      if (!userJson) {
        return
      }
      let userId = JSON.parse(userJson).userId
      // 从后台取出更新后的最新用户信息
      request.get("/user/" + userId).then(res => {
        this.user = res.data
      })


    },
    getmusicurl(musicurl){
      this.musicurl=musicurl
      console.log(this.musicurl)
      this.$refs.Bottom.$data.musicurl=this.musicurl
      this.$refs.Bottom.play1();
    }
  }
}
</script>

<style scoped>

</style>