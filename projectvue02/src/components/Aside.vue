<template>
      <el-menu
          style="width: 200px;min-height: calc(100vh - 50px)"
          default-active="home"
          :default-openeds="[1]"
          class="el-menu-vertical-demo"
          router
      >
        <el-menu-item index="home">
          <template #title>
            <el-icon><House /></el-icon>
            主页
          </template>
        </el-menu-item>

        <el-menu-item index="list">
          <template #title>
            <el-icon><List /></el-icon>
            歌单
          </template>
        </el-menu-item>

        <el-menu-item index="album">
          <template #title>
            <el-icon><Notebook /></el-icon>
            专辑
          </template>
        </el-menu-item>



        <el-sub-menu index="1">
          <template #title>
            <el-icon><HomeFilled /></el-icon>
            系统管理
          </template>
            <el-menu-item index="user" >
              <el-icon><UserFilled /></el-icon>
              用户管理
            </el-menu-item>
            <el-menu-item index="music">
              <el-icon><Service /></el-icon>
              音乐管理
            </el-menu-item>
        </el-sub-menu>

      </el-menu>
</template>
<script>
import Music from "@/views/Music";
import {Location} from "@element-plus/icons";
export default {
  components: {Location, Music}
}
</script>